package io.electrum.vas.api;

public interface ResourceTestInterface {

   void correctBaseMethod(Object obj);

   /**
    * Incorrectly does not call back to base method.
    * 
    * @param obj
    * @param obj2
    */
   default void correctBaseMethod(Object obj, Object obj2) {
      correctBaseMethod(obj);
   }

   void incorrectBaseMethod(Object obj);

   /**
    * Incorrectly does not call back to base method.
    * 
    * @param obj
    * @param obj2
    */
   default void incorrectBaseMethod(Object obj, Object obj2) {

   }
}
