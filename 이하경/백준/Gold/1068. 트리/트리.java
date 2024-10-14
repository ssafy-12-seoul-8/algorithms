
// 1. 자식노드를 모두 저장. 이때 루트 찾기
// 2. dfs로 개수 반환

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] child;
	static int root, leaf, cut;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		child = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			child[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) {
				root = i;
				continue;
			}
			child[parent].add(i);
		}

		cut = Integer.parseInt(br.readLine());

		if (root == cut) {
			System.out.println(0);
			return;
		}

		dfs(root);
		System.out.println(leaf);
	}

	public static void dfs(int i) {
		boolean haveChild = false;

		for (int c : child[i]) {

			if (c != cut) {
				haveChild = true;
				dfs(c);
			}
		}

		if (!haveChild) {
			leaf++;
		}
	}
}
