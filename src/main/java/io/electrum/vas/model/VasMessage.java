package io.electrum.vas.model;

import org.joda.time.DateTime;

import java.util.List;

public interface VasMessage {
    String getId();
    DateTime getTime();
    List<ThirdPartyIdentifier> getThirdPartyIdentifiers();
    void setId(String id);
    void setTime(DateTime time);
    void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers);
}
