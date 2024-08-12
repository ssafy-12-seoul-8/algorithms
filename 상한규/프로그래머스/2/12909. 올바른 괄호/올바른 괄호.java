import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '('){
                stack.push('(');
            } else{
                if(stack.size() != 0 && stack.peek() == '('){
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if(stack.size() != 0){
            answer = false;
        }

        return answer;
    }
}