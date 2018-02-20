package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@ApiModel(description = "Model for payments made using loyalty programme cards", parent = PaymentMethod.class)
public class LoyaltyCardPayment extends PaymentMethod {

   private String cardNumber = null;

   @ApiModelProperty(required = true, value = "Primary account number of the loyalty programme card used to make a payment")
   @JsonProperty("cardNumber")
   @NotNull
   @Pattern(regexp = "[0-9]{16}")
   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   @Override
   public int hashCode() {
      return Objects.hash(cardNumber, name, type);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      LoyaltyCardPayment loyaltyCardPayment = (LoyaltyCardPayment) o;
      return Objects.equals(this.type, loyaltyCardPayment.type)
            && Objects.equals(this.cardNumber, loyaltyCardPayment.cardNumber);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LoyaltyCardPayment {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    cardNumber: ").append(Utils.toIndentedString(cardNumber)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
