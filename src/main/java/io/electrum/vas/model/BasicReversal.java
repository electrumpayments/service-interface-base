package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static io.electrum.vas.Utils.toIndentedString;

/**
 * An advice that notifies of the negative completion of a transaction. This can be either due to customer cancellation,
 * or as a result of receiving a non-final response (or no response) to a request
 */
@ApiModel(description = "An advice that notifies of the negative completion of a transaction. This can be either due to customer cancellation, or as a result of receiving a non-final response (or no response) to a request")
public class BasicReversal extends BasicAdvice {

   public enum ReversalReason {
      TIMEOUT("TIMEOUT"), CANCELLED("CANCELLED"), RESPONSE_NOT_FINAL("RESPONSE_NOT_FINAL");

      private String value;

      ReversalReason(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   protected ReversalReason reversalReason = null;

   /**
    * The reason for the reversal
    **/
   public BasicReversal reversalReason(ReversalReason reversalReason) {
      this.reversalReason = reversalReason;
      return this;
   }

   @ApiModelProperty(required = true, value = "The reason for the reversal")
   @JsonProperty("reversalReason")
   @NotNull
   public ReversalReason getReversalReason() {
      return reversalReason;
   }

   public void setReversalReason(ReversalReason reversalReason) {
      this.reversalReason = reversalReason;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BasicReversal {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    identifier: ").append(Utils.toIndentedString(identifier)).append("\n");
      sb.append("    reversalReason: ").append(Utils.toIndentedString(reversalReason)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
