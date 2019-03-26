package leetcode;

import java.util.Stack;

public class solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return  false;
                }
                char top = stack.pop();
                System.out.println(top);
                if(c==')'&&top!='('){
                    return  false;
                }
                if(c==']'&&top!='['){
                   return false;
                }
                if(c=='}'&&top!='{'){
                   return  false;
                }
            }

        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        solution s = new solution();
        System.out.println(s.isValid("(])"));
    }


}
