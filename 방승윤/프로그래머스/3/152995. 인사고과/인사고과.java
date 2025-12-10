import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int scoreA = scores[0][0];
        int scoreB = scores[0][1];
        Arrays.sort(scores, (o1, o2) -> o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        List<int[]> candidates = new ArrayList<>();
        int maxB = -1;
        
        for (int[] score : scores) {
            if (score[1] < maxB) {
                if (score[0] == scoreA && score[1] == scoreB) {
                    return -1;
                }
                
                continue;
            }
            
            maxB = Math.max(maxB, score[1]);
            candidates.add(score);
        }
        
        Collections.sort(candidates, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        int rank = 0;
        int cnt = 1;
        int prev = Integer.MAX_VALUE;
        
        for (int[] score : candidates) {
            if (score[0] + score[1] == prev) {
                cnt++;
                continue;
            } else {
                rank += cnt;
                prev = score[0] + score[1];
                cnt = 1;
            }
            
            if (score[0] == scoreA && score[1] == scoreB) {
                break;
            }
        }
        
        return rank;
    }
}