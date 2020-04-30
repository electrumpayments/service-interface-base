package io.electrum.vas.interfaces;

import java.util.List;

import io.electrum.vas.model.PaymentMethod;

/**
 * An interface for use within child service-interface projects. This enables us to implement logic to do payment
 * orchestration across multiple service-interface implementations polymorphically. It thus allows us to use a single
 * utility method for managing Payment Methods across separate service-interface implementations.
 *
 * This was designed for Capitec VAS Airtime and PPU messages.
 */
public interface HasPaymentMethods {

   List<PaymentMethod> getPaymentMethods();

   void setPaymentMethods(List<PaymentMethod> paymentMethods);
}
