import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M;
	static Shark[] sharks;
	static int[][] pool;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 우 좌
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		input();
		solve();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sharks = new Shark[M + 1];
		pool = new int[R][C];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 위치
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 이동방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			sharks[i] = new Shark(r - 1, c - 1, s, d - 1, z);
			pool[r - 1][c - 1] = i;
		}
	}

	static void solve() {
		int sizeSum = 0;
		for (int i = 0; i < C; i++) { // 낚시왕의 위치
			// 상어 잡기
			sizeSum += catchShark(i);

			// 상어 이동
			for (int j = 1; j <= M; j++) {
				sharks[j].erase();
			}
			for (int j = 1; j <= M; j++) {
				sharks[j].move(j);
			}
		}

		System.out.println(sizeSum);
	}

	static int catchShark(int col) {
		for (int j = 0; j < R; j++) {
			int sharkIdx = pool[j][col];
			if (sharkIdx != 0) {
				sharks[sharkIdx].dead = true;
				sharks[sharkIdx].erase();
				return sharks[sharkIdx].size;
			}
		}
		return 0;
	}

	static class Shark {
		int r, c, speed, dir, size;
		boolean dead;

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		void erase() {
			pool[r][c] = 0;
		}

		void move(int idx) {
			if (dead) {
				return;
			}
			r += speed * dr[dir];
			c += speed * dc[dir];

			makeValid();

			if (pool[r][c] == 0) {
				pool[r][c] = idx;
				return;
			}

			Shark meet = sharks[pool[r][c]];
			if (meet.size > size) { // 원래 있던애가 더 크면
				dead = true;
				return;
			}

			meet.dead = true; // 지금이 더 크면
			pool[r][c] = idx;
		}

		void makeValid() {
			if (r < 0) {
				changeDir();
				r = -r;
			}
			if (r >= R) {
				r %= (2 * R - 2);
			}
			if (r >= R) {
				changeDir();
				r = 2 * R - 2 - r;
			}
			
			if (c < 0) {
				changeDir();
				c = -c;
			}
			if (c >= C) {
				c %= (2 * C - 2);
			}
			if (c >= C) {
				changeDir();
				c = 2 * C - 2 - c;
			}

		}

		void changeDir() {
			if (dir % 2 == 0) {
				dir++;
			} else {
				dir--;
			}
		}

		@Override
		public String toString() {
			return size + "";
		}
	}
}
