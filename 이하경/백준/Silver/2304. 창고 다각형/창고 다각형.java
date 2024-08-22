import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] box = new int[1001];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			box[l] = h;
		}

		int left = 1, right = 1000, leftMax = box[1], rightMax = box[1000];
		int ans = 0;

		while (left <= right) {
			if (leftMax > rightMax) {
				ans += rightMax;
				right--;
				rightMax = Math.max(rightMax, box[right]);
			} else {
				ans += leftMax;
				left++;
				leftMax = Math.max(leftMax, box[left]);
			}
		}

		System.out.println(ans);

	}

}
