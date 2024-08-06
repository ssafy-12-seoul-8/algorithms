import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxR = 0;
        int maxC = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int[] cardSize = sizes[i];
            maxR = Math.max(maxR, Math.max(cardSize[0], cardSize[1]));
            maxC = Math.max(maxC, Math.min(cardSize[0], cardSize[1]));
        }
        
        answer = maxR * maxC;
        return answer;
    }
}