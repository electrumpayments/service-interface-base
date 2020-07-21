package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

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
      //@formatter:off
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
      AccountPayment that = (AccountPayment) o;
      return Objects.equals(srcAccountId, that.srcAccountId) &&
              Objects.equals(srcCustomerId, that.srcCustomerId) &&
              Objects.equals(destAccountId, that.destAccountId) &&
              Objects.equals(destCustomerId, that.destCustomerId);
      //@formatter:on
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), srcAccountId, srcCustomerId, destAccountId, destCustomerId);
   }

   @Override
   public String toString() {
      //@formatter:off
      return "AccountPayment{" +
              "srcAccountId='" + srcAccountId + '\'' +
              ", srcCustomerId='" + srcCustomerId + '\'' +
              ", destAccountId='" + destAccountId + '\'' +
              ", destCustomerId='" + destCustomerId + '\'' +
              ", type=" + type +
              ", name='" + name + '\'' +
              ", amount=" + amount +
              '}';
      //@formatter:on
   }
}
