package io.electrum.vas.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Arrays;
import java.util.List;

public class TestingConstants {


    //CONSTANTS FOR CONSTRUCTING A BASIC ADVICE INSTANCE

    public static String ID = RandomStringUtils.randomAlphabetic(16);
    public static String REQUEST_ID = RandomStringUtils.randomAlphabetic(16);
    public static DateTime TIME = DateTime.now().toDateTime(DateTimeZone.UTC);
    public static List<ThirdPartyIdentifier> THIRDPARTYIDENTIFIERS = Arrays.asList(getThirdPartyIdentifier());
    public static String STAN = RandomStringUtils.randomAlphabetic(16);;
    public static String RRN = RandomStringUtils.randomAlphabetic(16);;
    public static Amounts AMOUNTS_FULL_REVERSAL = new Amounts();
    public static Amounts AMOUNTS_PARTIAL_REVERSAL = new Amounts().approvedAmount(new LedgerAmount().amount(9000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT));

    public static String getSerializedPartialReversalBasicAdvice() {
        StringBuilder SERIALIZED_BASIC_ADVICE = new StringBuilder().append("{")
                .append("\"id\":").append("\"" + ID + "\",").append("\"requestId\":").append("\"" + REQUEST_ID + "\",").append("\"time\":")
                .append("\"" + TIME.toString("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'") + "\",")
                .append("\"thirdPartyIdentifiers\":").append("[{").append("\"institutionId\":").append("\"" + THIRDPARTYIDENTIFIERS.get(0).getInstitutionId() + "\",")
                .append("\"transactionIdentifier\":").append("\"" + THIRDPARTYIDENTIFIERS.get(0).getTransactionIdentifier() + "\"").append("}],")
                .append("\"stan\":").append("\"" + STAN + "\",").append("\"rrn\":").append("\"" + RRN + "\",")
                .append("\"amounts\":").append("{").append("\"approvedAmount\":").append("{").append("\"amount\":").append(9000 + ",").append("\"currency\":").append("\"710\",")
                .append("\"ledgerIndicator\":").append("\"DEBIT\"").append("}}}");

        return SERIALIZED_BASIC_ADVICE.toString();
    }

    public static String getSerializedFullReversalBasicAdvice() {
        StringBuilder SERIALIZED_BASIC_ADVICE = new StringBuilder().append("{")
                .append("\"id\":").append("\"" + ID + "\",").append("\"requestId\":").append("\"" + REQUEST_ID + "\",").append("\"time\":")
                .append("\"" + TIME.toString("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")+ "\",")
                .append("\"thirdPartyIdentifiers\":").append("[{").append("\"institutionId\":").append("\"" + THIRDPARTYIDENTIFIERS.get(0).getInstitutionId() + "\",")
                .append("\"transactionIdentifier\":").append("\"" + THIRDPARTYIDENTIFIERS.get(0).getTransactionIdentifier() + "\"").append("}],")
                .append("\"stan\":").append("\"" + STAN + "\",").append("\"rrn\":").append("\"" + RRN + "\",")
                .append("\"amounts\":").append("{").append("}}");

        return SERIALIZED_BASIC_ADVICE.toString();
    }

    public static BasicAdvice getFullReversalAdvice() {
        return new BasicAdvice()
                .amounts(AMOUNTS_FULL_REVERSAL)
                .id(ID).requestId(REQUEST_ID)
                .time(TIME)
                .rrn(RRN)
                .stan(STAN)
                .transactionIdentifiers(THIRDPARTYIDENTIFIERS);
    }

    public static BasicAdvice getPartialReversalAdvice() {
        return new BasicAdvice()
                .amounts(AMOUNTS_PARTIAL_REVERSAL)
                .id(ID).requestId(REQUEST_ID)
                .time(TIME)
                .rrn(RRN)
                .stan(STAN)
                .transactionIdentifiers(THIRDPARTYIDENTIFIERS);
    }

    private static ThirdPartyIdentifier getThirdPartyIdentifier(){
        return new ThirdPartyIdentifier()
                .institutionId(RandomStringUtils.randomAlphanumeric(16))
                .transactionIdentifier(RandomStringUtils.randomAlphanumeric(16));
    }
}
