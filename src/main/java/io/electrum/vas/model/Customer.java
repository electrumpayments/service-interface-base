package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

/**
 * A customer who ultimately requests a transaction be performed.
 **/
@ApiModel(description = "A customer who ultimately requests a transaction be performed.")
public class Customer {

   private String firstName = null;
   private String lastName = null;
   private String address = null;

   /**
    * The customer's first name(s)
    **/
   public Customer firstName(String firstName) {
      this.firstName = firstName;
      return this;
   }

   @ApiModelProperty(value = "The customer's first name(s)")
   @JsonProperty("firstName")
   @Length(max = 40)
   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * The customer's last name
    **/
   public Customer lastName(String lastName) {
      this.lastName = lastName;
      return this;
   }

   @ApiModelProperty(value = "The customer's last name")
   @JsonProperty("lastName")
   @Length(max = 40)
   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * The customer's address
    **/
   public Customer address(String address) {
      this.address = address;
      return this;
   }

   @ApiModelProperty(value = "The customer's address")
   @JsonProperty("address")
   @Length(max = 80)
   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Customer customer = (Customer) o;
      return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName)
            && Objects.equals(address, customer.address);
   }

   @Override
   public int hashCode() {
      return Objects.hash(firstName, lastName, address);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Customer {\n");

      sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
      sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
      sb.append("    address: ").append(toIndentedString(address)).append("\n");
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