package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base model for all account types", discriminator = "type", subTypes = { BankAccount.class,
      IbanAccount.class, IfscAccount.class, MobileWalletAccount.class, SwiftAccount.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
// For the sake of correct deserialisation, we need to map from values of type to child model classes explicitly
@JsonSubTypes({ @JsonSubTypes.Type(value = Account.class, name = "ACCOUNT"),
      @JsonSubTypes.Type(value = BankAccount.class, name = "BANK"),
      @JsonSubTypes.Type(value = IbanAccount.class, name = "IBAN"),
      @JsonSubTypes.Type(value = IfscAccount.class, name = "IFSC"),
      @JsonSubTypes.Type(value = MobileWalletAccount.class, name = "MOBILE_WALLET"),
      @JsonSubTypes.Type(value = SwiftAccount.class, name = "SWIFT") })
public class Account {

   public enum AccountType {
      ACCOUNT("ACCOUNT"), BANK("BANK"), IBAN("IBAN"), SWIFT("SWIFT"), IFSC("IFSC"), MOBILE_WALLET("MOBILE_WALLET");

      private String value;

      AccountType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   protected String accountId = null;
   protected AccountType type = AccountType.ACCOUNT;

   public Account accountId(String accountId) {
      this.accountId = accountId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The ID of this account e.g. service provider's customer's account number, a bank account number, an IBAN number or a mobile wallet's MSISDN.")
   @JsonProperty("accountId")
   @NotNull
   public String getAccountId() {
      return accountId;
   }

   public void setAccountId(String accountId) {
      this.accountId = accountId;
   }

   @ApiModelProperty(required = true, value = "The specific type of account. By default this is simply ACCOUNT which only carries an account number.")
   @JsonProperty("type")
   @NotNull
   public AccountType getType() {
      return type;
   }

   public void setType(AccountType type) {
      this.type = type;
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountId, type);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Account account = (Account) o;
      return Objects.equals(this.type, account.type) && Objects.equals(this.accountId, account.accountId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Account {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
