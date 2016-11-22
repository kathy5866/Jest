package io.searchbox.core.search.aggregation;

/*Generated by MPS */

import java.util.Map;
import java.util.HashMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PercentilesAggregation extends MetricAggregation {

  public static final String TYPE = "percentiles";
  private Map<String, Double> percentiles = new HashMap<String, Double>();
  public PercentilesAggregation(String name, JsonObject percentilesAggregation) {
    super(name, percentilesAggregation);
    parseSource(percentilesAggregation.getAsJsonObject(String.valueOf(AggregationField.VALUES)));
  }
  private void parseSource(JsonObject source) {
    for (Map.Entry<String, JsonElement> entry : source.entrySet()) {
      if (!((Double.isNaN(entry.getValue().getAsDouble())))) {
        percentiles.put(entry.getKey(), entry.getValue().getAsDouble());
      }
    }
  }
  public Map<String, Double> getPercentiles() {
    return percentiles;
  }
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    PercentilesAggregation rhs = (PercentilesAggregation) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(percentiles, rhs.percentiles).isEquals();
  }
  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(percentiles).toHashCode();
  }
}