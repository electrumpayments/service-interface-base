package io.electrum.vas.interfaces;

import io.electrum.vas.model.Tender;

import java.util.List;

/**
 * An interface for use within child service-interface projects. This enables one to implement utilities across multiple
 * api implementations which use the Tenders model.
 */

public interface HasTenders {

    List<Tender> getTenders();

    void setTenders(List<Tender> tenders);
}
