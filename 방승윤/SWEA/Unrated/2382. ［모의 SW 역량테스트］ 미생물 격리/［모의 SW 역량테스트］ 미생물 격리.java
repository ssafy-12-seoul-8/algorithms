import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};    
    
    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] microbe = new int [K][4];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                microbe[i][0] = Integer.parseInt(st.nextToken());
                microbe[i][1] = Integer.parseInt(st.nextToken());
                microbe[i][2] = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                
                if (d == 1) {
                    microbe[i][3] = 0;
                } else if (d == 2) {
                    microbe[i][3] = 2;
                } else if (d == 3) {
                    microbe[i][3] = 1;
                } else if (d == 4) {
                    microbe[i][3] = 3;
                }
            }
            
            for (int i = 0; i < M; i++) {
                int[][][] temp = new int[N][N][2];
                
                for (int j = 0; j < K; j++) {
                	if (microbe[j][2] == 0) {
                		continue;
                	}
                	
                	int nr = microbe[j][0] + dr[microbe[j][3]];
                	int nc = microbe[j][1] + dc[microbe[j][3]];
                	
                	if (temp[nr][nc][1] == 0) {
                		temp[nr][nc][0] = j;
                		temp[nr][nc][1] = microbe[j][2];
                		microbe[j][0] = nr;
                    	microbe[j][1] = nc;
                	} else {
                		microbe[temp[nr][nc][0]][2] += microbe[j][2];
                		
                		if (temp[nr][nc][1] < microbe[j][2]) {
                			temp[nr][nc][1] = microbe[j][2];
                			microbe[temp[nr][nc][0]][3] = microbe[j][3];
                		}
                		
                		microbe[j][2] = 0;
                		
                	}
                }
                
                for (int j = 0; j < K; j++) {                	
                	if (microbe[j][0] == 0 || microbe[j][0] == N - 1 || microbe[j][1] == 0 || microbe[j][1] == N - 1) {
                		microbe[j][3] = (microbe[j][3] + 2) % 4;
                		microbe[j][2] /= 2;
                	}
                }
            }
            
            int num = 0;
            
            for (int i = 0; i < K; i++) {
            	num += microbe[i][2];
            }
            
            sb.append("#").append(tc).append(" ").append(num).append("\n");
            
        }
        
        System.out.println(sb);
        
    }
    
}