package io.electrum.vas.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Utils {

   /**
    * Locates and returns the method called {@code methodName} in class {@code clazz} which has the fewest number of
    * parameters
    * <p>
    * If no method is found, this method simply returns {@code null}.
    * <p>
    * An optional {@code List<Method>} may be supplied in which case it is populated with all the methods called
    * {@code methodName} in no particular order.
    * <p>
    * If no {@code List<Method>} is provided then this method is equivalent to simply calling
    * {@link #findBaseMethod(Class, String)}.
    * 
    * @param clazz
    * @param methodName
    * @param methodOverloads
    * @return
    */
   public static Method findBaseMethod(
         @NotNull Class<?> clazz,
         @NotNull String methodName,
         final List<Method> methodOverloads) {
      if (methodOverloads == null) {
         return findBaseMethod(clazz, methodName);
      }
      Method baseMethod = null;
      for (Method method : clazz.getMethods()) {
         if (method.getName().equals(methodName)) {
            methodOverloads.add(method);
            if (baseMethod == null || method.getParameterCount() < baseMethod.getParameterCount()) {
               baseMethod = method;
            }
         }
      }
      return baseMethod;
   }

   /**
    * Locates and returns the method called {@code methodName} in class {@code clazz} which has the fewest number of
    * parameters
    * <p>
    * If no method is found, this method simply returns {@code null}.
    * 
    * @param clazz
    * @param methodName
    * @return
    */
   public static Method findBaseMethod(@NotNull Class<?> clazz, @NotNull String methodName) {
      Method baseMethod = null;
      for (Method method : clazz.getMethods()) {
         if (method.getName().equals(methodName)
               && (baseMethod == null || method.getParameterCount() < baseMethod.getParameterCount())) {
            baseMethod = method;
         }
      }
      return baseMethod;
   }
}
