import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		int[][] farm = new int[6][2];
		int[] distCnt = new int[5];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dist = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			farm[i] = new int[] { dist, len };
			distCnt[dist]++;
		}
		
		int longIdx = 5;
		for (int i = 0; i < 5; i++) {
			if (distCnt[farm[i][0]] == 1 && distCnt[farm[i + 1][0]] == 1) {
				longIdx = i;
				break;
			}
		}
		
		int largeRec = farm[longIdx][1] * farm[(longIdx + 1) % 6][1];
		int smallRec = farm[(longIdx + 3) % 6][1] * farm[(longIdx + 4) % 6][1];
		
		System.out.println((largeRec - smallRec) * k);
	}

}
