package io.electrum.vas.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A model to describe IFS accounts")
public class IfsAccount extends Account {

   private String ifsCode = null;

   public IfsAccount() {
      setType(AccountType.IFS);
   }

   public IfsAccount ifsCode(String ifsCode) {
      this.ifsCode = ifsCode;
      return this;
   }

   @ApiModelProperty(value = "The IFS code for the particular bank account.")
   @JsonProperty("ifsCode")
   public String getIfsCode() {
      return ifsCode;
   }

   public void setIfsCode(String ifsCode) {
      this.ifsCode = ifsCode;
   }

   @Override
   public int hashCode() {
      return Objects.hash(ifsCode, type, ifsCode);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      IfsAccount account = (IfsAccount) o;
      return super.equals(o) && Objects.equals(this.ifsCode, account.ifsCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IfsAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    ifsCode: ").append(Utils.toIndentedString(ifsCode)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
