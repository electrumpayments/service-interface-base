package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An identifier assigned by an entity which process the message. Identifiers are keyed by institution ID thereby enabling any institution to recall a transaction within the entity's own system using the entity's own identifier. Entity's must not alter the identifier set by another entity. Once an identifier has been set by an entity, all other entity's must send that identifier in subsequent messages.
 **/
@ApiModel(description = "An identifier assigned by an entity which process the message. Identifiers are keyed by institution ID thereby enabling any institution to recall a transaction within the entity's own system using the entity's own identifier. Entity's must not alter the identifier set by another entity. Once an identifier has been set by an entity, all other entity's must send that identifier in subsequent messages.")
public class ThirdPartyIdentifier {

   private String institutionId = null;
   private String transactionIdentifier = null;

   /**
    * The entity's institution's ID as assigned by Electrum.
    **/
   public ThirdPartyIdentifier institutionId(String institutionId) {
      this.institutionId = institutionId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The entity's institution's ID as assigned by Electrum.")
   @JsonProperty("institutionId")
   @NotNull
   @Pattern(regexp = "[0-9]{1,11}")
   public String getInstitutionId() {
      return institutionId;
   }

   public void setInstitutionId(String institutionId) {
      this.institutionId = institutionId;
   }

   /**
    * The identifier assigned to this transaction by the institution represented in institutionId. This value should be unique within the institution's system.
    **/
   public ThirdPartyIdentifier transactionIdentifier(String transactionIdentifier) {
      this.transactionIdentifier = transactionIdentifier;
      return this;
   }

   @ApiModelProperty(required = true, value = "The identifier assigned to this transaction by the institution represented in institutionId. This value should be unique within the institution's system.")
   @JsonProperty("transactionIdentifier")
   public String getTransactionIdentifier() {
      return transactionIdentifier;
   }

   public void setTransactionIdentifier(String transactionIdentifier) {
      this.transactionIdentifier = transactionIdentifier;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      ThirdPartyIdentifier identifier = (ThirdPartyIdentifier) o;
      return Objects.equals(institutionId, identifier.institutionId)
            && Objects.equals(transactionIdentifier, identifier.transactionIdentifier);
   }

   @Override
   public int hashCode() {
      return Objects.hash(institutionId, transactionIdentifier);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TransactionIdentifier {\n");
      
      sb.append("    institutionId: ").append(Utils.toIndentedString(institutionId)).append("\n");
      sb.append("    transactionIdentifier: ").append(Utils.toIndentedString(transactionIdentifier)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
