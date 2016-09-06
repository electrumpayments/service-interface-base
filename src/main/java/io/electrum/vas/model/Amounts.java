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
   protected LedgerAmount approvedAmount = null;
   protected LedgerAmount feeAmount = null;
   protected LedgerAmount balanceAmount = null;

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

   public Amounts approvedAmount(LedgerAmount approvedAmount) {
      this.approvedAmount = approvedAmount;
      return this;
   }

   /**
    * The transaction amount which was approved by the upstream entity.
    * 
    * @return approvedAmount
    **/
   @ApiModelProperty(value = "The transaction amount which was approved by the upstream entity.")
   @JsonProperty("approvedAmount")
   public LedgerAmount getApprovedAmount() {
      return approvedAmount;
   }

   public void setApprovedAmount(LedgerAmount approvedAmount) {
      this.approvedAmount = approvedAmount;
   }

   public Amounts feeAmount(LedgerAmount feeAmount) {
      this.feeAmount = feeAmount;
      return this;
   }

   /**
    * Fees charged by the upstream entity for processing the transaction.
    * 
    * @return feeAmount
    **/
   @ApiModelProperty(value = "Fees charged by the upstream entity for processing the transaction.")
   @JsonProperty("feeAmount")
   public LedgerAmount getFeeAmount() {
      return feeAmount;
   }

   public void setFeeAmount(LedgerAmount feeAmount) {
      this.feeAmount = feeAmount;
   }

   public Amounts balanceAmount(LedgerAmount balanceAmount) {
      this.balanceAmount = balanceAmount;
      return this;
   }

   /**
    * The remaining balance on the customer's account.
    * 
    * @return balanceAmount
    **/
   @ApiModelProperty(value = "The remaining balance on the customer's account.")
   @JsonProperty("requestAmount")
   public LedgerAmount getBalanceAmount() {
      return balanceAmount;
   }

   public void setBalanceAmount(LedgerAmount balanceAmount) {
      this.balanceAmount = balanceAmount;
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
      return Objects.equals(requestAmount, tender.requestAmount)
            && Objects.equals(approvedAmount, tender.approvedAmount) && Objects.equals(feeAmount, tender.feeAmount)
            && Objects.equals(balanceAmount, tender.balanceAmount);
   }

   @Override
   public int hashCode() {
      return Objects.hash(requestAmount, approvedAmount, feeAmount, balanceAmount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Amounts {\n");

      sb.append("    requestAmount: ").append(Utils.toIndentedString(requestAmount)).append("\n");
      sb.append("    approvedAmount: ").append(Utils.toIndentedString(approvedAmount)).append("\n");
      sb.append("    feeAmount: ").append(Utils.toIndentedString(feeAmount)).append("\n");
      sb.append("    balanceAmount: ").append(Utils.toIndentedString(balanceAmount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
