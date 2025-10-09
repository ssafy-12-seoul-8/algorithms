import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        Queue<int[]> q = new LinkedList<>();
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    numberOfArea++;
                    int size = 1;
                    int color = picture[i][j];
                    q.add(new int[]{ i, j });
                    picture[i][j] = 0;
                    
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int cx = curr[0];
                        int cy = curr[1];
                        
                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];
                            
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny] == color) {
                                picture[nx][ny] = 0;
                                q.add(new int[]{ nx, ny });
                                size++;
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}