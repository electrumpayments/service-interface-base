package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A model to describe IFSC (Indian Financial System Code) accounts")
public class IfscAccount extends Account {

   private String ifscCode = null;

   public IfscAccount() {
      setType(AccountType.IFSC);
   }

   public IfscAccount ifscCode(String ifscCode) {
      this.ifscCode = ifscCode;
      return this;
   }

   @ApiModelProperty(value = "The IFSC code for the particular bank account.")
   @JsonProperty("ifscCode")
   public String getIfscCode() {
      return ifscCode;
   }

   public void setIfscCode(String ifsCode) {
      this.ifscCode = ifsCode;
   }

   @Override
   public int hashCode() {
      return Objects.hash(ifscCode, type, ifscCode);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      IfscAccount account = (IfscAccount) o;
      return super.equals(o) && Objects.equals(this.ifscCode, account.ifscCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IfscAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    ifscCode: ").append(Utils.toIndentedString(ifscCode)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
