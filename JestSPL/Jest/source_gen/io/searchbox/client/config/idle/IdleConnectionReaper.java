package io.searchbox.client.config.idle;

/*Generated by MPS */

import com.google.common.util.concurrent.AbstractScheduledService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.searchbox.client.config.ClientConfig;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.MoreExecutors;

public class IdleConnectionReaper extends AbstractScheduledService {

  /*package*/ static final Logger logger = LoggerFactory.getLogger(IdleConnectionReaper.class);
  private final ReapableConnectionManager reapableConnectionManager;
  private final ClientConfig clientConfig;
  public IdleConnectionReaper(ClientConfig clientConfig, ReapableConnectionManager reapableConnectionManager) {
    this.reapableConnectionManager = reapableConnectionManager;
    this.clientConfig = clientConfig;
  }
  @Override
  protected void runOneIteration() throws Exception {
    logger.debug("closing idle connections...");
    reapableConnectionManager.closeIdleConnections(clientConfig.getMaxConnectionIdleTime(), clientConfig.getMaxConnectionIdleTimeDurationTimeUnit());
  }
  @Override
  protected AbstractScheduledService.Scheduler scheduler() {
    return AbstractScheduledService.Scheduler.newFixedDelaySchedule(0L, clientConfig.getMaxConnectionIdleTime(), clientConfig.getMaxConnectionIdleTimeDurationTimeUnit());
  }
  @Override
  protected ScheduledExecutorService executor() {
    final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setDaemon(true).setNameFormat(serviceName()).build());
    // Add a listener to shutdown the executor after the service is stopped.  This ensures that the 
    // JVM shutdown will not be prevented from exiting after this service has stopped or failed. 
    // Technically this listener is added after start() was called so it is a little gross, but it 
    // is called within doStart() so we know that the service cannot terminate or fail concurrently 
    // with adding this listener so it is impossible to miss an event that we are interested in. 
    addListener(new Service.Listener() {
      @Override
      public void terminated(Service.State from) {
        executor.shutdown();
      }
      @Override
      public void failed(Service.State from, Throwable failure) {
        executor.shutdown();
      }
    }, MoreExecutors.directExecutor());
    return executor;
  }
}
