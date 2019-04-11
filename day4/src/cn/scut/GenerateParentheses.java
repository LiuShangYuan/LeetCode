package cn.scut;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n, n, "", list);
        return list;
    }


    // letf和right分别表示生于左括号和右括号的数目
    public void generate(int left, int right, String s, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(s);
        }else if(left > right){
            return;
        }else{
            if(left > 0)
                generate(left-1, right, s+"(", list);
            if(right>0)
                generate(left,  right-1, s+")", list);
        }
    }


    public static void main(String[] args) {

        List<String> list = new GenerateParentheses().generateParenthesis(3);
        for(String str : list){
            System.out.println(str);
        }
    }
}
