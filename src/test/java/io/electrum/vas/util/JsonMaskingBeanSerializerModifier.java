package io.electrum.vas.util;

import java.util.List;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

public class JsonMaskingBeanSerializerModifier extends BeanSerializerModifier {

   @Override
   public List<BeanPropertyWriter> changeProperties(
         SerializationConfig config,
         BeanDescription beanDesc,
         List<BeanPropertyWriter> beanProperties) {

      for (BeanPropertyWriter beanProperty : beanProperties) {
         io.electrum.sdk.masking2.Masked newMask = beanProperty.getAnnotation(io.electrum.sdk.masking2.Masked.class);
         if (newMask != null) {
            beanProperty.assignSerializer(new JsonMaskingSerializer(newMask.value()));
         }
      }

      return beanProperties;
   }
}
