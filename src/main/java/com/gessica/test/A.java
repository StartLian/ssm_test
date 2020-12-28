package com.gessica.test;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;

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

//        System.out.println(GetVal());
    	String stringToDate = getStringToDate("2020-12-08 14:55:10");
    	System.out.println("stringToDate:"+stringToDate);
    }
    public static String getStringToDate(String time) {
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 try{
			 date = sf.parse(time);
		 } catch(Exception e) {
		   System.out.println(e.toString());
		 }
		 return date.getTime()+"";
	}
}
