package cn.scut;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

    /**
     * 内存使用还能优化, 不需要拼接新数组
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length==0 && nums2.length==0){
            return 0;
        }

        int point1 = 0;
        int point2 = 0;
        int size = nums1.length + nums2.length;
        int media_point = (size-1) / 2; //第一个中位数的位置
        int total_point=0;

        int[] new_nums = new int[size];

        while(point1<nums1.length && point2<nums2.length){
            if(nums1[point1] <= nums2[point2]){
                new_nums[total_point++] = nums1[point1++];
            }else{
                new_nums[total_point++] = nums2[point2++];
            }
        }



        while (point1 < nums1.length){
            new_nums[total_point++] = nums1[point1++];
        }

        while (point2 < nums2.length){
            new_nums[total_point++] = nums2[point2++];
        }

        if(size % 2 == 0){
            return (new_nums[media_point]+new_nums[media_point+1]) / 2.0;
        }else{
            return new_nums[media_point];
        }


    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2} ;
        int[] nums2 = {3, 4};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
