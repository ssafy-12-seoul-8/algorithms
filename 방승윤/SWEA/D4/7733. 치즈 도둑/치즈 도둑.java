import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N;
    static int[][] board;
    static boolean[][] visit;
     
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         
        for (int tc = 1; tc <= T; tc++) {
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                	board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int maxCnt = 1;
             
            for (int day = 1; day <= 100; day++) {
            	visit = new boolean[N][N];
            	
            	int cnt = 0;
            	
            	for (int r = 0; r < N; r++) {
                	for (int c = 0; c < N; c++) {
                		if (visit[r][c] || board[r][c] <= day) {
                			continue;
                		}
                		visit[r][c] = true;
                		dfs(day, r, c);
                		cnt++;
                	}
                }
            	
            	maxCnt = Math.max(maxCnt, cnt);
            	
            }
            
            sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
            
        }
         
        System.out.println(sb);
         
    }
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
     
    static void dfs(int day, int r, int c) {

    	for (int i = 0; i < 4; i++) {
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc] && board[r][c] > day) {
    			visit[nr][nc] = true;
    			dfs(day, nr, nc);
    		}
    	}
    	
    }    
}