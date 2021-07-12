package io.electrum.vas.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.electrum.sdk.masking2.Masker;

public class JsonMaskingSerializer extends JsonSerializer<Object> {

    private Class<? extends Masker> maskerClass;

    public JsonMaskingSerializer(Class<? extends Masker> maskerClass) {
        this.maskerClass = maskerClass;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {

        try {
            Masker masker = maskerClass.newInstance();
            gen.writeString(masker.mask(value.toString()));
        } catch (Exception e) {
            gen.writeString("ERROR");
        }
    }
}
