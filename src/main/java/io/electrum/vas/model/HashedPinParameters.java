package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A collection of parameters required to reliably reproduce the hashed value (excluding the actual PIN value).
 **/
@ApiModel(description = "A collection of parameters required to reliably reproduce the hashed value (excluding the actual PIN value).")
public class HashedPinParameters {

   private String name = null;

   public HashedPinParameters name(String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("name")
   @ApiModelProperty(required = true, value = "The name of the hashing algorithm. Implementers must agree on how algorithms are named with consideration given towards the following atttributes (with Electrum default options in square braces): letter case [UPPERCASE], use of spaces [replace_with_underscores] and use of special characters [allowed].")
   @NotNull
   @Length(max = 20)
   public String getName() {
      return name;
   }

   public void setName(String hash) {
      this.name = hash;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      HashedPinParameters hashedPinParameters = (HashedPinParameters) o;
      return Objects.equals(name, hashedPinParameters.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), name);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HashedPinParameters {\n");

      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("}");
      return sb.toString();
   }

}
