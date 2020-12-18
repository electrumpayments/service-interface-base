package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Originating, acquiring, processing, or receiving institution details
 **/
@ApiModel(description = "Originating, acquiring, processing, or receiving institution details")
public class Institution {

   private String id = null;
   private String name = null;

   /**
    * The institution's ID. API implementations should take care to set this field as appropriate for the
    * implementation.
    **/
   public Institution id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institution's ID. API implementations should take care to set this field as appropriate for the implementation.")
   @JsonProperty("id")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The institution's name
    **/
   public Institution name(String name) {
      this.name = name;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institution's name")
   @JsonProperty("name")
   @NotNull
   @Length(max = 40)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Institution institution = (Institution) o;
      return Objects.equals(id, institution.id) && Objects.equals(name, institution.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Institution {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
