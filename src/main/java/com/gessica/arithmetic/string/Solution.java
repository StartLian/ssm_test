package com.gessica.arithmetic.string;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String addsum = addsum("12345612340000","1234");
		String longestPalindrome = longestPalindrome("ababa");
		System.out.println("longestPalindrome："+longestPalindrome);
	}
	public static String addsum(String s,String t) {
		char[] charArray1 = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		int len1 = charArray1.length-1;
		int len2 = charArray2.length-1;
		StringBuffer buffer = new StringBuffer();
		int next = 0;
		while (len1>=0 || len2>=0) {
			int temp = next;
			if (len1>=0) {
				temp += charArray1[len1--]-'0';
			}
			if (len2>=0) {
				temp += charArray2[len2--]-'0';
			}
			int a = temp%10;
			next = temp/10;
			buffer.append(a);
		}
		System.out.println(new String(buffer));
		StringBuffer reverse = buffer.reverse();
		return new String(reverse);
	}
	/**
	 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
	 * 最长回文字符串
	 * @2021年1月19日上午9:46:15
	 * @param @param s
	 * @param @return 参数
	 * @return String 返回类型
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
	 }
	//自测
	public static String test(String s) {
		int len = s.length();
		String ans = "";
		boolean[][] dp = new boolean[len][len];
		for(int l= 0;l<len;++l) {
			for(int i = 0;i+l<len;++i) {
				int j= i+l;
				if(l ==0) {
					dp[i][j]= true;
				}else if(l==1) {
					dp[i][j] = (s.charAt(i)==s.charAt(j));
				}else {
					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
				}
				if (dp[i][j] && l+1 >ans.length()) {
					ans =s.substring(i,i+l+1);
				}
			}
		}
		return ans;
	}
}
