package cn.scut;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofAPhoneNumber {


    /**
     * 思路:
     *   eg:23 (2:abc, 3:def)
     * 1)动态规划
     * 2)每次在前面字符串的基础上加上当前字符 ①:"" + [a, b, c] ②: (a, b, c) + [d, e, f]
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> digit2Letters = new HashMap<>();
        digit2Letters.put('2', "abc");
        digit2Letters.put('3', "def");
        digit2Letters.put('4', "ghi");
        digit2Letters.put('5', "jkl");
        digit2Letters.put('6', "mno");
        digit2Letters.put('7', "pqrs");
        digit2Letters.put('8', "tuv");
        digit2Letters.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        //"" 字符串直接返回空列表
        if("".equals(digits)){
            return result;
        }
        result.add("");// 同一对第一次和后面的处理方式
        for (int i = 0; i < digits.length(); i++) {
            char d = digits.charAt(i);
            String letters = digit2Letters.get(d);

            List<String> tmp = new ArrayList<>();
            for (int k = 0; k < result.size(); k++) {
                String base = result.get(k);
                for (int j = 0; j < letters.length(); j++) {
                    tmp.add(base + letters.charAt(j));
                }
            }
            result = tmp;
        }

        return result;
    }


    public static void main(String[] args) {
        List<String> result = new LetterCombinationsofAPhoneNumber().letterCombinations("23");

        System.out.println(result);

    }
}
