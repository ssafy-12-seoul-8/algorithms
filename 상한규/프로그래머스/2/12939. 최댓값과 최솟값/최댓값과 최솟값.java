import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] stringArray = s.split(" ");
        int[] array = new int[stringArray.length];
        
        for(int i = 0; i < stringArray.length; i++){
            array[i] = Integer.parseInt(stringArray[i]);
        }
        Arrays.sort(array);
        
        answer.append(array[0]).append(" ").append(array[array.length - 1]);
        
        return answer.toString();
    }
}