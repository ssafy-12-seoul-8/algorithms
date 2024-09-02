import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] temp = new int[1_000_000];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[1_000_000];
		
		for (int i = 0; i < 1_000_000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr, 0, 999_999);
		
		System.out.println(arr[500_000]);
		
	}
	
	static void mergeSort(int[] arr, int left, int right) {
		
		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;
		
		mergeSort(arr, left, mid);
		
		mergeSort(arr, mid + 1, right);
		
		merge(arr, left, mid, right);
		
	}
	
	static void merge(int[] arr, int left, int mid, int right) {
		
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		
		while (L <= mid) {
			temp[idx++] = arr[L++];
		}
		
		while (R <= right) {
			temp[idx++] = arr[R++];
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
		
	}
	
}
