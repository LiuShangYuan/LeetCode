package cn.scut;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange_v1(int[] nums, int target) {

        int[] defaultIdx = {-1, -1};

        int low = 0;
        int high = nums.length-1;

        int outIdx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                outIdx = mid;
                break;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        for (int i = outIdx; i >= 0; i--) {
            if (nums[i] == target) {
                defaultIdx[0] = i;
            }
        }

        for (int i = outIdx; i <= nums.length - 1 && i >= 0; i++) {
            if (nums[i] == target) {
                defaultIdx[1] = i;
            }
        }


        return defaultIdx;
    }


    public static int FindFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        int retIdx = -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] >= target){ // 找第一个, 不停的向左滑动, 等于的时候也想左滑
                high = mid - 1;
            }else {
                low = mid + 1;
            }

            if(nums[mid] == target){
                retIdx = mid;
            }
        }

        return retIdx;
    }

    public static int FindLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        int retIdx = -1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] <= target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }

            if(nums[mid] == target){
                retIdx = mid;
            }
        }

        return retIdx;
    }


    public static int[] searchRange_v2(int[] nums, int target) {



        int[] defaultIdx = {-1, -1};

        defaultIdx[0] = FindFirst(nums, target);
        defaultIdx[1] = FindLast(nums, target);


        return defaultIdx;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
//        int[] nums = {};

        System.out.println(Arrays.toString(searchRange_v2(nums, 8)));

    }
}
