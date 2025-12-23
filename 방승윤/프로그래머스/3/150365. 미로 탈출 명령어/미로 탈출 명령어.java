import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        // dlru 하 좌 우 상
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        Character[] directions = {'d', 'l', 'r', 'u'};
        int dist = Math.abs(r - x) + Math.abs(c - y);
        
        if (dist > k || (k - dist) % 2 == 1) {
            return "impossible";
        }
        
        int[] curr = {x, y};
        int cnt = 0;
        
        while (cnt != k) {
            cnt++;
            
            for (int d = 0; d < 4; d++) {
                int nx = curr[0] + dx[d];
                int ny = curr[1] + dy[d];
                dist = Math.abs(r - nx) + Math.abs(c - ny);
                
                if (dist <= k - cnt && 1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                    curr[0] = nx;
                    curr[1] = ny;
                    answer += directions[d];
                    break;
                }
            }
        }
        
        
        return answer;
    }
}