package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModelProperty;

/**
 * A subsection of a wallet used when a {@link WalletPayment} is made up of more than 1 part.
 */
public class WalletPocket {
   private String pocketName;

   private String pocketId;

   /**
    * The name given to this wallet pocket
    * 
    * @param pocketName
    *           The name of this pocket
    * @return this object
    */
   public WalletPocket pocketName(String pocketName) {
      this.pocketName = pocketName;
      return this;
   }

   @ApiModelProperty(required = true, value = "The name given to this wallet pocket.")
   @JsonProperty("pocketName")
   @NotNull
   public String getPocketName() {
      return pocketName;
   }

   public void setPocketName(String pocketName) {
      this.pocketName = pocketName;
   }

   /**
    * A programmatic ID that can be used to identify this pocket when the name is not enough.
    * 
    * @param pocketId
    *           The ID for this pocket
    * @return this object
    */
   public WalletPocket pocketId(String pocketId) {
      this.pocketId = pocketId;
      return this;
   }

   @ApiModelProperty(value = "A programmatic ID that can be used to identify this pocket when the name is not enough")
   @JsonProperty("pocketId")
   public String getPocketId() {
      return pocketId;
   }

   public void setPocketId(String pocketId) {
      this.pocketId = pocketId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      WalletPocket that = (WalletPocket) o;
      return Objects.equals(pocketName, that.pocketName) && Objects.equals(pocketId, that.pocketId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(pocketName, pocketId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class WalletPocket {\n");
      sb.append("    pocketId: ").append(Utils.toIndentedString(pocketId)).append('\n');
      sb.append("    pocketName: ").append(Utils.toIndentedString(pocketName)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
