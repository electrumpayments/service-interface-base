package io.electrum.vas.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

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
}
