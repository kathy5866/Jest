package io.searchbox.client;

/*Generated by MPS */


/**
 * @author Dogukan Sonmez
 */
public interface JestResultHandler<T> {
  public void completed(T result);
  public void failed(Exception ex);
}