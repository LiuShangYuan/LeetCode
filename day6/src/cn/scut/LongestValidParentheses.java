package cn.scut;

import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1) 遇到左括号, 压栈(index)
 * 2) 遇到右括号, 如果栈不空, 从栈中pop
 *      1) pop之后, 如果栈变空, {eg:()(()) }  i - start + 1
 *      2) pop之后, 栈不空 {eg: (()}, 这一部分的长度为  i - stack.peek()
 *
 * 3) 遇到右括号, 栈为空 eg: ())(), 重新设置start的指向 start = i + 1
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class LongestValidParentheses {


    // 栈
    public static int longestValidParentheses_v1(String s) {

        Stack<Integer> stack = new Stack<>(); // 只保存左括号


        int start = 0;

        int maxlen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }

            if (s.charAt(i) == ')') { // 遇到右括号
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) { //栈里面的左括号用完了
                        maxlen = Math.max(maxlen, i-start+1);
                    }else{
                        maxlen = Math.max(maxlen, i - stack.peek());
                    }
                } else { //遇到右括号的时候栈为空
                    start = i + 1;
                }
            }
        }


        return maxlen;
    }



    // 动态规划
    // 从后向前扩展
    // dp[i]表示从i位置开始的子串, 最大合法长度
    // dp[s.lenght() - 1] = 0
    // 因为从后向前, 需要在知道dp[i+1]的时候推导出dp[i]的值
    // 如果s[i] == '(', 因为s[i] ---> s[ i+dp[i] ]的部分是合法的
    // 因此如果s[ i+dp[i]+1 ] == ')', s[i] = dp[i+1] + 2 [同时还有考虑从该位开始往后的串], 否则位0

    public static int longestValidParentheses_v2(String s) {
        int[] dp = new int[s.length()];

        int maxlen = 0;
        for(int i = s.length()-2; i >=0; i--){
            if(s.charAt(i)=='('){
                int end = i + dp[i+1] + 1;
                if(end < s.length() && s.charAt(end)==')'){
                    dp[i] = dp[i+1] + 2;
                    if(end + 1 < s.length()){
                        dp[i] += dp[end + 1];
                    }
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }





        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses_v1(")()())"));
        System.out.println(longestValidParentheses_v2("(()(((()"));
    }
}
