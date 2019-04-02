package cn.scut;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class ZigZagConversion {


    /**
     * 问题分析: 之字形
     * 每个循环有row + （row-2）个元素组成{由一条竖线和一条斜线构成}
     */

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

//        int[] each_line_count = new int[numRows]; // 存储每一行的元素数目

        int loop_count = s.length() / (2 * numRows - 2); // 完整的循环个数

        int left_count = s.length() % (2 * numRows - 2); // 剩下的不足一个循环的数目

//        if (loop_count == 0) {
////            each_line_count[0] = 1;
//        } else {
//            each_line_count[0] = loop_count;
//            each_line_count[each_line_count.length - 1] = loop_count;
//
//            if (numRows > 2) {
//                for (int i = 1; i <= numRows - 2; i++) {
//                    each_line_count[i] = loop_count * 2;
//                }
//            }
//        }
//
//        //对剩下不足一个循环的数据做处理
//        for (int i = 0; i < left_count; i++) {
//            if (i < numRows) {
//                each_line_count[i] += 1;
//            } else {
//                each_line_count[2 * numRows - 2 - i] += 1;
//            }
//        }
//
//
//
//        ArrayList<Integer> list = new ArrayList<>(); // 每列有多少数据
//        for (int i=0; i<loop_count;i++){
//            list.add(numRows);
//            for(int j=0;j<numRows-2;j++){
//                list.add(1);
//            }
//        }
//
//        //对最后不足一个循环的单独处理
//        if(left_count<=numRows){
//            list.add(left_count);
//        }else{
//            list.add(numRows);
//            for(int i=0;i<left_count-numRows;i++){
//                list.add(1);
//            }
//        }


        ArrayList<Character> [] zigzag_array = new ArrayList[numRows];

        for(int i=0;i<numRows;i++){
            zigzag_array[i] = new ArrayList<Character>();
        }

        int curr_idx = 0;
        for(int i=0;i<loop_count;i++){
            curr_idx = i * (2*numRows - 2);
            for(int j=0;j<2*numRows-2;j++){
                if(j<numRows){
                    zigzag_array[j].add(s.charAt(j+curr_idx));
                }else{
                    zigzag_array[2*numRows-2-j].add(s.charAt(j+curr_idx));
                }
            }
        }

        //处理最后不足一个循环的部分
        if(loop_count>0){
            curr_idx += 2*numRows-2;
        }

        for(int j=0;j<left_count;j++){
            if(j<numRows){
                zigzag_array[j].add(s.charAt(j+curr_idx));
            }else{
                zigzag_array[2*numRows-2-j].add(s.charAt(j+curr_idx));
            }
        }


        StringBuilder builder = new StringBuilder();
        for(int i=0;i<numRows;i++){

            if(zigzag_array[i].size()>0) {
                for (Character character : zigzag_array[i]) {
                    builder.append(character);
                }
            }
        }


        return builder.toString();
    }


    public static void main(String[] args) {
//        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
//        new ZigZagConversion().convert("PAYPALISHIRING", 4);

        System.out.println(new ZigZagConversion().convert("ABC", 2));
    }
}
