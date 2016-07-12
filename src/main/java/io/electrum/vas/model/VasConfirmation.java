package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * An advice that notifies of the successful completion of a transaction. Confirmations should only be implemented by
 * service implementations where additional information is present in the confirmation. Otherwise, a single message
 * implementation is preferable.
 */
public abstract class VasConfirmation extends VasAdvice {

   protected List<Tender> tenders = new ArrayList<>();

   /**
    * An array of tenders used to pay for the transaction
    **/
   public VasConfirmation tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = true, value = "An array of tenders used to pay for the transaction")
   @JsonProperty("tenders")
   @NotEmpty
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }
}
