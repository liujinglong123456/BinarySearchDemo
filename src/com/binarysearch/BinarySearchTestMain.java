package com.binarysearch;
/**
 * Author:   ljl
 * Date :    2018-02-09
 * Description:二分查找法
 * History:
 *     <author>     <time>     <version>   <desc>
 */
public class BinarySearchTestMain {

    public static void main(String[] args) {
        int array[] = new int[]{1,2,3,4,5,6,7,8,9,11,22,33};
        System.out.println("当前值在数组中的位置是" + binarySearch(array, 3));
    }

    /**
     * 二分查找法
     * @param array 被查找的数组
     * @param searchValue 被查找的值
     * @return 如果这个值存在于该数组中，则会返回下标。否则会返回-1。
     */
    private static int binarySearch(int array[],int searchValue){
        //定义初始时的查找起点
        int left = 0;
        //定义查找终点，因为数组是从第0个元素开始，所以，终点为array.length - 1。
        int right = array.length - 1;
        //在二分查找过程中，如果第一次循环就直接找到了元素所在的位置，则会直接返回位置。
        //如果第一次循环没有找到位置，接下来会首先对数组进行二分。
        //然后根据二分后的位置，然后重新定义扫描的范围，若还是没找到，则继续进行二分，直至最后找到。
        while (left <= right) {
            //首先得到中间位置
            int mid =  (left + right) / 2;
            //如果此时中间位置元素的值恰好是我们要查找的元素，则直接返回mid下标。
            if (array[mid] == searchValue) {
                return mid;
            }
            //以下是对查找范围的重新定义
            if (array[mid] > searchValue) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
