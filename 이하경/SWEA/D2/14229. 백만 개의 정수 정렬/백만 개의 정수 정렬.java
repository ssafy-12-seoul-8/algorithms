import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr, tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = 1_000_000;
		arr = new int[len];
		tmp = new int[len];

		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, len - 1);
		System.out.println(arr[500_000]);
	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 분할
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	// 병합하며 정렬
	static void merge(int left, int mid, int right) {
		// 좌, 우 배열의 시작점
		int l = left;
		int r = mid + 1;
		int idx = left; // tmp 배열에 넣을 위치
		
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				tmp[idx++] = arr[l++];
			} else {
				tmp[idx++] = arr[r++];
			}
		}

		while (l <= mid) {
			tmp[idx++] = arr[l++];
		}

		while (r <= right) {
			tmp[idx++] = arr[r++];
		}

		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}
