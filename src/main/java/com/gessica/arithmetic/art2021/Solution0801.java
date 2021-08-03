package com.gessica.arithmetic.art2021;

import java.util.ArrayList;
import java.util.List;

public class Solution0801 {

    public static void main(String[] args) {
    	int reverse = reverse(1656324351);
        System.out.printf("reverse:"+reverse);
    }

    public static int reverse(int x) {
        int res = 0;
        int last = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            last = res;
            res = res*10 + tmp;
            //判断整数溢出
            if(last != res/10)
            {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
