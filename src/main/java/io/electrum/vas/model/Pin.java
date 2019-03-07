package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base model for capturing either a clear PIN or encrypted PIN", discriminator = "type", subTypes = {
      PinClear.class, PinEncrypted.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = PinClear.class, name = "CLEAR_PIN"),
      @JsonSubTypes.Type(value = PinEncrypted.class, name = "ENCRYPTED_PIN") })
public abstract class Pin {
   public enum PinType {
      CLEAR_PIN("CLEAR_PIN"), ENCRYPTED_PIN("ENCRYPTED_PIN");

      private String value;

      PinType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private PinType type = null;

   public Pin type(PinType pinType) {
      this.type = pinType;
      return this;
   }

   @ApiModelProperty(required = true, value = "Whether the PIN is communicated in the clear or encrypted.")
   @JsonProperty("type")
   @NotNull
   public PinType getType() {
      return type;
   }

   public void setType(PinType type) {
      this.type = type;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Pin pin = (Pin) o;
      return type == pin.type;
   }

   @Override
   public int hashCode() {
      return Objects.hash(type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Pin {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}