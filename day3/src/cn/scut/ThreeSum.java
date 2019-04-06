package cn.scut;

import java.util.*;

public class ThreeSum {


    // 要返回所有


    /**
     * 思路:
     * 先对数组进行排序, 然后fix住一个数, 用0减去该数得到一个target,
     * 用前后两个指针在排序后的数组上滑动找到满足条件的组合
     * 为了避免重复, 要采取两个措施
     * 1) 记录fixed过得数据, 后面直接跳过, 由于数据已经排序直接和前一个数据比较就好
     * 2) 让保存的三元组顺序为 fixed, front, back, 所以front每轮开始时=fixed+1
     * 3)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();

        if (nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);

        int target;

        for (int i = 0; i < nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]){ //利用有序的性质
                continue;
            }

            target = -nums[i];
            int front = i+1; // 不能从头, 从头必定会发生重复
            int back = nums.length - 1;

            while (front < back) {
                int front_plus_back = nums[front] + nums[back];
                if(front_plus_back == target){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[front]);
                    tmp.add(nums[back]);
                    ret.add(tmp);
                    while (front < back && nums[front] == nums[front + 1]) ++front;
                    while (front < front && nums[back] == nums[back - 1]) --back;
                    ++front;
                    --back;
                }else{
                    if(front_plus_back > target){
                        back--;
                    }else{
                        front++;
                    }
                }
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSum().threeSum(nums);

        for(List<Integer> list : result){
            for(int i: list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
