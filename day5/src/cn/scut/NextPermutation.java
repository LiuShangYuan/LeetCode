package cn.scut;

import java.util.Arrays;

public class NextPermutation {
    // 要求: The replacement must be in-place and use only constant extra memory.

    //组合数学课上过
    //1)从后向前扫描数组，从后面改动对整体值的影响越小, 逆序部分已经最大无法改动
    //2)找到第一个不符合逆序的部分
    //3)再逆序找到第一个大于该数的数，交换两者位置
    //4)将后面的部分反转
    public static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        if(i==0){
            return;
        }
        for (; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            } else {
                break;
            }
        }

        System.out.println(i);

        // i-1

        if(i!=0) {
            int j = nums.length - 1;
            for (; j >= 0; j--) {
                if (nums[j] > nums[i - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[i - 1];
                    nums[i - 1] = tmp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        //从i -> lenght反转

        for (int k = i; k < (i + nums.length) / 2; k++) {
            int tmp = nums[k];
            nums[k] = nums[nums.length + i - 1 - k];
            nums[nums.length + i - 1 - k] = tmp;
        }

    }


    public static void main(String[] args) {
//        int[] nums = {1, 2 ,7, 4, 3, 1};
//        int[] nums = {3, 2, 1};
        int[] nums = {5, 1, 1};
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
}
