package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Identifiers assigned by various entities which process the message.
 **/
@ApiModel(description = "Identifiers assigned by various entities which process the message.")
public class Identifier {

   private String merchantRefId = null;
   private String clientRefId = null;
   private String settlementRefId = null;
   private String receiverRefId = null;

   /**
    * A reference number useful to the originator for identifying transactions, also knows as a retrieval reference
    * number.
    **/
   public Identifier merchantRefId(String merchantRefId) {
      this.merchantRefId = merchantRefId;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the originator for identifying transactions, also knows as a retrieval reference number.")
   @JsonProperty("merchantRefId")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getMerchantRefId() {
      return merchantRefId;
   }

   public void setMerchantRefId(String merchantRefId) {
      this.merchantRefId = merchantRefId;
   }

   /**
    * A reference number useful to the client for identifying transactions.
    **/
   public Identifier clientRefId(String clientRefId) {
      this.clientRefId = clientRefId;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the client for identifying transactions.")
   @JsonProperty("clientRefId")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getClientRefId() {
      return clientRefId;
   }

   public void setClientRefId(String clientRefId) {
      this.clientRefId = clientRefId;
   }

   /**
    * A reference number useful to the settlement entity for identifying transactions.
    **/
   public Identifier settlementRefId(String settlementRefId) {
      this.settlementRefId = settlementRefId;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the settlement entity for identifying transactions.")
   @JsonProperty("settlementRefId")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getSettlementRefId() {
      return settlementRefId;
   }

   public void setSettlementRefId(String settlementRefId) {
      this.settlementRefId = settlementRefId;
   }

   /**
    * A reference number useful to the receiver for identifying transactions.
    **/
   public Identifier receiverRefId(String receiverRefId) {
      this.receiverRefId = receiverRefId;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the receiver for identifying transactions.")
   @JsonProperty("receiverRefId")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getReceiverRefId() {
      return receiverRefId;
   }

   public void setReceiverRefId(String receiverRefId) {
      this.receiverRefId = receiverRefId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Identifier identifier = (Identifier) o;
      return Objects.equals(merchantRefId, identifier.merchantRefId)
            && Objects.equals(clientRefId, identifier.clientRefId)
            && Objects.equals(settlementRefId, identifier.settlementRefId)
            && Objects.equals(receiverRefId, identifier.receiverRefId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(merchantRefId, clientRefId, settlementRefId, receiverRefId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Identifier {\n");
      sb.append("    merchantRefId: ").append(Utils.toIndentedString(merchantRefId)).append("\n");
      sb.append("    clientRefId: ").append(Utils.toIndentedString(clientRefId)).append("\n");
      sb.append("    settlementRefId: ").append(Utils.toIndentedString(settlementRefId)).append("\n");
      sb.append("    receiverRefId: ").append(Utils.toIndentedString(receiverRefId)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
