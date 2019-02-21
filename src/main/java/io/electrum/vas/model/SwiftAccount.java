package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A model to describe SWIFT accounts")
public class SwiftAccount extends Account {

   private String swiftCode = null;

   public SwiftAccount() {
      setType(AccountType.SWIFT);
   }

   public SwiftAccount swiftCode(String swiftCode) {
      this.swiftCode = swiftCode;
      return this;
   }

   @ApiModelProperty(value = "The swift code for the particular bank account.")
   @JsonProperty("swiftCode")
   public String getSwiftCode() {
      return swiftCode;
   }

   public void setSwiftCode(String swiftCode) {
      this.swiftCode = swiftCode;
   }

   @Override
   public int hashCode() {
      return Objects.hash(swiftCode, type, swiftCode);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SwiftAccount account = (SwiftAccount) o;
      return super.equals(o) && Objects.equals(this.swiftCode, account.swiftCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SwiftAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    swiftCode: ").append(Utils.toIndentedString(swiftCode)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
