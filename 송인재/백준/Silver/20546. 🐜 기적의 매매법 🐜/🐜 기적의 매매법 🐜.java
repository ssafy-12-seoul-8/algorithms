import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cash = Integer.parseInt(br.readLine());
		int[] cashes = new int[] { cash, cash };
		int[] prices = new int[14];
		int[] stocks = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < prices.length; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}

		int upStreak = 0;
		int downStreak = 0;

		for (int i = 0; i < prices.length; i++) {
			int price = prices[i];
			int bnp = cashes[0] / price;
			stocks[0] += bnp;
			cashes[0] -= price * bnp;

			if (i != 0) {
				if (prices[i] > prices[i - 1]) {
					upStreak++;
					downStreak = 0;
				}

				if (prices[i] < prices[i - 1]) {
					downStreak++;
					upStreak = 0;
				}
			}

			if (downStreak == 3) {
				int timing = cashes[1] / price;
				stocks[1] += timing;
				cashes[1] -= price * timing;
				upStreak = 0;
			}

			if (upStreak == 3) {
				cashes[1] += price * stocks[1];
				stocks[1] = 0;
				downStreak = 0;
			}
		}

		int bnpFinal = cashes[0] + stocks[0] * prices[13];
		int timingFinal = cashes[1] + stocks[1] * prices[13];
		String result;

		if (bnpFinal > timingFinal) {
			result = "BNP";
		} else if (bnpFinal < timingFinal) {
			result = "TIMING";
		} else {
			result = "SAMESAME";
		}

		System.out.println(result);
	}

}
