package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.sdk.masking2.DoNotPersist;
import io.electrum.sdk.masking2.MaskAll;
import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A PIN, required to authorise a transaction, which has been hashed according to some hashing algorithm.
 **/
@ApiModel(description = "A PIN, required to authorise a transaction, which has been hashed according to some hashing algorithm.")
public class PinHashed extends Pin {

   private String hash = null;
   private HashedPinParameters hashedPinParameters = null;

   public PinHashed() {
      this.setType(PinType.HASHED_PIN);
   }

   public PinHashed hash(String hash) {
      this.hash = hash;
      return this;
   }

   @JsonProperty("hash")
   @ApiModelProperty(required = true, value = "A hashed PIN expressed as an ASCII string of hexadecimal values.")
   @NotNull
   @Pattern(regexp = "[0-9,A-F]{1,512}")
   @Masked
   @DoNotPersist(replacementValue = "****")
   public String getHash() {
      return hash;
   }

   public void setHash(String hash) {
      this.hash = hash;
   }

   public PinHashed hashedPinParameters(HashedPinParameters hashedPinParameters) {
      this.hashedPinParameters = hashedPinParameters;
      return this;
   }

   @JsonProperty("hashedPinParameters")
   @ApiModelProperty(value = "Parameters that describe the hashing algorithm used to hash the PIN.")
   @Valid
   public HashedPinParameters getHashedPinParameters() {
      return hashedPinParameters;
   }

   public void setHashedPinParameters(HashedPinParameters hashedPinParameters) {
      this.hashedPinParameters = hashedPinParameters;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      PinHashed pinHashed = (PinHashed) o;
      return Objects.equals(hash, pinHashed.hash) && Objects.equals(hashedPinParameters, pinHashed.hashedPinParameters);
   }

   @Override
   public int hashCode() {

      return Objects.hash(super.hashCode(), hash, hashedPinParameters);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PinHashed {\n");

      sb.append("    type: ").append(Utils.toIndentedString(super.getType())).append('\n');
      sb.append("    hash: ").append(Utils.toIndentedString(new MaskAll().mask(hash))).append('\n');
      sb.append("    hashedPinParameters: ").append(Utils.toIndentedString(hashedPinParameters.toString())).append('\n');
      sb.append('}');
      return sb.toString();
   }
}