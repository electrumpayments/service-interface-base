package io.electrum.vas.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An advice that notifies of the successful completion of a transaction. Confirmations should only be implemented by
 * service implementations where additional information is present in the confirmation. Otherwise, a single message
 * implementation is preferable
 */
@ApiModel(description = "An advice that notifies of the successful completion of a transaction.")
public class TenderAdvice extends BasicAdvice {

   protected List<Tender> tenders = new ArrayList<>();

   /**
    * An array of tenders used to pay for the transaction
    **/
   public TenderAdvice tenders(List<Tender> tenders) {
      this.tenders = tenders;
      return this;
   }

   @ApiModelProperty(required = true, value = "An array of tenders used to pay for the transaction")
   @JsonProperty("tenders")
   public List<Tender> getTenders() {
      return tenders;
   }

   public void setTenders(List<Tender> tenders) {
      this.tenders = tenders;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class TenderAdvice {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    tenders: ").append(Utils.toIndentedString(tenders)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
