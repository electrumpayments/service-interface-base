package io.electrum.vas.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The annotated element must be a valid {@link java.util.UUID}.
 */
@Target({ FIELD, METHOD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = UuidValidator.class)
@Documented
public @interface Uuid {

   String DEFAULT_MESSAGE = "must be a valid UUID";

   String message() default DEFAULT_MESSAGE;

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

   /**
    * Defines several {@link Uuid} annotations on the same element.
    *
    * @see io.electrum.vas.validation.Uuid
    */
   @Target({ FIELD, METHOD, PARAMETER })
   @Retention(RUNTIME)
   @Documented
   @interface List {

      Uuid[] value();
   }
}
