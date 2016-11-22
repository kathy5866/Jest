package io.searchbox.action;

/*Generated by MPS */

import io.searchbox.client.JestResult;
import java.util.Collection;

/**
 *  Represents an Action that can be included in a Bulk request.
 * 
 *  @author cihat keser
 */
public interface BulkableAction<T extends JestResult> extends DocumentTargetedAction<T> {
  public String getBulkMethodName();
  public Collection<Object> getParameter(String key);
}
