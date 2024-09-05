import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
 
    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 1; tc <= T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            
            int[] fee = new int[4];
            int[] month = new int[12];
            int[] minFee = new int[12];
            
            for (int i = 0; i < 4; i++) {
                fee[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0; i < 12; i++) {
                minFee[i] = Math.min(month[i] * fee[0], fee[1]);
            }
            
            int minTotal = 0;
            
            for (int i = 0; i < 12; i++) {
            	minTotal += minFee[i];
            }
            
            for (int i = 0; i < 10; i++) {
                if (month[i] == 0 && month[i + 1] == 0 && month[i + 2] == 0) {
                	continue;
                }
                int temp = fee[2];
                for (int j = 0; j < 12; j++) {
                	if (j == i || j == i + 1 || j == i + 2) {
                		continue;
                	}
                	temp += minFee[j];
                }
                minTotal = Math.min(minTotal, temp);
            }
            
            for (int i = 0; i < 7; i++) {
            	if (month[i] == 0 && month[i + 1] == 0 && month[i + 2] == 0) {
            		continue;
            	}
            	for (int j = i + 3; j < 10; j++) {
            		if (month[j] == 0 && month[j + 1] == 0 && month[j + 2] == 0) {
                		continue;
                	}
            		int temp = fee[2] * 2;
                    for (int k = 0; k < 12; k++) {
                    	if (k == i || k == i + 1 || k == i + 2 || k == j || k == j + 1 || k == j + 2) {
                    		continue;
                    	}
                    	temp += minFee[k];
                    }
                    minTotal = Math.min(minTotal, temp);
            	}
            }
            
            for (int i = 0; i < 4; i++) {
            	if (month[i] == 0 && month[i + 1] == 0 && month[i + 2] == 0) {
            		continue;
            	}
            	for (int j = i + 3; j < 7; j++) {
            		if (month[j] == 0 && month[j + 1] == 0 && month[j + 2] == 0) {
                		continue;
                	}
            		for (int k = j + 3; k < 10; k++) {
                		if (month[k] == 0 && month[k + 1] == 0 && month[k + 2] == 0) {
                    		continue;
                    	}
                		int temp = fee[2] * 3;
                        for (int l = 0; l < 12; l++) {
                        	if (l == i || l == i + 1 || l == i + 2 || l == j || l == j + 1 || l == j + 2 || l == k || l == k + 1 || l == k + 2) {
                        		continue;
                        	}
                        	temp += minFee[l];
                        }
                        minTotal = Math.min(minTotal, temp);
                	}
            	}
            }
            
            minTotal = Math.min(minTotal, fee[2] * 4);
            
            minTotal = Math.min(minTotal, fee[3]);
            
            sb.append("#").append(tc).append(" ").append(minTotal).append("\n");
            
        }
        
        System.out.println(sb);
        
    }

}