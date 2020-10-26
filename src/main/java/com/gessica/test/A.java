package com.gessica.test;

import java.lang.reflect.Constructor;

import com.gessica.test.A.Inner;

public class A {
	class Inner {
        public String  v1 = "Fake News";
        public String v2 = "Go ahead";
    }

    private static String GetVal() {
        try {
            return Inner.class.newInstance().v1;
        } catch (Exception e) {
            try {
            	Constructor<Inner> constructor = Inner.class.getDeclaredConstructor(A.class);
            	Inner newInstance = constructor.newInstance((A)null);
                return newInstance.v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }
    public static void main(String[] args) {

        System.out.println(GetVal());
    }
}
