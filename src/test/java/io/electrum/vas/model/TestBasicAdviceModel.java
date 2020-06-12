package io.electrum.vas.model;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestBasicAdviceModel {
    private BasicAdvice basicAdvice = null;

    @Test
    public void tests_serialization_deserialation() throws IOException, IllegalAccessException {
        basicAdvice = new BasicAdvice();
        basicAdvice.setId(RandomStringUtils.random(16));
        basicAdvice.setRequestId(RandomStringUtils.random(32));
        basicAdvice.setRrn(RandomStringUtils.random(16));
        basicAdvice.setStan(RandomStringUtils.random(16));
        List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();
        thirdPartyIdentifiers.add(new ThirdPartyIdentifier().institutionId(RandomStringUtils.random(16)).transactionIdentifier(RandomStringUtils.random(16)));
        basicAdvice.setThirdPartyIdentifiers(thirdPartyIdentifiers);
        basicAdvice.setAmounts(TestingConstants.AMOUNTS_FULL_REVERSAL);
        NewModelTests modelTests = new NewModelTests();
        modelTests.testSerialisedObject(TestingConstants.getFullReversalAdvice(),TestingConstants.getSerializedFullReversalBasicAdvice());
        modelTests.testSerialisedObject(TestingConstants.getPartialReversalAdvice(),TestingConstants.getSerializedPartialReversalBasicAdvice());
        modelTests.testDeserialisedObject(TestingConstants.getSerializedFullReversalBasicAdvice(),TestingConstants.getFullReversalAdvice());
        modelTests.testDeserialisedObject(TestingConstants.getSerializedPartialReversalBasicAdvice(),TestingConstants.getPartialReversalAdvice());
        modelTests.testDeserialiseSerialiseObject(TestingConstants.getSerializedFullReversalBasicAdvice(),BasicAdvice.class);
        modelTests.testDeserialiseSerialiseObject(TestingConstants.getSerializedPartialReversalBasicAdvice(),BasicAdvice.class);
        modelTests.testSerialiseDeserialiseObject(TestingConstants.getFullReversalAdvice());
        modelTests.testSerialiseDeserialiseObject(TestingConstants.getPartialReversalAdvice());

    }

    public String serialize(Object object) throws IllegalAccessException {
        if(object instanceof String || object.getClass().isPrimitive())
        {
            return "{"+object.getClass().getName();
        }
        StringBuilder serializedBasicAdvice = new StringBuilder();
        serializedBasicAdvice.append("{");
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.get(object) != null) {
                serializedBasicAdvice.append("\"").append(field.getName()).append("\":");
                if(field.get(object) instanceof String)
                    serializedBasicAdvice.append("\"").append(field.get(object)).append("\",");
                else
                    serializedBasicAdvice.append(field.get(object)).append(",");
            }
        }
        serializedBasicAdvice.append("\"");
        serializedBasicAdvice.append("}");

        return serializedBasicAdvice.toString();
    }



}
