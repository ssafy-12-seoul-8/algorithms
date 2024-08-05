import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int[] xCountingArray = new int[10];
        int[] yCountingArray = new int[10];
        
        for(int i = 0; i < X.length(); i++){
            xCountingArray[X.charAt(i) - '0']++;
        }
        
        for(int i = 0; i < Y.length(); i++){
            yCountingArray[Y.charAt(i) - '0']++;
        }
        
        
        
        for(int i = xCountingArray.length - 1; i >= 0; i--){
            for(int j = 0; j < Math.min(xCountingArray[i], yCountingArray[i]); j++){
                sb.append(i);
            }
        }
        
        if(sb.length() == 0){
            return "-1";
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}