package com.gessica.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestMain {

		 /*private static volatile int s = 0;
		 private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
		         0, Integer.MAX_VALUE,
		         60L, TimeUnit.SECONDS, new SynchronousQueue<>());
		 public static void main(String[] args) throws InterruptedException {
				 for (int i = 0; i < 10000; i++) {
			         async.execute(()-> s++);
			}
		    
		     Thread.sleep(5000L);
		     System.out.println(s);
	}*/
	/*public static void main(String[] args) {
	       Map<String, Object> map = new HashMap<>();
	       String str = "没人比我更懂java";
	       StrObject obj = new StrObject("没人比我更懂java");
	       map.put("str", str);
	       map.put("obj", obj);

	       str = "真的没人比我更懂java";
	       System.out.printf(map.get("str").toString()+"; ");

	       StrObject new_obj = (StrObject) map.get("obj");
	       new_obj.setStr("真的没人比我更懂java");
	       System.out.printf(map.get("obj").toString()+"; ");
	   }
	   static class StrObject{
	       String str;
	       public StrObject(String str){
	           this.str = str;
	       }
	       public void setStr(String str){
	           this.str = str;
	       }
	       @Override
	       public String toString() {
	           return str;
	       }
	   }*/
	/*public static void main(String[] args) {
		 String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
		 String si = "没人比我更懂java";
		 System.out.println(s == si);
		 System.out.println(s.intern() == "没人比我更懂java");
		 System.out.println(s == si.intern());
		int length = "没人比我更懂java".toCharArray().length;
		System.out.println("+"+length);
	       System.out.print(method(0));
	   }
	   private static Integer method(Integer i){
	       try{
	           if(i++ > 0)
	               throw new IOException();
	           return i++;
	       }catch (IOException e){
	           i++;
	           return i++;
	       }catch (Exception e){
	           i++;
	           return i++;
	       }finally {
	           return i++;
	       }
	   }*/
//	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			
//			testThread();
//			System.out.println("");
//		}
//	   }
//		private static void testThread() {
//			Thread t = new Thread() {
//			       public void run() {
//			           cnn();
//			       }
//			   };
//			   t.run();
//			   System.out.print("FakeNews ");
//   System.out.print("; ");
//			   t.start();
//			   System.out.print("FakeNews ");
//		}
//	   static void cnn() {
//	       System.out.print("CNN ");
//	   }
	  /* public static void main(String[] args) throws Exception {
		   updata1();
		   System.out.println("1");
		   updata2();
		   System.out.println("2");
		   updata3();
		   System.out.println("3");
		   updata4();
		   System.out.println("4");
	   }

		private static void updata1() throws Exception {
			throw new Exception();
			
		}
		private static void updata2() throws Exception {
			throw new Exception();
			
		}
		private static void updata3() {
			throw new Error();
		}
		private static void updata4() throws Exception {
			throw new Exception();
			
		}*/
	static int index = 0;
	static String[] vals= new String[100];
	static String keytemp = "";
	public static void main(String[] args) throws Exception {
//		{"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
		Map<String,Object> map = new HashMap<>();
		Map<String,Object> map1 = new HashMap<>();
		Map<String,Object> mapb = new HashMap<>();
		map1.put("c", 0);
		Object[] obj = {"v",2,map1};
		mapb.put("b", obj);
		Object[] obj2 = {1,null,3};
		map.put("a", mapb);
		map.put("d", obj2);
		Set<String> showMap = showMap(map);
		for (String string : showMap) {
			keytemp = "";
			System.out.println("string:"+string);
		}
	}
	
		public static Set<String> showMap(Map<String, Object> map) {
			
			 //TODO your code goes here...
				 Object value = null;
				Set<String> set = new HashSet<>();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					 value = entry.getValue();
					 String[] strval = analysisValue(entry.getKey(),value);
					 for (String string : strval) {
						 set.add(string);
					}
				}
			 return set;
			}
			
			private static String[] analysisValue(String key,Object value) {
				keytemp += key;
				if ((value instanceof Integer) || (value instanceof String)) {
					vals[index++]=keytemp+" = "+value;
				}
				if (value instanceof Map) {
					Map<String, Object> map1 = (Map<String, Object>) value;
					keytemp +=".";
					for (Map.Entry<String, Object> entry : map1.entrySet()) {
						 value = entry.getValue();
						 analysisValue(entry.getKey(),value);
					}
				}
				if (value instanceof Object[]) {
					Object[] strs = (Object[]) value;
					int i = 0;
					for (i=0 ; i < strs.length; i++) {
						if ((strs[i] instanceof Integer) || (strs[i] instanceof String)) {
							keytemp +="[";
							System.out.println("i"+strs[i]);
							vals[index++]= keytemp+i+"] = "+strs[i];
						}else {
							keytemp +="["+i+"]";
							analysisValue(key,strs[i]);
						}
					}
				}
				return vals;
			}
	   
}
