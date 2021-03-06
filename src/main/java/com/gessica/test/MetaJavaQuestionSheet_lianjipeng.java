package com.gessica.test;
//本试卷唯一 ID: CE2DAC34973FEA46F36AE7DDBB461533, 请勿修改本行内容
/* 注意, 这里不要写包名. 留空 */
/* 这里如果用到其他的类, 记得要引用, 否则编译不过 */
import java.util.*;
import java.util.Map.Entry;
/**
* 回答方式: 直接保存或者复制本java文件, 然后在原处作答. 建议重命名成 meta-java-<姓名>.java
* 选择题改变量赋值的字符串
* 实现题在原本的函数体里返回正确答案, 注意不要改动函数结构. 用这一个Java文件完成
* 本卷直接用代码判卷, 没有人工干预. 格式错误, 语法错误, 格式改动会导致试卷无效
*
* 注: 一个java文件可以有多个类, 但只能有一个public类. 所以你的实现中可以建内部类, 辅助类. 可以javac编译确认自己语法无误
* 以下带public static修饰的实现题方法, 不要改变这个签名
*
*
* 这里不要更改默认的类名, 也不要更改修饰符不要加public. 类名保持为 MetaJavaQuestionSheet
* 可以改文件名, 建议改为 meta-java-<姓名>.java
*/
import java.util.concurrent.ThreadPoolExecutor;

