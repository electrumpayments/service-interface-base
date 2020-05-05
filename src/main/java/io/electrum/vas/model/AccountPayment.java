package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for account-to-account payments", parent = PaymentMethod.class)
public class AccountPayment extends PaymentMethod {

   private String accountId = null;
   private String customerId = null;

   public AccountPayment() {
      setType(PaymentMethodType.ACCOUNT);
   }

   /**
    * AccountId to which this payment will be made.
    *
    * @return accountId
    **/
   @ApiModelProperty(required = true, value = "AccountId to which this payment will be made.")
   @JsonProperty("accountId")
   @NotNull
   public String getAccountId() {
      return accountId;
   }

   public void setAccountId(String accountId) {
      this.accountId = accountId;
   }

   public AccountPayment accountId(String accountId) {
      this.setAccountId(accountId);
      return this;
   }

   /**
    * CustomerId to which this payment will be made.
    *
    * @return customerId
    **/
   @ApiModelProperty(required = false, value = "CustomerId to which this payment will be made.")
   @JsonProperty("customerId")
   public String getCustomerId() {
      return customerId;
   }

   public void setCustomerId(String customerId) {
      this.customerId = customerId;
   }

   public AccountPayment customerId(String customerId) {
      this.setCustomerId(customerId);
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
      AccountPayment that = (AccountPayment) o;
      return Objects.equals(accountId, that.accountId) &&
              Objects.equals(customerId, that.customerId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), accountId, customerId);
   }

   @Override
   public String toString() {
      return "AccountPayment{" +
              "accountId='" + accountId + '\'' +
              ", customerId='" + customerId + '\'' +
              ", type=" + type +
              ", name='" + name + '\'' +
              ", amount=" + amount +
              '}';
   }
}
