package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.sdk.masking2.Masked;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @since v1.31.0
 */
@ApiModel(description = "Model for QR-based payments. "
      + "This payment method should be used when a QR code is presented for payment.", parent = PaymentMethod.class)
public class QrPayment extends PaymentMethod {

   private String tranId = null;

   private String partnerPaymentToken = null;

   public QrPayment() {
      setType(PaymentMethodType.QR);
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction.")
   @JsonProperty("tranId")
   @NotNull
   @Masked
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * The unique transaction identifier related to this transaction.
    *
    * @param tranId
    *           The transaction ID.
    * @return this object.
    **/
   public QrPayment tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the Partner.")
   @JsonProperty("partnerPaymentToken")
   @Masked
   public String getPartnerPaymentToken() {
      return partnerPaymentToken;
   }

   public void setPartnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
   }

   /**
    * A payment token received from the Partner. This field
    * should be populated if known. A Partner may expect to receive this value in the {@link QrPayment}.
    *
    * @param partnerPaymentToken
    *           The partner's payment token.
    * @return this object.
    **/
   public QrPayment partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof QrPayment)) return false;
      if (!super.equals(o)) return false;
      QrPayment qrPayment = (QrPayment) o;
      return tranId.equals(qrPayment.tranId) && Objects.equals(partnerPaymentToken, qrPayment.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), tranId, partnerPaymentToken);
   }

   @Override
   public String toString() {
      return new StringJoiner(", ", QrPayment.class.getSimpleName() + "[", "]")
            .add("type=" + type)
            .add("name='" + name + "'")
            .add("amount=" + amount)
            .add("issuer=" + issuer)
            .add("pin=" + pin)
            .add("proxy='" + proxy + "'")
            .add("proxyType=" + proxyType)
            .add("tranId='" + tranId + "'")
            .add("partnerPaymentToken='" + partnerPaymentToken + "'")
            .toString();
   }
}
