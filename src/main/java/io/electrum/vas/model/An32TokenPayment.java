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
      return Objects.equals(this.type, otherToken.type)
            && Objects.equals(this.token, otherToken.token);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class An32TokenPayment {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    token: ").append(Utils.toIndentedString(token)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
