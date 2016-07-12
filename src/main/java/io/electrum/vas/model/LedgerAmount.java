package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * An amount object only containing value and currency, and optionally an indicator of DEBIT/CREDIT
 **/
@ApiModel(description = "An amount object only containing value and currency, and optionally an indicator of DEBIT/CREDIT")
public class LedgerAmount {

   /**
    * Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a
    * credit
    */
   public enum LedgerIndicator {
      DEBIT("DEBIT"), CREDIT("CREDIT");

      private String value;

      LedgerIndicator(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private Long amount = null;
   private String currency = null;
   private LedgerIndicator ledgerIndicator = null;

   /**
    * Amount in minor denomination, e.g. R799.95 is encoded as 79995
    **/
   public LedgerAmount amount(Long amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "Amount in minor denomination, e.g. R799.95 is encoded as 79995")
   @JsonProperty("amount")
   @NotNull
   public Long getAmount() {
      return amount;
   }

   public void setAmount(Long amount) {
      this.amount = amount;
   }

   /**
    * Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710
    **/
   public LedgerAmount currency(String currency) {
      this.currency = currency;
      return this;
   }

   @ApiModelProperty(required = true, value = "Three digit currency number from ISO 4217, e.g. South African Rand is encoded as 710")
   @JsonProperty(value = "currency")
   @NotNull
   @Pattern(regexp = "[0-9]{3}")
   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   /**
    * Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a
    * credit
    **/
   public LedgerAmount ledgerIndicator(LedgerIndicator ledgerIndicator) {
      this.ledgerIndicator = ledgerIndicator;
      return this;
   }

   @ApiModelProperty(value = "Indicates whether this amount is a debit or a credit. Only required when the amount can be either a debit or a credit")
   @JsonProperty("ledgerIndicator")
   public LedgerIndicator getLedgerIndicator() {
      return ledgerIndicator;
   }

   public void setLedgerIndicator(LedgerIndicator ledgerIndicator) {
      this.ledgerIndicator = ledgerIndicator;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      LedgerAmount ledgerAmount = (LedgerAmount) o;
      return Objects.equals(amount, ledgerAmount.amount) && Objects.equals(currency, ledgerAmount.currency)
            && Objects.equals(ledgerIndicator, ledgerAmount.ledgerIndicator);
   }

   @Override
   public int hashCode() {
      return Objects.hash(amount, currency, ledgerIndicator);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LedgerAmount {\n");

      sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
      sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
      sb.append("    ledgerIndicator: ").append(toIndentedString(ledgerIndicator)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
