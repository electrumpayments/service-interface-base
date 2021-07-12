package io.electrum.vas.model;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.electrum.sdk.masking2.maskablevalue.MaskableValueSerializer;
import io.electrum.vas.JsonUtil;
import io.electrum.vas.util.JsonMaskingBeanSerializerModifier;

public class TestPanMasking {
   static ObjectMapper objectMapper = new ObjectMapper();
   private PaymentMethod loyaltyCardPayment;

   static void setupBasicObjectMapper(ObjectMapper objectMapper) {
      io.electrum.sdk.util.ObjectMapperUtils.setupBasicObjectMapper(objectMapper);
   }

   static void setupMaskingObjectMapper(ObjectMapper objectMapper) {
      setupBasicObjectMapper(objectMapper);

      SimpleModule module = new SimpleModule("formattedModule");
      module.setSerializerModifier(new JsonMaskingBeanSerializerModifier());
      module.addSerializer(new MaskableValueSerializer());
      module.addSerializer(new io.electrum.sdk.masking.maskablevalue.MaskableValueSerializer());
      objectMapper.registerModule(module);
   }

   @BeforeClass
   public void setup() {
      setupMaskingObjectMapper(objectMapper);

      loyaltyCardPayment =
            new LoyaltyCardPayment().cardNumber("1111222233334444")
                  .amount(new LedgerAmount().amount(100L).currency("710"))
                  .name("Loyalty Card Payment")
                  .issuer(new Institution().id("1234InsId").name("Institution"))
                  .proxy("12345")
                  .proxyType(ProxyType.UNKNOWN);
   }

   @Test(description = "Test we can serialise a model to the expected value when objects are masked.", dataProvider = "maskedSerialisedObjectDataProvider")
   public void testSerialisedObject(Object objectToSerialise, String expectedValue) throws IOException {
      String maskedSerializedValue = objectMapper.writeValueAsString(objectToSerialise);
      Assert.assertEquals(maskedSerializedValue, expectedValue);
   }

   @Test(description = "Test we can serialise what we deserialised and get a masked string back.", dataProvider = "maskedDeserialiseSerialiseObjectDataProvider")
   public void testDeserialiseSerialiseObject(String unmaskedValue, String testString, Class<?> classOfObject)
         throws IOException {
      Assert.assertEquals(
            objectMapper.writeValueAsString(objectMapper.readValue(unmaskedValue, classOfObject)),
            testString);
   }

   @DataProvider
   public Object[][] maskedSerialisedObjectDataProvider() throws Exception {
      return new Object[][] {
            //@formatter:off
            { loyaltyCardPayment,
            JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT_MASKED, false) }
            //@formatter:on
      };
   }

   @DataProvider
   public Object[][] maskedDeserialiseSerialiseObjectDataProvider() throws Exception {
      return new Object[][] {
            //@formatter:off
            { JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT, false),
            JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT_MASKED, false),
            LoyaltyCardPayment.class }
            //@formatter:on
      };
   }
}
