import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
			char[] par = br.readLine().toCharArray();
			
			int cnt = 0;
			int overlap = 0;
			int i = 0;
			while (i < par.length) {
				while (par[i] == '(') {
					overlap++;
					i++;
				}
				// ( 이후 첫 번째 )는 레이저
				if (par[i] == ')') {
					overlap--;
					cnt += overlap;
					i++;
					// 두 번째 ) 부터는 막대의 끝
					while (i < par.length && par[i] == ')') {
						overlap--;
						cnt++;
						i++;
					}
				}
				
			}
		
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
        
        System.out.println(sb);
 
    }
}
