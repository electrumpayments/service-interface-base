package io.electrum.vas.model;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestBasicAdviceModel {

    @Test
    public void tests_serialization_basicAdvice_and_deserialization() throws IOException, IllegalAccessException {
        BasicAdvice basicAdvice = new BasicAdvice();
        basicAdvice.setId(RandomStringUtils.random(16));
        basicAdvice.setRequestId(RandomStringUtils.random(32));
        basicAdvice.setRrn(RandomStringUtils.random(16));
        basicAdvice.setStan(RandomStringUtils.random(16));
        List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();
        thirdPartyIdentifiers.add(new ThirdPartyIdentifier().institutionId(RandomStringUtils.random(16)).transactionIdentifier(RandomStringUtils.random(16)));
        basicAdvice.setThirdPartyIdentifiers(thirdPartyIdentifiers);
        basicAdvice.setAmounts(TestingConstants.AMOUNTS_FULL_REVERSAL);
        NewModelTests modelTests = new NewModelTests();
        modelTests.testSerialisedObject(TestingConstants.getFullReversalAdvice(), TestingConstants.getSerializedFullReversalBasicAdvice());
        modelTests.testSerialisedObject(TestingConstants.getPartialReversalAdvice(), TestingConstants.getSerializedPartialReversalBasicAdvice());
        modelTests.testDeserialisedObject(TestingConstants.getSerializedFullReversalBasicAdvice(), TestingConstants.getFullReversalAdvice());
        modelTests.testDeserialisedObject(TestingConstants.getSerializedPartialReversalBasicAdvice(), TestingConstants.getPartialReversalAdvice());
        modelTests.testDeserialiseSerialiseObject(TestingConstants.getSerializedFullReversalBasicAdvice(), BasicAdvice.class);
        modelTests.testDeserialiseSerialiseObject(TestingConstants.getSerializedPartialReversalBasicAdvice(), BasicAdvice.class);
        modelTests.testSerialiseDeserialiseObject(TestingConstants.getFullReversalAdvice());
        modelTests.testSerialiseDeserialiseObject(TestingConstants.getPartialReversalAdvice());

    }

}
