package io.electrum.vas.model;

import java.util.Objects;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "A model to describe IBAN accounts. Such accounts consist of just an account number.")
public class IbanAccount extends Account {

   public IbanAccount() {
      setType(AccountType.IBAN);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      IbanAccount account = (IbanAccount) o;
      return Objects.equals(this.accountId, account.accountId) && Objects.equals(this.type, account.type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class IbanAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
