package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Amounts which make up the transaction. Absent amounts have zero value.
 **/
@ApiModel(description = "Amounts which make up the transaction. Absent amounts have zero value.")
public class Amounts {

   protected LedgerAmount requestAmount = null;
   public Amounts requestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
      return this;
   }


   /**
    * The transaction amount requested by the customer to be authorised or approved. This is the total amount the
    * customer wishes to pay for a service or virtual product.
    * 
    * @return requestAmount
    **/
   @ApiModelProperty(value = "The transaction amount requested by the customer to be authorised or approved. This is the total amount the customer wishes to pay for a service or virtual product.")
   @JsonProperty("requestAmount")
   public LedgerAmount getRequestAmount() {
      return requestAmount;
   }

   public void setRequestAmount(LedgerAmount requestAmount) {
      this.requestAmount = requestAmount;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Amounts tender = (Amounts) o;
      return Objects.equals(requestAmount, tender.requestAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(requestAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Amounts {\n");

      sb.append("    requestAmount: ").append(Utils.toIndentedString(requestAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
