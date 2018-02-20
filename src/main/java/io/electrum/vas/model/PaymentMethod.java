package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import java.util.Objects;

@ApiModel(description = "Base model for all payment types", discriminator = "type", subTypes = {An32TokenPayment.class, LoyaltyCardPayment.class})
public class PaymentMethod {

   public enum PaymentMethodType {
      TOKEN("TOKEN"), LOYALTY_CARD("LOYALTY_CARD");

      private String value;

      PaymentMethodType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   protected PaymentMethodType type = null;

   @ApiModelProperty(required = true, value = "The specific method pf payment used")
   @JsonProperty("name")
   @NotNull
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   protected String name;

   @ApiModelProperty(required = true, value = "The general method of payment used")
   @JsonProperty("type")
   @NotNull
   public PaymentMethodType getType() {
      return type;
   }

   public void setType(PaymentMethodType type) {
      this.type = type;
   }

   @Override
   public int hashCode() {
      return Objects.hash(type);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentMethod paymentMethod = (PaymentMethod) o;
      return Objects.equals(this.type, paymentMethod.type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentMethod {\n");
      sb.append("    name: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
