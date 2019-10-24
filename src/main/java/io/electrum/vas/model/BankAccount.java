package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A model to describe bank accounts")
public class BankAccount extends Account {

   private String routingCode = null;

   private String region = null;

   public BankAccount() {
      setType(AccountType.BANK);
   }

   public BankAccount routingCode(String routingCode) {
      this.routingCode = routingCode;
      return this;
   }

   @ApiModelProperty(value = "The routing code for the particular bank account.")
   @JsonProperty("routingCode")
   public String getRoutingCode() {
      return routingCode;
   }

   public void setRoutingCode(String routingCode) {
      this.routingCode = routingCode;
   }

   public BankAccount region(String region) {
      this.region = region;
      return this;
   }

   @ApiModelProperty(value = "The region of the account for countries and cases where the routing code is not sufficient to "
         + "identify a bank account.")
   @JsonProperty("routingCode")
   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   @Override
   public int hashCode() {
      return Objects.hash(routingCode, type, routingCode, region);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BankAccount account = (BankAccount) o;
      return super.equals(o) && Objects.equals(this.routingCode, account.routingCode)
            && Objects.equals(this.region, account.region);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BankAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    routingCode: ").append(Utils.toIndentedString(routingCode)).append("\n");
      sb.append("    region: ").append(Utils.toIndentedString(region)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
