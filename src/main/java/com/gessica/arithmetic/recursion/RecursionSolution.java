package com.gessica.arithmetic.recursion;

public class RecursionSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jumpFloor = Fibonacci(6);
		System.out.println(jumpFloor);
	}

	/**
	 * 跳台阶-递归
	 * @param target
	 * @return
	 */
	public static int JumpFloor(int target) {

        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        return JumpFloor(target-2)+JumpFloor(target-1);
    }
	/**
	 * 方案二
	 * @param n
	 * @return
	 */
	public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 1, b = 1;
        for (int i = 1; i <= n - 2; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
