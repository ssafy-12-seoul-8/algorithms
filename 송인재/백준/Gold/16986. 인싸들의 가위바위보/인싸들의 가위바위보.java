import java.io.*;
import java.util.*;

public class Main {
	
	static final Set<Integer> submitted = new HashSet<>();
	static final Map<Integer, int[]> players = new HashMap<>();

	static int[][] winMap;
	static int n;
	static int k;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		winMap = new int[n][n];
		boolean[] visited = new boolean[n + 1];
		
		initWinMap(br, n);
		initPlayers(br);
		permutate(visited, 0);
		System.out.println(result);
	}
	
	static void permutate(boolean[] visited, int current) {
		if (result == 1) {
			return;
		}
		
		if (current == n) {
			result = play();
			
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			players.get(0)[current] = i;
			
			permutate(visited, current + 1);
			
			visited[i] = false;
		}
	}
	
	static int play() {
		boolean[] out = new boolean[3];
		int[] win = new int[3];
		out[2] = true;
		int jw = 0;
		int kh = 0;
		int mh = 0;
		
		while (jw < n && win[0] != k && win[1] != k && win[2] != k) {
			int[] players = getPlayers(out);
			int firstHand = getHand(jw, players[0], kh, mh);
			int secondHand = getHand(jw, players[1], kh, mh);
			int winner = players[1];
			int loser = players[0];
			int currentOut = players[2];
			
			if (isWinning(firstHand, secondHand)) {
				winner = players[0];
				loser = players[1];
			}
			
			win[winner]++;
			out[loser] = true;
			out[currentOut] = false;
			jw = currentOut != 0 ? jw + 1 : jw;
			kh = currentOut != 1 ? kh + 1 : kh;
			mh = currentOut != 2 ? mh + 1 : mh;
		}
		
		if (win[0] == k) {
			return 1;
		}
		
		return 0;
	}
	
	static boolean isWinning(int firstHand, int secondHand) {
		if (winMap[firstHand - 1][secondHand - 1] == 2) {
			return true;
		}
		
		return false;
	}
	
	static int getHand(int jw, int player, int khIndex, int mhIndex) {
		if (player == 0) {
			return players.get(player)[jw];
		}
		
		if (player == 1) {
			return players.get(player)[khIndex];
		}
		
		return players.get(player)[mhIndex];
	}
	
	static int[] getPlayers(boolean[] out) {
		int[] players = new int[3];
		
		if (out[0] == true) {
			players[0] = 1;
			players[1] = 2;
			players[2] = 0;
		}
		
		if (out[1] == true) {
			players[1] = 2;
			players[2] = 1;
		}
		
		if (out[2] == true) {
			players[1] = 1;
			players[2] = 2;
		}
		
		return players;
	}
	
	static void initPlayers(BufferedReader br) throws IOException {
		int[] jw = new int[20];
		int[] kh = new int[20];
		int[] mh = new int[20];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 20; i++) {
			kh[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 20; i++) {
			mh[i] = Integer.parseInt(st.nextToken());
		}
		
		players.put(0, jw);
		players.put(1, kh);
		players.put(2, mh);
	}
	
	static void initWinMap(BufferedReader br, int n) throws IOException {
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				winMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
}