package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A customer who ultimately requests a transaction be performed.
 **/
@ApiModel(description = "A customer who ultimately requests a transaction be performed.")
public class Customer {

   private String firstName = null;
   private String lastName = null;
   private String address = null;
   private DateTime dateOfBirth = null;
   private String status = null;
   private String msisdn = null;

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

   /**
    * The customer's date of birth
    **/
   public Customer dateOfBirth(DateTime dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
   }

   @ApiModelProperty(value = "The customer's date of birth")
   @JsonProperty("dateOfBirth")
   @Valid
   public DateTime getDateOfBirth() {
      return dateOfBirth;
   }

   public void setDateOfBirth(DateTime dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
   }

   /**
    * The status of this customer on the Giftcard system. For example: active, inactive
    **/
   public Customer status(String status) {
      this.status = status;
      return this;
   }

   @ApiModelProperty(value = "The status of this customer on the Giftcard system. For example: active, inactive")
   @JsonProperty("status")
   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   /**
    * The customer's Mobile Subscriber Integrated Services Digital Network-Number (MSISDN). This must conform to the ITU E.164
    * numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South African number.
    **/
   public Customer msisdn(String msisdn) {
      this.msisdn = msisdn;
      return this;
   }

   @ApiModelProperty(required = true, value = "This must conform to the ITU E.164 numbering plan (https://www.itu.int/rec/T-REC-E.164/en) e.g. 27821234567 for a South African number.")
   @Pattern(regexp = "^\\+?[1-9]\\d{0,14}")
   @JsonProperty("msisdn")
   @NotNull
   public String getMsisdn() {
      return msisdn;
   }

   public void setMsisdn(String msisdn) {
      this.msisdn = msisdn;
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
            && Objects.equals(address, customer.address) && Objects.equals(dateOfBirth, customer.dateOfBirth)
            && Objects.equals(status, customer.status) && Objects.equals(msisdn, customer.msisdn);
   }

   @Override
   public int hashCode() {
      return Objects.hash(firstName, lastName, address, dateOfBirth, status, msisdn);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Customer {\n");

      sb.append("    firstName: ").append(Utils.toIndentedString(firstName)).append("\n");
      sb.append("    lastName: ").append(Utils.toIndentedString(lastName)).append("\n");
      sb.append("    address: ").append(Utils.toIndentedString(address)).append("\n");
      sb.append("    dateOfBirth: ").append(Utils.toIndentedString(dateOfBirth)).append("\n");
      sb.append("    status: ").append(Utils.toIndentedString(status)).append("\n");
      sb.append("    msisdn: ").append(Utils.toIndentedString(msisdn)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}