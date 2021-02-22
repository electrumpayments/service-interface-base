package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for an account-to-account payment method", parent = PaymentMethod.class)
public class AccountPayment extends PaymentMethod {

   private String srcAccountId = null;
   private String srcCustomerId = null;
   private String destAccountId = null;
   private String destCustomerId = null;

   public AccountPayment() {
      setType(PaymentMethodType.ACCOUNT);
   }

   /**
    * Destination AccountId to which this payment will be made.
    *
    * @return destAccountId
    **/
   @ApiModelProperty(value = "Destination AccountId to which this payment will be made.")
   @JsonProperty("destAccountId")
   public String getDestAccountId() {
      return destAccountId;
   }

   public void setDestAccountId(String destAccountId) {
      this.destAccountId = destAccountId;
   }

   public AccountPayment destAccountId(String destAccountId) {
      this.setDestAccountId(destAccountId);
      return this;
   }

   /**
    * Destination CustomerId to which this payment will be made.
    *
    * @return destCustomerId
    **/
   @ApiModelProperty(value = "Destination CustomerId to which this payment will be made.")
   @JsonProperty("destCustomerId")
   public String getDestCustomerId() {
      return destCustomerId;
   }

   public void setDestCustomerId(String destCustomerId) {
      this.destCustomerId = destCustomerId;
   }

   public AccountPayment destCustomerId(String destCustomerId) {
      this.setDestCustomerId(destCustomerId);
      return this;
   }

   /**
    * Source AccountId from which this payment will be made.
    *
    * @return srcAccountId
    **/
   @ApiModelProperty(value = "Source AccountId from which this payment will be made.")
   @JsonProperty("srcAccountId")
   public String getSrcAccountId() {
      return srcAccountId;
   }

   public void setSrcAccountId(String srcAccountId) {
      this.srcAccountId = srcAccountId;
   }

   public AccountPayment srcAccountId(String srcAccountId) {
      this.setSrcAccountId(srcAccountId);
      return this;
   }

   /**
    * Source CustomerId from which this payment will be made.
    *
    * @return srcCustomerId
    **/
   @ApiModelProperty(value = "Source CustomerId from which this payment will be made.")
   @JsonProperty("srcCustomerId")
   public String getSrcCustomerId() {
      return srcCustomerId;
   }

   public void setSrcCustomerId(String srcCustomerId) {
      this.srcCustomerId = srcCustomerId;
   }

   public AccountPayment srcCustomerId(String srcCustomerId) {
      this.setSrcCustomerId(srcCustomerId);
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      AccountPayment that = (AccountPayment) o;
      return Objects.equals(srcAccountId, that.srcAccountId) && Objects.equals(srcCustomerId, that.srcCustomerId)
            && Objects.equals(destAccountId, that.destAccountId) && Objects.equals(destCustomerId, that.destCustomerId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), srcAccountId, srcCustomerId, destAccountId, destCustomerId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AccountPayment {\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append("\n");
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append("\n");
      sb.append("    srcAccountId: ").append(Utils.toIndentedString(srcAccountId)).append("\n");
      sb.append("    srcCustomerId: ").append(Utils.toIndentedString(srcCustomerId)).append("\n");
      sb.append("    destAccountId: ").append(Utils.toIndentedString(destAccountId)).append("\n");
      sb.append("    destCustomerId: ").append(Utils.toIndentedString(destCustomerId)).append("\n");      sb.append("}");
      return sb.toString();
   }
}
