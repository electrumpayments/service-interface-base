package io.electrum.vas.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An object describing the exchange rate from one currency to another.
 **/
@ApiModel(description = "An object describing the exchange rate from one currency to another.")
public class ExchangeRate {

   protected BigDecimal rate;
   protected String fromCurrency = null;
   protected String toCurrency = null;

   /**
    * The exchange rate expressed as the ratio of fromCurrency : toCurrency.
    **/
   public ExchangeRate rate(BigDecimal rate) {
      this.rate = rate;
      return this;
   }

   @ApiModelProperty(required = true, value = "The exchange rate expressed as the ratio of fromCurrency : toCurrency.")
   @JsonProperty("rate")
   @NotNull
   public BigDecimal getRate() {
      return rate;
   }

   public void setRate(BigDecimal rate) {
      this.rate = rate;
   }

   /**
    * The currency which amounts are converted from. One unit of this currency multiplied by the {@link rate} is equal
    * to one unit of the {@link toCurrency}. This currency is expressed as a three digit number as specified in ISO
    * 4217, e.g. South African Rand is encoded as 710.
    **/
   public ExchangeRate fromCurrency(String fromCurrency) {
      this.fromCurrency = fromCurrency;
      return this;
   }

   @ApiModelProperty(required = true, value = "The currency which amounts are converted from. One unit of this currency multiplied by the rate is equal to one unit of the toCurrency. This currency is expressed as a three digit number as specified in ISO 4217, e.g. South African Rand is encoded as 710.")
   @JsonProperty(value = "fromCurrency")
   @NotNull
   @Pattern(regexp = "[0-9]{3}")
   public String getFromCurrency() {
      return fromCurrency;
   }

   public void setFromCurrency(String fromCurrency) {
      this.fromCurrency = fromCurrency;
   }

   /**
    * The currency which amounts are converted to. One unit of this currency multiplied by the {@link rate} is equal to
    * one unit of the {@link fromCurrency}. This currency is expressed as a three digit number as specified in ISO 4217,
    * e.g. South African Rand is encoded as 710.
    **/
   public ExchangeRate toCurrency(String toCurrency) {
      this.toCurrency = toCurrency;
      return this;
   }

   @ApiModelProperty(required = true, value = "The currency which amounts are converted to. One unit of this currency multiplied by the rate is equal to one unit of the fromCurrency. This currency is expressed as a three digit number as specified in ISO 4217, e.g. South African Rand is encoded as 710.")
   @JsonProperty(value = "toCurrency")
   @NotNull
   @Pattern(regexp = "[0-9]{3}")
   public String getToCurrency() {
      return toCurrency;
   }

   public void setToCurrency(String toCurrency) {
      this.toCurrency = toCurrency;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ExchangeRate ledgerAmount = (ExchangeRate) o;
      return Objects.equals(rate, ledgerAmount.rate) && Objects.equals(fromCurrency, ledgerAmount.fromCurrency)
            && Objects.equals(toCurrency, ledgerAmount.toCurrency);
   }

   @Override
   public int hashCode() {
      return Objects.hash(rate, fromCurrency, toCurrency);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ExchangeRate {\n");
      sb.append("    rate: ").append(Utils.toIndentedString(rate)).append("\n");
      sb.append("    fromCurrency: ").append(Utils.toIndentedString(fromCurrency)).append("\n");
      sb.append("    toCurrency: ").append(Utils.toIndentedString(toCurrency)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
