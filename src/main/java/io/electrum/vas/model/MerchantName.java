package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A container object representing the Cardholder Name and Location
 **/
@ApiModel(description = "A container object representing the Cardholder Name and Location")
public class MerchantName {

   private String name = null;
   private String city = null;
   private String region = null;
   private String country = null;

   /**
    * The merchant or trading as name associated with the merchant
    **/
   public MerchantName name(String name) {
      this.name = name;
      return this;
   }

   @ApiModelProperty(required = true, value = "The merchant or trading as name associated with the merchant")
   @JsonProperty("name")
   @NotNull
   @Length(max = 23)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   /**
    * The city where the merchant is located
    **/
   public MerchantName city(String city) {
      this.city = city;
      return this;
   }

   @ApiModelProperty(required = true, value = "The city where the merchant is located")
   @JsonProperty("city")
   @NotNull
   @Length(max = 13)
   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   /**
    * The state or region where the merchant is located
    **/
   public MerchantName region(String region) {
      this.region = region;
      return this;
   }

   @ApiModelProperty(required = true, value = "The state or region where the merchant is located")
   @JsonProperty("region")
   @NotNull
   @Length(max = 2)
   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   /**
    * The country where the merchant is located
    **/
   public MerchantName country(String country) {
      this.country = country;
      return this;
   }

   @ApiModelProperty(required = true, value = "The country where the merchant is located")
   @JsonProperty("country")
   @NotNull
   @Length(max = 2)
   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      MerchantName merchantName = (MerchantName) o;
      return Objects.equals(name, merchantName.name) && Objects.equals(city, merchantName.city)
            && Objects.equals(region, merchantName.region) && Objects.equals(country, merchantName.country);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, city, region, country);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class MerchantName {\n");

      sb.append("    name: ").append(toIndentedString(name)).append("\n");
      sb.append("    city: ").append(toIndentedString(city)).append("\n");
      sb.append("    region: ").append(toIndentedString(region)).append("\n");
      sb.append("    country: ").append(toIndentedString(country)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
