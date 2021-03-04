package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      An32TokenPayment that = (An32TokenPayment) o;
      return Objects.equals(token, that.token);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), token);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class An32TokenPayment {\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append("\n");
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append("\n");
      sb.append("    token: ").append(Utils.toIndentedString(token)).append("\n");
      sb.append('}');
      return sb.toString();
   }
}
