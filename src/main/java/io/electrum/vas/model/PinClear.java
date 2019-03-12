package io.electrum.vas.model;

import java.util.Objects;

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
 * A clear PIN required to authorise a transaction.
 **/
@ApiModel(description = "A clear PIN required to authorise a transaction.")
public class PinClear extends Pin {

   private String pin = null;

   public PinClear pin(String pin) {
      this.pin = pin;
      return this;
   }

   public PinClear() {
      this.setType(PinType.CLEAR_PIN);
   }

   @JsonProperty("pin")
   @ApiModelProperty(required = true, value = "A clear PIN")
   @NotNull
   @Pattern(regexp = ".{0,20}")
   @Masked
   @DoNotPersist(replacementValue = "****")
   public String getPin() {
      return pin;
   }

   public void setPin(String pin) {
      this.pin = pin;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      PinClear pinClear = (PinClear) o;
      return Objects.equals(pin, pinClear.pin);
   }

   @Override
   public int hashCode() {

      return Objects.hash(super.hashCode(), pin);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PinClear {\n");

      sb.append("    type: ").append(Utils.toIndentedString(super.getType())).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(new MaskAll().mask(pin))).append("\n");
      sb.append("}");
      return sb.toString();
   }
}