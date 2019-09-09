package cn.scut;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s="";
        String p=".*";

        System.out.println(isMatch(s, p));

    }

    public static boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] resarr = new boolean[p.length() + 1][s.length() + 1];

        resarr[0][0] = true;
        for (int j = 1; j < s.length() + 1; j++) {
            resarr[0][j] = false;
        }

        for (int i = 1; i < p.length() + 1; i++) {
            if(p.charAt(i-1)=='*' && resarr[i-2][0]){
                resarr[i][0] = true;
            }
        }

        for (int i = 1; i < p.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    // p[i] 和 s[j]是可以匹配的
                    resarr[i][j] = resarr[i - 1][j - 1];
                    continue;
                }

                if (p.charAt(i - 1) == '*') {
                    // 如果前一个字符为. 或者可以和s的当前字符相等
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
                        // 重复0次
                        resarr[i][j] = (resarr[i-2][j] || resarr[i-1][j] || resarr[i][j-1]);
                    }else{
                        resarr[i][j] = resarr[i-2][j];
                    }
                    continue;
                }
                resarr[i][j] = false;
            }
        }


        return resarr[p.length()][s.length()];
    }
}
