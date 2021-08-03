package com.gessica.arithmetic.art2021;

import java.util.ArrayList;
import java.util.List;

public class Solution0601 {

    public static void main(String[] args) {
        /*int[] src ={8,2,6,5,7,9,3,4,5};
        quickSort(src,0,src.length-1);
        for (int a:src) {
            System.out.printf(" "+a);
        }*/
    /*	int[] src ={1,3};
    	int[] src2 ={2};
    	double findMedianSortedArrays = findMedianSortedArrays(src,src2);
    	System.out.println("findMedianSortedArrays:"+findMedianSortedArrays);*/
    	String s = "ABC"; int numRows = 1;
//    	String s = "PAYPALISHIRING"; int numRows = 3;
    	String convert = convert2(s,numRows);
    	System.out.println("convert:"+convert);
    }

    public static void quickSort(int[] src, int low, int hight) {
        int i = low+1;
        int j = hight;
        if (j < i) {
            return;
        }
        int target = src[low];
        int temp;
        while (i < j) {
            while (src[i] < target) {//左边小于target
                i++;
            }
            while (src[j] > target) {//右边大于terget
                j--;
            }
            if (j > i) {
                temp = src[i];
                src[i] = src[j];
                src[j] = temp;
            }
        }
        src[low] = src[j];
        src[j] = target;
        quickSort(src,j+1,hight);
        quickSort(src,low,j-1);
    }

    //求两个有序数组中位数
    //思路合并两个有序数组
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                double median = getKthElement(nums1, nums2, midIndex + 1);
                return median;
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
                return median;
            }
        }

        public static int getKthElement(int[] nums1, int[] nums2, int k) {
            /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
             * 这里的 "/" 表示整除
             * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
             * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
             * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
             * 这样 pivot 本身最大也只能是第 k-1 小的元素
             * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
             * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
             * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
             */

            int length1 = nums1.length, length2 = nums2.length;
            int index1 = 0, index2 = 0;
            int kthElement = 0;

            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                
                // 正常情况
                int half = k / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                if (pivot1 <= pivot2) {
                    k -= (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                } else {
                    k -= (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                }
            }
        }
        public static int getKthElement_2(int[] nums1, int[] nums2, int k) {
        	/* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
        	 * 这里的 "/" 表示整除
        	 * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
        	 * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
        	 * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
        	 * 这样 pivot 本身最大也只能是第 k-1 小的元素
        	 * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
        	 * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
        	 * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
        	 */
        	int len1 = nums1.length;
        	int len2 = nums2.length;
        	int index1 = 0;
        	int index2 = 0;
        	while(true) {
        		if(index1 == len1) {
        			return nums2[index2+k-1];
        		}
        		if(index2 == len2) {
        			return nums1[index1+k-1];
        		}
        		if(k ==1 ) {
        			Math.min(nums1[index1], nums2[index2]);
        		}
        		int half = k/2;
        		int newindex1 = Math.min(half+index1, len1)-1;
        		int newindex2 = Math.min(half+index2, len2)-1;
        		int pot1 = nums1[newindex1];
        		int pot2 = nums1[newindex2];
        		if (pot1>pot2) {
					k = k-(newindex2-index2+1);
					index2 = newindex2+1;
				}else {
					k = k-(newindex1-index1+1);
					index1 = newindex1+1;
				}
        		
        	}
        }

        /**
         * 倒N打印
         * @2021年7月19日下午8:10:30
         * @param @param s
         * @param @param numRows
         * @param @return 参数
         * @return String 返回类型
         * @param s
         * @param numRows
         * @return
         */
        public static String convert2(String s, int numRows) {
        	char[] cs = s.toCharArray();
        	if(cs.length < 3) {
        		return s;
        	}
        	if(numRows < 2) return s;
        	List<StringBuilder> rows = new ArrayList<>();
        	for (int i =0;i<numRows;i++) {
        		rows.add(new StringBuilder());
			}
        	int i = 0,flag = -1;
        	for (char c : cs) {
        		rows.get(i).append(c);
        		if(i==0 || i == numRows-1) {
        			flag = -flag;
        		}
        		i+=flag;
				
			}
        	StringBuffer sb = new StringBuffer();
        	for (StringBuilder stringBuilder : rows) {
        		sb.append(stringBuilder);
			}
        	return sb.toString();
        }
       

}
