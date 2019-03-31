package cn.scut;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        int[] slens = new int[strs.length];

        for(int i=0;i<strs.length;i++){
            slens[i] = strs[i].length();
        }

        Arrays.sort(slens);

        int minlen = slens[0]; //最小的长度
        int i = 0;

        for(;i<minlen;i++){
            Set<Character> characterSet = new HashSet<>();
            for(String s: strs){
                characterSet.add(s.charAt(i));
            }
            if(characterSet.size()==1){
                continue;
            }else{
                break;
            }
        }

        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"a"};

        String result = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(result);
    }
}
