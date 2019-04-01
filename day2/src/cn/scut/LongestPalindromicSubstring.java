package cn.scut;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestPalindromicSubstring {

    /**
     * 暴力解法, 穷举所有子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxlens = -1;
        String maxlens_str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() + 1; j++) {
                if (isPalindromicSubstring(s.substring(i, j))) {
                    if(j-1-i > maxlens) {
                        maxlens = j - 1 - i;
                        maxlens_str = s.substring(i, j);
                    }
                }
            }
        }

        return maxlens_str;
    }

    public boolean isPalindromicSubstring(String s) {
        int slen = s.length();
        int end_idx = slen / 2; //判断结束的位置(不包含该位置)
        for (int i = 0; i < end_idx; i++) {
            if (s.charAt(i) == s.charAt(slen - 1 - i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    //其他方法
    //1)中心扩散O(n^2)
    //2)马拉车算法

    public static void main(String[] args) {
        String result = new LongestPalindromicSubstring().longestPalindrome("");
        System.out.println(result);
    }
}
