package com.gessica.arithmetic.qksort20_09;
/**
 * https://blog.csdn.net/shujuelin/article/details/82423852
 * @author wanji
 *
 */
public class QkSort21 {

    public static void quickSort(int[] arr,int low,int high){

        int i,j,temp,t;

        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        //最后将基准为与i和j相等位置的数字交换
         arr[low] = arr[i];
         arr[i] = temp;
         
        //递归调用左半数组
        quickSort(arr, low, j-1);

        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

 

 

    public static void main(String[] args){

        int[] arr = {1,3,5,2,2};
//        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};

        qkSort(arr, 0, arr.length-1);//arr.length-1重点

        
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]+" ");

        }
        System.out.println("");
        int findKth = findKth(arr, arr.length-1,3);
        System.out.println("findKth:"+findKth);
        
    }
    /**
     * 获取第K大值
     * 快排后，倒叙遍历，前后数字不重复k--，如出现重复k不变
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        // write code here
    	qkSort(a,0,n-1);
        int index = K;
        for(int i=n-1;i>=0;i--){
            if(i != n-1){
                --index;
                if(a[i]==a[i+1]){
                    ++index;
                }
            }
            if(index==1){
                return a[i+1];
            }
        }
        return index;
    }
    /**
     * 快排
     * @param a
     * @param low
     * @param len
     */
    public static void qkSort(int[] a, int low, int len){
    	if(low>len)return;
        int i=low;//左侧指针
        int j=len;//右侧指针
        int root = a[low];
        int temp;
        while(i<j){
        	while(i<j && a[j]>=root)j--;//=重点，先右
            while(i<j && a[i]<=root)i++;
         if(i<j){
             temp = a[i];
             a[i]=a[j];
             a[j]=temp;
         } 
        } 
        a[low] = a[i];
        a[i] = root;
        qkSort(a,low,j-1);//先左
        qkSort(a,j+1,len);
        
    }
}
