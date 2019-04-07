package cn.scut;

import java.util.Stack;

public class ValidParentheses {
    /**
     *
     * 用栈
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        // 所有字符压栈
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }

        // 存放右括号的栈
        Stack<Character> right = new Stack<>();

        while(!stack.isEmpty()){
            char top = stack.peek();
            if(top==')' || top==']' || top=='}'){
                right.push(top);
            }

            if(top=='(' || top=='[' || top=='{'){
                if(!right.isEmpty() && (top=='(' && right.peek()==')' || top=='[' && right.peek()==']' || top=='{' && right.peek()=='}')){
                    right.pop();
                }else {
                    return false;
                }
            }

            stack.pop();
        }

        // 最后右括号栈不为空返回false
        if(!right.isEmpty()){
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "{a * (b + c)}";
        System.out.println(isValid(s));
    }
}
