package io.electrum.vas.interfaces;

import io.electrum.vas.model.Amounts;

/**
 * An interface for use within child service-interface projects. This enables one to implement utilities across multiple
 * api implementations which use the Amounts model.
 */
public interface HasAmounts {

   Amounts getAmounts();

   void setAmounts(Amounts amounts);
}
