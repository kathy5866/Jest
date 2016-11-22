package io.searchbox.core.search.aggregation;

/*Generated by MPS */

import com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ExtendedStatsAggregation extends StatsAggregation {

  private Double sumOfSquares;
  private Double variance;
  private Double stdDeviation;
  public ExtendedStatsAggregation(String name, JsonObject extendedStatsAggregation) {
    super(name, extendedStatsAggregation);
    this.sumOfSquares = (!(extendedStatsAggregation.has(String.valueOf(AggregationField.SUM_OF_SQUARES))) || extendedStatsAggregation.get(String.valueOf(AggregationField.SUM_OF_SQUARES)).isJsonNull() ? null : extendedStatsAggregation.get(String.valueOf(AggregationField.SUM_OF_SQUARES)).getAsDouble());
    this.variance = (!(extendedStatsAggregation.has(String.valueOf(AggregationField.VARIANCE))) || extendedStatsAggregation.get(String.valueOf(AggregationField.VARIANCE)).isJsonNull() ? null : extendedStatsAggregation.get(String.valueOf(AggregationField.VARIANCE)).getAsDouble());
    this.stdDeviation = (!(extendedStatsAggregation.has(String.valueOf(AggregationField.STD_DEVIATION))) || extendedStatsAggregation.get(String.valueOf(AggregationField.STD_DEVIATION)).isJsonNull() ? null : extendedStatsAggregation.get(String.valueOf(AggregationField.STD_DEVIATION)).getAsDouble());
  }
  /**
   * @return Sum of Squares for the aggregated data if found, null otherwise
   */
  public Double getSumOfSquares() {
    return sumOfSquares;
  }
  /**
   * @return Variance of the aggregated data if found, null otherwise
   */
  public Double getVariance() {
    return variance;
  }
  /**
   * @return Standard deviation of the aggregated data if found, null otherwise
   */
  public Double getStdDeviation() {
    return stdDeviation;
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
    ExtendedStatsAggregation rhs = (ExtendedStatsAggregation) obj;
    return new EqualsBuilder().appendSuper(super.equals(obj)).append(stdDeviation, rhs.stdDeviation).append(sumOfSquares, rhs.sumOfSquares).append(variance, rhs.variance).isEquals();
  }
  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(sumOfSquares).append(variance).append(stdDeviation).toHashCode();
  }
}
