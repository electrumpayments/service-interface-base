package io.electrum.vas.model;

import java.util.Objects;

import io.electrum.vas.Utils;

public class ClearPin extends Pin {
   private String pin = null;

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
      ClearPin clearPin = (ClearPin) o;
      return Objects.equals(pin, clearPin.pin);
   }

   @Override
   public int hashCode() {

      return Objects.hash(super.hashCode(), pin);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ClearPin {\n");

      sb.append("    type: ").append(Utils.toIndentedString(super.getType())).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}