package io.electrum.vas.model;

import io.electrum.vas.Utils;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required in all value added service requests
 **/
@ApiModel(description = "The data required in all value added service requests")
public class BasicResponse {

   protected UUID id = null;
   protected DateTime time = null;
   protected Sender sender = null;
   protected Object linkData = null;
   protected Institution processor = null;
   protected Institution receiver = null;

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public BasicResponse id(UUID id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   /**
    * The date and time of the request in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public BasicResponse time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * Data relating to the originator of the transaction
    **/
   public BasicResponse sender(Sender sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the originator of the transaction")
   @JsonProperty("sender")
   @NotNull
   public Sender getSender() {
      return sender;
   }

   public void setSender(Sender sender) {
      this.sender = sender;
   }

   /**
    * This object may be used by the service implementation to link a payment to a payment confirmation or cancellation,
    * and should be provided unaltered by clients in corresponding requests
    **/
   public BasicResponse linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "This object may be used by the service implementation to link a payment to a payment confirmation or cancellation, and should be provided unaltered by clients in corresponding requests")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }

   /**
    * Detail regarding the institution that processed the message
    **/
   public BasicResponse processor(Institution processor) {
      this.processor = processor;
      return this;
   }

   @ApiModelProperty(value = "Detail regarding the institution that processed the message")
   @JsonProperty("processor")
   public Institution getProcessor() {
      return processor;
   }

   public void setProcessor(Institution processor) {
      this.processor = processor;
   }

   /**
    * Detail regarding the bill issuing institution
    **/
   public BasicResponse receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(required = true, value = "Detail regarding the bill issuing institution")
   @JsonProperty("receiver")
   @NotNull
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BasicRequest vasRequest = (BasicRequest) o;
      return Objects.equals(id, vasRequest.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BasicResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    sender: ").append(Utils.toIndentedString(sender)).append("\n");
      sb.append("    linkData: ").append(Utils.toIndentedString(linkData)).append("\n");
      sb.append("    processor: ").append(Utils.toIndentedString(processor)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
