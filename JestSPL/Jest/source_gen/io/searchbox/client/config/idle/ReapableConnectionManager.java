package io.searchbox.client.config.idle;

/*Generated by MPS */

import java.util.concurrent.TimeUnit;

public interface ReapableConnectionManager {
  public void closeIdleConnections(long idleTimeout, TimeUnit unit);
}
