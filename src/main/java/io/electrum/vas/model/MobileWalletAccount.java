package io.electrum.vas.model;

import java.util.Objects;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "A model to describe mobile wallet accounts. Such accounts consist of just an account number. This account number is typically the customer's MSISDN.")
public class MobileWalletAccount extends Account {

   public MobileWalletAccount() {
      setType(AccountType.MOBILE_WALLET);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MobileWalletAccount account = (MobileWalletAccount) o;
      return Objects.equals(this.accountId, account.accountId) && Objects.equals(this.type, account.type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MobileWalletAccount {\n");
      sb.append("    accountId: ").append(Utils.toIndentedString(accountId)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
