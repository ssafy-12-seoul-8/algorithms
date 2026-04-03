import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String road = br.readLine();
		Long cnt = 0L;
		int[] roadCnt = new int[4];
		int[] hashCnt = new int[81];
		hashCnt[0] = 1;

		for (int i = 0; i < N; i++) {
			char status = road.charAt(i);

			switch (status) {
				case 'T':
					roadCnt[0] = (roadCnt[0] + 1) % 3;
					break;
				case 'G':
					roadCnt[1] = (roadCnt[1] + 1) % 3;
					break;
				case 'F':
					roadCnt[2] = (roadCnt[2] + 1) % 3;
					break;
				case 'P':
					roadCnt[3] = (roadCnt[3] + 1) % 3;
					break;
			}

			int hash = roadCnt[0] * 27 + roadCnt[1] * 9 + roadCnt[2] * 3 + roadCnt[3];
			cnt += hashCnt[hash]++;
		}

		System.out.println(cnt);
	}
}