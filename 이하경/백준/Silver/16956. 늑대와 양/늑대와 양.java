import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	// 아이디어 : 양의 위치를 다 저장한다음에 양 사방에 울타리를 치자
	// 양 바로옆에 늑대가 있으면 불가능
	
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<int[]> sheep = new ArrayList<>();
        char[][] farm = new char[r][c];
        
        // farm 입력, sheep에 양 위치 저장
        for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				char ch = input.charAt(j);
				if (ch == 'S') {
					sheep.add(new int[] { i, j });
				}
				farm[i][j] = ch;
			}
		}
        
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        // 양 위치 확인하며 사방에 울타리 치기
        boolean flag = true;
        outer:
        for (int[] sh : sheep) {
        	int x = sh[0];
        	int y = sh[1];
        	
        	for (int i = 0; i < 4; i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		
        		if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
        			if (farm[nx][ny] == 'W') {
        				flag = false;
        				break outer;
        			} else if (farm[nx][ny] == '.') {
        				farm[nx][ny] = 'D';
        			}
        		}
        	}
        }
        
        if (flag) {
        	sb.append(1).append("\n");
        	
        	for (char[] chs : farm) {
        		sb.append(chs).append("\n");
        	}
        } else {
        	sb.append("0");
        }
        
        System.out.println(sb);
        
    }
}
