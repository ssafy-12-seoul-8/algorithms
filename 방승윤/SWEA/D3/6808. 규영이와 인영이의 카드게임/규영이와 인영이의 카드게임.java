import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int card, cnt;
	static int total = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
    
    public static void main(String[] args) throws Exception {
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuffer sb = new StringBuffer();
    	
    	int T = Integer.parseInt(st.nextToken());
    	
    	for (int tc = 1; tc <= T; tc++) {
    		
    		st = new StringTokenizer(br.readLine());
    		
    		for (int i = 0; i < 9; i++) {
    			card += (1 << Integer.parseInt(st.nextToken()) - 1);
    		}
    		
    		game(-1, 0, 0, 0);
    				
    		sb.append("#").append(tc).append(" ").append(cnt).append(" ").append(total - cnt).append("\n");
    		
    		card = 0; 
    		cnt = 0;
    		
    	}
    	
    	System.out.println(sb);
    	
	}
    
    static void game(int idx, int sidx, int lose, int card2) {
    	
    	int check = 0;
    	int card1 = 0;
    	
    	if (idx != -1) {
    		for (int i = 0; i < 18; i++) {
        		if ((card & (1 << i)) > 0) {
        			if (check == idx) {
        				card1 = i + 1;
        				break;
        			}
        			check++;
        		}
        	}
    	}
    	
    	check = 0;
    	
    	if (card2 > card1) {
    		lose += card1 + card2;
    	}
    	
    	if (lose > 85) {
    		return;
    	}
    	
    	if (idx == 8) {
			cnt++;
    		return;
    	}
    	
    	for (int i = 0; i < 18; i++) {
    		if ((card & (1 << i)) > 0 || (sidx & (1 << i)) > 0) {
    			continue;
    		}
			game(idx + 1, sidx + (1 << i), lose, i + 1);
    	}
    
    }
    
}