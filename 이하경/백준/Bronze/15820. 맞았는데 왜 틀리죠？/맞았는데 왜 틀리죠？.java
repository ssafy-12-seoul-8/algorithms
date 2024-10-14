import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sample = Integer.parseInt(st.nextToken());
		int system = Integer.parseInt(st.nextToken());

		boolean sampleAccepted = true;
		boolean systemAccepted = true;

		while (sample-- > 0) {
			st = new StringTokenizer(br.readLine());
			int submit = Integer.parseInt(st.nextToken());
			int ans = Integer.parseInt(st.nextToken());
			if (submit != ans) {
				sampleAccepted = false;
			}
		}

		while (system-- > 0) {
			st = new StringTokenizer(br.readLine());
			int submit = Integer.parseInt(st.nextToken());
			int ans = Integer.parseInt(st.nextToken());
			if (submit != ans) {
				systemAccepted = false;
			}
		}

		if (sampleAccepted && systemAccepted) {
			System.out.println("Accepted");
			return;
		}

		if (!sampleAccepted) {
			System.out.println("Wrong Answer");
			return;
		}

		if (sampleAccepted && !systemAccepted) {
			System.out.println("Why Wrong!!!");
		}
	}
}
