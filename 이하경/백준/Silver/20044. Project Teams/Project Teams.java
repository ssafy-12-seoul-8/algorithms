import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] score = new int[2 * n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score);

		int min = 200_000;


		for (int i = 0; i < n; i++) {
			min = Math.min(min, score[i] + score[2 * n - 1 - i]);
		}

		System.out.println(min);

	}

}