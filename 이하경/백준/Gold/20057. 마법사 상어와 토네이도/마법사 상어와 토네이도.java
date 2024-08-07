import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 시계방향으로 방향을 이동하면 인덱스를 증가시키고 싶어서
	// 좌 상 우 하 순으로 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[][] grid;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가운데부터 순서대로 실행
		int x = n / 2;
		int y = n / 2;
		int d = 0;
		int moveCnt = 1;
		int nextMoveCnt = 1;
		int cnt = 0;
		boolean incMoveCnt = false;
		
		while (moveCnt < n) {
			cnt += tornado(x, y, d);
			
			moveCnt--;
			x += dx[d];
			y += dy[d];
			
			if (moveCnt == 0) {
				d = (d + 3) % 4;
				if (incMoveCnt) {
					nextMoveCnt++;
				}
				incMoveCnt = !incMoveCnt;
				moveCnt = nextMoveCnt;
			}
		}
		
		for (int i = n - 1; i > 0; i--) {
			cnt += tornado(0, i, 0);
		}
		
		System.out.println(cnt);

		
	}
	
	// from은 x의 위치, dir은 방향을 델타배열의 index로 나타냄
	// 밖으로 나간 모래의 양 반환
	public static int tornado(int fromx, int fromy, int dir) {
		// 2, 1
		int x = fromx + dx[dir];
		int y = fromy + dy[dir];
		
		int sand = grid[x][y]; // 이동 전 모래의 양
		int sandLeft = sand;
		int sandOut = 0;
		grid[x][y] = 0;
		
		// 5% 위치
		int nx = x + 2 * dx[dir];
		int ny = y + 2 * dy[dir];
		int sandMove = sand * 5 / 100;
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 위쪽 10% 위치
		nx = x + dx[dir] + dx[(dir + 1) % 4];
		ny = y + dy[dir] + dy[(dir + 1) % 4];
		sandMove = sand * 10 / 100;

		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 아래쪽 10% 위치
		nx = x + dx[dir] + dx[(dir + 3) % 4];
		ny = y + dy[dir] + dy[(dir + 3) % 4];
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 위쪽 7% 위치
		nx = x + dx[(dir + 1) % 4];
		ny = y + dy[(dir + 1) % 4];
		sandMove = sand * 7 / 100;
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 아래쪽 7% 위치
		nx = x + dx[(dir + 3) % 4];
		ny = y + dy[(dir + 3) % 4];
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 위쪽 2% 위치
		nx = x + 2 * dx[(dir + 1) % 4];
		ny = y + 2 * dy[(dir + 1) % 4];
		sandMove = sand * 2 / 100;
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 아래쪽 2% 위치
		nx = x + 2 * dx[(dir + 3) % 4];
		ny = y + 2 * dy[(dir + 3) % 4];
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 위쪽 1% 위치
		nx = x - dx[dir] + dx[(dir + 1) % 4];
		ny = y - dy[dir] + dy[(dir + 1) % 4];
		sandMove = sand * 1 / 100;
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 아래쪽 1% 위치
		nx = x - dx[dir] + dx[(dir + 3) % 4];
		ny = y - dy[dir] + dy[(dir + 3) % 4];
		
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandMove;
		} else {
			sandOut += sandMove;
		}
		sandLeft -= sandMove;
		
		// 다 이동하고 나면 
		nx = x + dx[dir];
		ny = y + dy[dir];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			grid[nx][ny] += sandLeft;
		} else {
			sandOut += sandLeft;
		}
		
		return sandOut;
	}
}
