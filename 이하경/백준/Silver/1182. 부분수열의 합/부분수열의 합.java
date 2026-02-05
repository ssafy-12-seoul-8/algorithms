import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, s, cnt;
	static int[] seq, partSum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		s = Integer.parseInt(input[1]);
		cnt = 0;
		seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		partSum = new int[(int) Math.pow(2, n)];
		
		// 숫자마다 더한 값을 모두 저장
		for (int i = 0; i < n; i++) {
			// 0~2^i-1 까지에 현재 값을 더해서 2^i~2^2i-1	까지에 넣기
			// 기존 index에 2^i를 더한 위치에 저장
			for (int j = 0; j < Math.pow(2, i); j++) {
				partSum[(int) Math.pow(2, i) + j] = partSum[j] + seq[i];
			}
		}
		
		// 0번째는 아무것도 안 더한것이므로 1부터
		for (int i = 1; i < partSum.length; i++) {
			if (partSum[i] == s) {
				cnt ++;
			}
		}

		
		System.out.println(cnt);
	}
}