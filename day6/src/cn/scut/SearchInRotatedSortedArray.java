package cn.scut;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){ // 从low到mid这一段是有序的
                if(nums[mid] > target && nums[low] <= target){// target在 low 到 mid之间
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else { // mid 到 high 这一段是有序的
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }


        return -1;
    }


    public static void main(String[] args) {
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3, 1};

        System.out.println(search(nums, 1));
    }
}
