package com.gessica.arithmetic.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 最小K个数--牛客
 * @author wanji
 * @2020年12月15日上午9:10:41
 */
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> getLeastNumbers_Solution = solution.GetLeastNumbers_Solution3(nums,4);
		System.out.println(getLeastNumbers_Solution.toString());
	}  
    /**
     * 1、取数组前k个数并构造大根堆；
     * 2、遍历输入数组K后面的数，每次和大根堆的根节点（堆顶）进行比较，若小于该节点，则替换；
     * 3、重新构建大根堆；
     * 4、循环结束，大根堆中的数即为原数组中最小的k个数；
     * 注意：大根堆是完全二叉树，最大的数为根节点，存储在数组中，根节点下标为0，
     *      若某父节点下标为【x】，则其左孩子为【2*x+1】 ，右孩子为【2*x+2】
     * 5、堆排序：从小到大排序。即将下标为【0】的数据（最大值）和当前的最后一位交换，此时
     *    最大值移动到数组最后一位。然后将剩下的len-1的数组再构造大根堆，将剩下数据中的
     *    最大值置于【0】位置，重复即可。
     * */
    public ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if (input == null || input.length == 0 || k == 0 || k > input.length)
            return array;
        int[] result = new int[k];

        //将输入数组的前k个数放入结果数组，作为初始的k个数
        for (int i = 0; i < k; i++) {
            result[i] = input[i];
        }

        //将结果数据构建成大根堆
        buildMaxHeap3(result, result.length);
		for (int i = 0; i <  result.length; i++) {
			
			System.out.println("result ："+result[i]+" ");
		}
        //遍历输入数组,每个数都与大根堆的根节点比较
        for (int i = k; i < input.length; i++) {
            if (input[i] < result[0]) {
                result[0] = input[i];
                //重构大根堆
                buildMaxHeap3(result,result.length);
            }
        }

        for (int i = 0; i <  result.length; i++) {
			
			System.out.println("重构大根堆 result ："+result[i]+" ");
		}
        // 调整大根堆，即堆排序
        for(int i = result.length - 1; i >= 1; i--)
        {
            swap3(result,0, i);  // 将当前最大的数（w为0）放置到未排序数组的末尾
            buildMaxHeap3(result,i);
        }
        for (int i = 0; i <  result.length; i++) {
			
			System.out.println("重构小根堆 result ："+result[i]+" ");
		}
        //将大根堆内数据赋值给arraylist
        for (int i = 0; i < k; i++) {
            array.add(result[i]);
        }
        return array;
    }

    //构建成大根堆
    private void buildMaxHeap3(int[] a, int len) {
        for (int i = len/2-1; i>=0; i--) {
            adjust3(a, len, i);
        }
    }

    //将index节点和其左孩子、右孩子比较，通过交换将三个中最大的数值移动到index处
    private void adjust3(int[] a, int len, int index) {
        int left = index*2+1;
        int right = index*2+2;
        if (left <= len-1 && a[left] > a[index]) {
            swap3(a, left, index);
        }
        //注意这里是两个if，不能有else，因为父节点需要同时和左孩子和右孩子比较
        if (right <= len-1 && a[right] > a[index]) {
            swap3(a, right, index);
        }
    }

    private void swap3(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}
