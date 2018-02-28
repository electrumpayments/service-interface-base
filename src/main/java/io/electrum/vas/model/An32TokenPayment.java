package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@ApiModel(description = "Model for token-based payments", parent = PaymentMethod.class)
public class An32TokenPayment extends PaymentMethod {

   private String token = null;

   public An32TokenPayment() {
      // The method used to deserialise child models based on a discriminator leaves the discriminator field null
      // So we set it explicitly in the default constructor
      setType(PaymentMethodType.AN_32_TOKEN);
   }

   @ApiModelProperty(required = true, value = "32 character alphanumeric code which identifies a token")
   @JsonProperty("token")
   @NotNull
   @Pattern(regexp = "[a-zA-Z0-9]{32}")
   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, type, token);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      An32TokenPayment otherToken = (An32TokenPayment) o;
      return Objects.equals(this.type, otherToken.type) && Objects.equals(this.name, otherToken.name)
            && Objects.equals(this.token, otherToken.token) && Objects.equals(this.amount, otherToken.amount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class An32TokenPayment {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    token: ").append(Utils.toIndentedString(token)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
