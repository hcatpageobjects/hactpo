package com.hpe.digitalsafe.zippy.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase
{
  String id() default "Not Assigned";
  
  String Description() default "Not Assigned";
  
  String Author() default "Not Assgined";
}