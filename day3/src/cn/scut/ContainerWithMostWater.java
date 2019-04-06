package cn.scut;

public class ContainerWithMostWater {


    //第一种解法(暴力)
    //只考虑如果下一个其实位置比当前最高起始位置还低的话就跳过
    public int maxArea_v1(int[] height) {

        int curr_start_max = 0;

        int maxwater = 0;

        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > curr_start_max) {
                curr_start_max = height[i];
            } else {
                continue;
            }

            for (int j = i + 1; j < height.length; j++) {
                int tmp = Math.min(height[j], height[i]) * (j - i);
                if(tmp > maxwater){
                    maxwater = tmp;
                }
            }
        }


        return maxwater;
    }


    // 第二种解法
    // 判断front和back两边那一边时短板，修改短板的指针
    public int maxArea_v2(int[] height) {
        int front = 0;
        int back = height.length - 1;

        int ret = 0;

        while (front < back){
            ret = Math.max(ret, (back - front) * Math.min(height[front], height[back]));

            if(height[front] < height[back]){
                front ++;
            }else if(height[front] == height[back]){
                front ++;
                back --;
            }else{
                back --;
            }

        }

        return ret;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int result = new ContainerWithMostWater().maxArea_v1(height);
        int result = new ContainerWithMostWater().maxArea_v1(height);
        System.out.println(result);
    }
}
