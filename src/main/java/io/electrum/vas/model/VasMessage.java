package io.electrum.vas.model;

import java.util.List;

import org.joda.time.DateTime;

public interface VasMessage {
   String getId();

   DateTime getTime();

   List<ThirdPartyIdentifier> getThirdPartyIdentifiers();

   String getStan();

   String getRrn();

   void setId(String id);

   void setTime(DateTime time);

   void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers);

   void setStan(String stan);

   void setRrn(String rrn);
}
