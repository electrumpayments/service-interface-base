package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.sdk.masking2.MaskAll;
import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * Details of a customer's address
 *
 * @since 3.30.0
 */
@ApiModel(description = "Details of a customer's address")
public class Address {
   @JsonProperty("addressLine1")
   private String addressLine1 = null;

   @JsonProperty("addressLine2")
   private String addressLine2 = null;

   @JsonProperty("city")
   private String city = null;

   @JsonProperty("region")
   private String region = null;

   @JsonProperty("country")
   private String country = null;

   @JsonProperty("postalCode")
   private String postalCode = null;

   public Address addressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
   }

   /**
    * First line of street address.
    * 
    * @return addressLine1
    **/
   @JsonProperty("addressLine1")
   @ApiModelProperty(value = "First line of street address.")
   @Pattern(regexp="^.{1,100}")
   @Masked
   public String getAddressLine1() {
      return addressLine1;
   }

   public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
   }

   public Address addressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
   }

   /**
    * Second line of street address (if required).
    * 
    * @return addressLine2
    **/
   @JsonProperty("addressLine2")
   @ApiModelProperty(value = "Second line of street address (if required).")
   @Pattern(regexp="^.{1,100}")
   @Masked
   public String getAddressLine2() {
      return addressLine2;
   }

   public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
   }

   public Address city(String city) {
      this.city = city;
      return this;
   }

   /**
    * Get city
    * 
    * @return city
    **/
   @JsonProperty("city")
   @ApiModelProperty(value = "The city where the owner is located. Note: if this field ever needs to be translated to another API with shorter fields, the field will be truncated from the right.")
   @Pattern(regexp="^.{1,30}")
   @Masked
   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public Address region(String region) {
      this.region = region;
      return this;
   }

   /**
    * Get region
    * 
    * @return region
    **/
   @JsonProperty("region")
   @ApiModelProperty(value = "The state or region where the owner is located.")
   @Pattern(regexp="[A-Z]{2}")
   @Masked
   public String getRegion() {
      return region;
   }

   public void setRegion(String region) {
      this.region = region;
   }

   public Address country(String country) {
      this.country = country;
      return this;
   }

   /**
    * Country expressed as an ISO 3166-1 Alpha-2 code
    * 
    * @return country
    **/
   @JsonProperty("country")
   @ApiModelProperty(value = "The owner's resident country expressed as an ISO 3166-1 Alpha-2 code.")
   @Pattern(regexp="[A-Z]{2}")
   @Masked
   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public Address postalCode(String postalCode) {
      this.postalCode = postalCode;
      return this;
   }

   /**
    * Get postalCode
    * 
    * @return postalCode
    **/
   @JsonProperty("postalCode")
   @ApiModelProperty(value = "The owner's postal code.")
   @Pattern(regexp="[A-Za-z0-9 -]{1,20}")
   @Masked
   public String getPostalCode() {
      return postalCode;
   }

   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Address address = (Address) o;
      return Objects.equals(this.addressLine1, address.addressLine1)
            && Objects.equals(this.addressLine2, address.addressLine2) && Objects.equals(this.city, address.city)
            && Objects.equals(this.region, address.region) && Objects.equals(this.country, address.country)
            && Objects.equals(this.postalCode, address.postalCode);
   }

   @Override
   public int hashCode() {
      return Objects.hash(addressLine1, addressLine2, city, region, country, postalCode);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Address {\n");

      sb.append("    addressLine1: ").append(Utils.toIndentedString(new MaskAll().mask(addressLine1))).append("\n");
      sb.append("    addressLine2: ").append(Utils.toIndentedString(new MaskAll().mask(addressLine2))).append("\n");
      sb.append("    city: ").append(Utils.toIndentedString(new MaskAll().mask(city))).append("\n");
      sb.append("    region: ").append(Utils.toIndentedString(new MaskAll().mask(region))).append("\n");
      sb.append("    country: ").append(Utils.toIndentedString(new MaskAll().mask(country))).append("\n");
      sb.append("    postalCode: ").append(Utils.toIndentedString(new MaskAll().mask(postalCode))).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