import com.gessica.test.MetaJavaQuestionSheet_lianjipeng.TreeNode;
class MetaJavaQuestionSheet_lianjipeng {
 
/* qn0: 
 只是样例! 不用改动
 
 A. 别选我
 
 B. 选我, 选我就得分
 
 C. 也选我, 选我就得分
 
 D. 别选我
*/
 public static String qn0 = "BC";
/* qn1: 
 public class Queue {
	private int size;
	private int[] data;
	private int front, rear;

	public Queue(int size) {
	    this.size = size;
	    data = new int[size];
	    front = 0; rear = 0;
	}
}
int MaxSize=10;
Quene q = new Queue(MaxSize);

对于q来说，以下能判断队列满的条件是(D)
 
 A. q.front + q.rear == MaxSize;
 
 B. q.front == q.rear;
 
 C. q.front - q.rear == MaxSize;
 
 D. q.front == (q.rear+1) % MaxSize;
*/
 public static String qn1 = null;
/* qn2: 
 下列代码的输出结果不可能是:B
 private static volatile int s = 0;
 private static final ThreadPoolExecutor async = new ThreadPoolExecutor(
         0, Integer.MAX_VALUE,
         60L, TimeUnit.SECONDS, new SynchronousQueue<>());
 public static void main(String[] args) throws InterruptedException {
     for (int i = 0; i < 10000; i++) {
         async.execute(()-> s++);
     }
     Thread.sleep(5000L);
     System.out.println(s);
 }
 
 A. 9998
 
 B. 10001
 
 C. 10000
 
 D. 9999
*/
 public static String qn2 = null;
/* qn3: 
 一棵二叉树后序遍历的节点顺序是: 6 4 5 2 7 3 1 ，中序遍历是: 6 4 2 5 1 3 7 ，则前序遍历结果为:A
 
 A. 1 2 4 6 5 3 7
 
 B. 1 2 4 6 5 7 3
 
 C. 1 2 4 5 6 3 7
 
 D. 1 2 3 4 5 6 7
*/
 public static String qn3 = null;
/* qn4: 
 若进栈序列为a，b，c，d，e，f，进栈和出栈可以穿插进行，则不可能出现的出栈序列是(A)
 
 A. b，c，e，a，f，d
 
 B. d，c，b，a，e，f
 
 C. b，d，c，a，e，f
 
 D. c，b，d，a，f，e
*/
 public static String qn4 = null;
/* qn5: 
 下面代码会输出怎样的结果:B
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
                 return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
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
 
 A. Fake News, Go ahead
 
 B. Go ahead
 
 C. 以上都不对
 
 D. Fake News
*/
 public static String qn5 = null;
/* qn6: 
 下面代码会分别输出怎样的结果:A
   public static void main(String[] args) {
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
   }
 
 A. 没人比我更懂java; 真的没人比我更懂java;
 
 B. 真的没人比我更懂java; 真的没人比我更懂java;
 
 C. 真的没人比我更懂java; 没人比我更懂java;
 
 D. 没人比我更懂java; 没人比我更懂java;
*/
 public static String qn6 = null;
/* qn7: 
 下面的代码在java(jdk8)最终会产生几个String对象:B
 String a = "没人";
 String b = "比我";
 String c = "更懂";
 String d = "java";
 String s = a + b + c + d;
 
 A. 5
 
 B. 7
 
 C. 6
 
 D. 8
*/
 public static String qn7 = null;
/* qn8: 
 main()方法如下，try中可以捕获两种类型的异常，如果在该方法运行中产生了一个IOException，将会输出怎样的结果:A
   public static void main(String[] args) {
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
   }
 
 A. 2
 
 B. 会抛错 没有输出
 
 C. 3
 
 D. 4
*/
 public static String qn8 = null;
/* qn9: 
 "没人比我更懂java".toCharArray(), 在java(jdk8)中关于这个字符数组char[], 以下说法正确的是:B
 
 A. 这个字符串在内存中总共占用 16 byte
 
 B. 这个字符串在内存中总共占用 10 byte
 
 C. 以上说法都不对
 
 D. 这个字符串在内存中总共占用 20 byte
*/
 public static String qn9 = null;
/* qn10: 
 下面代码会分别输出怎样的结果:D
 String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
 String si = "没人比我更懂java";
 System.out.println(s == si);
 System.out.println(s.intern() == "没人比我更懂java");
 System.out.println(s == si.intern());
 
 A. true true true
 
 B. false true true
 
 C. true false true
 
 D. false true false
*/
 public static String qn10 = null;
/* qn11: 
 已知一个完全二叉树的第6层有3个叶子结点，则整个二叉树的结点数最多有:A
 
 A. 34
 
 B. 122
 
 C. 45
 
 D. 121
*/
 public static String qn11 = null;
/* qn12: 
 以下代码编译时哪一行会出错？D

 1 package com.metaapp.solution;
 2 public class Solution {
 3     int p1 = 0;
 4     int p2 = 0;
 5     public Solution(int arg){
 6         p1 = arg;
 7     }
 8     public static void main(String args[]){
 9         Solution s1,s2;
10         int m,n;
11         m=1;n=2; 
12         s1 = new Solution();
13         s2 = new Solution(n);
14     }
15 }
 
 A. Line 6
 
 B. Line 2
 
 C. Line 9
 
 D. Line 12
*/
 public static String qn12 = null;
/* qn13: 
 下面这段程序当n=10的输出是(13)
1 public int calc(int n) {
2     try {
3         n+=1;
4         if(n/0 > 0) {
5             n+=1;
6         } else {
7             n-=10;
8         }
9         return n;
10     } catch(Exception e) {
11         n++;
12     }
13     n++;
14     return n++;
 
 A. 14
 
 B. 抛出异常
 
 C. 12
 
 D. 13
 
 E. 0
*/
 public static String qn13 = null;
/* qn14: 
 method()方法如下，method()如果调用下面5个不同的update()方法，哪些SQL会被回滚 (多选):C\D\E
 @Service
 public class TestService {
     @Resource
   TestService testService;
   
   public void method() {
     1. update1();
     ======================
     2. testService.update2();
     ======================
     3. testService.update3();
     ======================
     4. testService.update4();
     ======================
     5. testService.update5();
   }
   @Transactional
   public void update1() {
     //SQL_1
     throw new Exception();
   }
   @Transactional
   public void update2() {
     //SQL_2
     throw new Exception();
   }
   @Transactional
   private void update3() {
     //SQL_3
     throw new Exception();
   }
   @Transactional
   public void update4() {
     //SQL_4
     throw new Error();
   }
   @Transactional
   public void update5() {
     //SQL_5
     throw new IOException();
   }
 }
 
 A. SQL_5
 
 B. SQL_4
 
 C. SQL_2
 
 D. SQL_1
 
 E. SQL_3
*/
 public static String qn14 = null;
/* qn15: 
 下面代码会分别输出怎样的结果:C
   public static void main(String[] args) {
       Thread t = new Thread() {
           public void run() {
               cnn();
           }
       };
       t.run();
       System.out.print("FakeNews ");
   System.out.print("; ");
       t.start();
       System.out.print("FakeNews ");
   }
   static void cnn() {
       System.out.print("CNN ");
   }
 
 A. CNN FakeNews ; CNN FakeNews
 
 B. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews 和FakeNews CNN 都有可能
 
 C. CNN FakeNews ; CNN FakeNews 和FakeNews CNN 都有可能
 
 D. CNN FakeNews 和FakeNews CNN 都有可能 ; CNN FakeNews
*/
 public static String qn15 = null;

/*
* 以下是实现题
*/
/**
* <b>注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2, 否则视为不得分 </b>
*
* 现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
* @param int[][] nums
* @param int x 目标数
* @return boolean
*/
public static boolean searchMatrix(int[][] nums, int x) {
 // Todo your code goes here...
	if (nums[0][0]>x) {//起始值就大于X，
		return false;
	}
	//先查看左上到右下对角线
	int tempindex=0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i][i] == x) {
			return true;
		}
		if (nums[i][i] > x) {
			tempindex=i;
			break;
		}
	}
	//排除左上部分，不包含I行、列
	//<=[i][i]轴中寻找
	for (int j = tempindex; j < nums.length; j++) {
		for (int k = j; k >0; k--) {
			if (nums[k][j]==x) {//Y轴
				return true;
			}
			if (nums[j][k]==x) {//X轴
				return true;
			}
			if (nums[k][j]<x && nums[j][k]<x ) {//[j][j]轴上不存在
				continue;
			}
			if (nums[0][j]>x && nums[j][0]>x) {//nums[0][j]，nums[j][0]起始值就大于X，
				return false;
			}
		}
	}
	//没有
	return false;
}
/**
* 对任意一个Map<String, Object>, 其 key 为 String,
* 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
* 显然叶子节点是 value 类型为 Number 或 String的节点,
* 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
* 比如:
* {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
* 将转化为以下这些字符串
* a.b[0] = v
* a.b[1] = 2
* a.b[2].c = 0
* d[0] = 1
* d[1] = null
* d[2] = 3
*
* @param map 上述的 map
* @return 所有的字符串
*/
static int index = 0;
static String[] vals=null;
static String keytemp = "";
public static Set<String> showMap(Map<String, Object> map) {
	
 //TODO your code goes here...
	 Object value = null;
	Set<String> set = new HashSet<>();
	for (Map.Entry<String, Object> entry : map.entrySet()) {
		 value = entry.getValue();
		 keytemp = "";
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
				vals[index++]= keytemp+i+"] = "+strs[i];
			}else {
				keytemp +="["+i+"]";
				analysisValue(key,strs[i]);
			}
		}
	}
	return vals;
}
/**
* 给定一个二叉树, 检查它是否是镜像对称的
* 例如以下是镜像对称的
*      1
*     / \
*    2   2
*   / \ / \
*  3  4 4  3
*
* 下面这个则不是镜像对称的
*      1
*     / \
*    2   2
*     \   \
*      3   3
*
* TreeNode类的定义:
*
* @param TreeNode 一颗二叉树
* @return boolean 是否是对称的
*/

// 以下给出TreeNode类, 请勿修改
static class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode(int x) { val = x; }
}

static String temp="";
public static boolean isTreeSymmetric(TreeNode root) {
 //TODO your code goes here...
	
	TreeNode root1 = root;
	//求出镜像
	Mirror1(root1);
	//遍历对比
	String string = preOrderTraveral(root);
	temp = "";
	String string1 = preOrderTraveral(root1);
	return string.equals(string1);
}
public static String preOrderTraveral(TreeNode root){
    if(root == null){
        return temp;
    }
    temp +=root.val;
    preOrderTraveral(root.left);
    preOrderTraveral(root.left);
    return temp;
}
public static void Mirror1(TreeNode root) {
    if(root != null) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror1(root.left);
        Mirror1(root.right);
    }
}
}
