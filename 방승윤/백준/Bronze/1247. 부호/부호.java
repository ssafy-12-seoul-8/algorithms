import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[200001];
			int cntN = 0;
			int cntP = 100000;
			
			for (int j = 0; j < N; j++) {
				arr[0] = Long.parseLong(br.readLine());
				
				if (arr[0] < 0) {
					arr[++cntN] = arr[0];
				} else if (arr[0] > 0) {
					arr[++cntP] = arr[0];
				}
			}
			
			long S = 0;
			
			while ((cntN > 0 || S < 0) && (cntP > 100000 || S > 0)) {
				if (S <= 0) {
					S += arr[cntP--];
				} else {
					S += arr[cntN--];
				}
			}
			
			if (S == 0 && cntN > 0) {
				S--;
			} else if (S == 0 && cntP > 100000) {
				S++;
			}
			
			sb.append(S == 0 ? 0 : S > 0 ? "+" : "-").append("\n");
			
		}
		
		System.out.println(sb);

	}

}