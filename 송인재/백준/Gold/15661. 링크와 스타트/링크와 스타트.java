import java.io.*;
import java.util.*;

public class Main {
	
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] abs = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				abs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n - 1; i++) {
			formTeam(abs, new boolean[n], i, 0);
		}
		
		System.out.println(minDiff);
	}
	
	static void formTeam(int[][] abs, boolean[] teams, int index, int teamCount) {
		if (abs.length - teamCount > 2) {
			teams[index] = true;
			
			teamCount++;
		}
		
		if (teamCount >= 2) {
			calculate(abs, teams, teamCount);
		}
		
		for (int i = index + 1; i < abs.length; i++) {
			formTeam(abs, teams, i, teamCount);
		}
		
		teams[index] = false;
	}
	
	static void calculate(int[][] abs, boolean[] teams, int teamCount) {
		int startTeam = 0;
		int linkTeam = 0;
		
		for (int i = 0; i < abs.length - 1; i++) {
			for (int j = i + 1; j < abs.length; j++) {
				if (teams[i] && teams[j]) {
					startTeam += abs[i][j] + abs[j][i];
				}
				
				if (!teams[i] && !teams[j]) {
					linkTeam += abs[i][j] + abs[j][i];
				}
			}
		}
		
		minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
	}
	
}