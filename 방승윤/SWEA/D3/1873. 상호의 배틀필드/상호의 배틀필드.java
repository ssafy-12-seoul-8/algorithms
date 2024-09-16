import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int r, c, d, H, W;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static String[][] field;
    
    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= T; tc++) {
            
        	st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	field = new String[H][W];
        	
        	for (int i = 0; i < H; i++) {
        		String str = br.readLine();
        		field[i] = str.split("");
        		
        		if (str.contains("^")) {
        			r = i;
        			c = str.indexOf("^");
        			d = 0;
        		} else if (str.contains("v")) {
        			r = i;
        			c = str.indexOf("v");
        			d = 1;
        		} else if (str.contains("<")) {
        			r = i;
        			c = str.indexOf("<");
        			d = 2;
        		} else if (str.contains(">")) {
        			r = i;
        			c = str.indexOf(">");
        			d = 3;
        		}
        	}
        	
        	int N = Integer.parseInt(br.readLine());
        	String act = br.readLine();
        	
        	
        	for (int i = 0; i < N; i++) {
        		if (act.charAt(i) == 'S') {
        			shoot();
        		} else {
        			move(act.charAt(i));
        		}
        	}
        	
            sb.append("#").append(tc).append(" ");
            
            for (int i = 0; i < H; i++) {
            	for (String answer : field[i]) {
            		sb.append(answer);
            	}
            	
            	sb.append("\n");
            }
            
        }
        
        System.out.println(sb);
        
    }
    
    static void shoot() {
    	
    	int nr = r + dr[d];
    	int nc = c + dc[d];
    	
    	while (nr >= 0 && nr < H && nc >= 0 && nc < W && !field[nr][nc].equals("#")) {
    		if (field[nr][nc].equals("*")) {
    			field[nr][nc] = ".";
    			break;
    		}
    		
    		nr += dr[d];
    		nc += dc[d];
    	}
    	
    }
    
    static void move(char direction) {
    	
    	if (direction == 'U') {
    		d = 0;
    		field[r][c] = "^";
    	} else if (direction == 'D') {
    		d = 1;
    		field[r][c] = "v";
    	} else if (direction == 'L') {
    		d = 2;
    		field[r][c] = "<";
    	} else if (direction == 'R') {
    		d = 3;
    		field[r][c] = ">";
    	}
    	
    	int nr = r + dr[d];
    	int nc = c + dc[d];
    	
    	if (nr >= 0 && nr < H && nc >= 0 && nc < W && field[nr][nc].equals(".")) {
    		field[nr][nc] = field[r][c];
    		field[r][c] = ".";
    		r = nr;
    		c = nc;
    	}
    	
    }
    
}