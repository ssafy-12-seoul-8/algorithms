import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] field = new char[n + 2][m + 2];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (char[] line : field) {
            Arrays.fill(line, 'e');
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                field[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for (String request : requests) {
            int type = request.length();
            char key = request.charAt(0);
            
            if (type == 1) {
                Queue<int[]> queue = new LinkedList<>();
                boolean[][] visited = new boolean[n + 2][m + 2];
                visited[0][0] = true;
                queue.add(new int[] {0, 0});
                
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    
                    for (int d = 0; d < 4; d++) {
                        int nx = curr[0] + dx[d];
                        int ny = curr[1] + dy[d];
                        
                        if (nx >= 0 && nx <= n + 1 && ny >=0 && ny <= m + 1 && !visited[nx][ny]) {
                            if (field[nx][ny] == 'e') {
                                queue.add(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                            
                            if (field[nx][ny] == key) {
                                field[nx][ny] = 'e';
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (field[i][j] == key) {
                            field[i][j] = 'e';
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (field[i][j] != 'e') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}