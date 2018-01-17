package io.electrum.vas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required in all value added service transactions.
 **/
@ApiModel(description = "The data required in all value added service transactions.")
public class Transaction {

   protected String id = null;
   protected DateTime time = null;
   protected Originator originator = null;
   protected Institution client = null;
   protected Institution settlementEntity = null;
   protected Institution receiver = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();
   protected SlipData slipData = null;
   protected String basketRef = null;
   protected TranType tranType = null;
   protected AccountType srcAccType = null;
   protected AccountType destAccType = null;

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public Transaction id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public Transaction time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   @Valid
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * Data relating to the originator of the transaction
    **/
   public Transaction originator(Originator originator) {
      this.originator = originator;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the originator of the transaction")
   @JsonProperty("originator")
   @NotNull
   @Valid
   public Originator getOriginator() {
      return originator;
   }

   public void setOriginator(Originator originator) {
      this.originator = originator;
   }

   /**
    * Data relating to the sender of BasicRequest.
    **/
   public Transaction client(Institution client) {
      this.client = client;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the sender of Transaction.")
   @JsonProperty("client")
   @NotNull
   @Valid
   public Institution getClient() {
      return client;
   }

   public void setClient(Institution client) {
      this.client = client;
   }

   /**
    * Data relating to the entity with whom the Merchant will settle the transaction.
    **/
   public Transaction settlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity with whom the Merchant will settle the transaction.")
   @JsonProperty("settlementEntity")
   @Valid
   public Institution getSettlementEntity() {
      return settlementEntity;
   }

   public void setSettlementEntity(Institution settlementEntity) {
      this.settlementEntity = settlementEntity;
   }

   /**
    * Data relating to the entity which ultimately processes the request.
    **/
   public Transaction receiver(Institution receiver) {
      this.receiver = receiver;
      return this;
   }

   @ApiModelProperty(value = "Data relating to the entity which ultimately processes the request.")
   @JsonProperty("receiver")
   @Valid
   public Institution getReceiver() {
      return receiver;
   }

   public void setReceiver(Institution receiver) {
      this.receiver = receiver;
   }

   /**
    * An array of identifiers which each identify the transaction within each entity's system.
    **/
   public Transaction thirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(required = true, value = "An array of identifiers which each identify the transaction within each entity's system.")
   @JsonProperty("thirdPartyIdentifiers")
   @NotNull
   @Valid
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   public Transaction slipData(SlipData slipData) {
      this.slipData = slipData;
      return this;
   }

   /**
    * Text to be printed on the customer receipt.
    * 
    * @return slipData
    **/
   @ApiModelProperty(value = "Text to be printed on the customer receipt.")
   @JsonProperty("slipData")
   @Valid
   public SlipData getSlipData() {
      return slipData;
   }

   public void setSlipData(SlipData slipData) {
      this.slipData = slipData;
   }

   /**
    * Used to group multiple transactions which would otherwise be considered independent.
    **/
   public Transaction basketRef(String basketRef) {
      this.basketRef = basketRef;
      return this;
   }

   @ApiModelProperty(required = false, value = "Used to group multiple transactions which would otherwise be considered independent.")
   @JsonProperty("basketRef")
   public String getBasketRef() {
      return basketRef;
   }

   public void setBasketRef(String basketRef) {
      this.basketRef = basketRef;
   }

   /**
    * Data relating to the type of transaction taking place (i.e. cash withdrawal, goods and services etc.)
    **/
   public Transaction tranType(TranType tranType) {
      this.tranType = tranType;
      return this;
   }

   @ApiModelProperty(value = "Gets the type of transaction being processed")
   @JsonProperty("transactionType")
   /**
    * Gets the type of transaction being processed
    */
   public TranType getTranType() {
      return tranType;
   }

   public void setTranType(TranType tranType) {
      this.tranType = tranType;
   }

   /**
    * This specifies the type of source account being used in the transaction (i.e. cheque, savings)
    *
    **/
   public Transaction srcAccType(AccountType srcAccType) {
      this.srcAccType = srcAccType;
      return this;
   }

   @ApiModelProperty(value = "Gets the account type for the source account in the transaction")
   @JsonProperty("srcAccType")
   /**
    * Gets the account type for the source account in the transaction
    * 
    * @return srcAccTypes
    */
   public AccountType getSrcAccType() {
      return srcAccType;
   }

   public void setSrcAccType(AccountType srcAccType) {
      this.srcAccType = srcAccType;
   }

   /**
    * This specifies the type of destination account being used in the transaction (i.e. cheque, savings)
    *
    **/
   public Transaction destAccType(AccountType destAccType) {
      this.destAccType = destAccType;
      return this;
   }

   @ApiModelProperty(value = "Gets the account type for the destination account in the transaction")
   @JsonProperty("destAccType")
   /**
    * Gets the account type for the destination account in the transaction
    * 
    * @return destAccType
    **/
   public AccountType getDestAccType() {
      return destAccType;
   }

   public void setDestAccType(AccountType destAccType) {
      this.destAccType = destAccType;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Transaction vasRequest = (Transaction) o;
      return Objects.equals(id, vasRequest.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Transaction {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    originator: ").append(Utils.toIndentedString(originator)).append("\n");
      sb.append("    client: ").append(Utils.toIndentedString(client)).append("\n");
      sb.append("    settlementEntity: ").append(Utils.toIndentedString(settlementEntity)).append("\n");
      sb.append("    receiver: ").append(Utils.toIndentedString(receiver)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("    slipData: ").append(Utils.toIndentedString(slipData)).append("\n");
      sb.append("    basketRef: ").append(Utils.toIndentedString(basketRef)).append("\n");
      sb.append("    tranType: ").append(Utils.toIndentedString(tranType)).append("\n");
      sb.append("    srcAccType: ").append(Utils.toIndentedString(srcAccType)).append("\n");
      sb.append("    destAccType: ").append(Utils.toIndentedString(destAccType)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
