import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int perMinute = H * 60 + M;
		int targetMinute = perMinute - 45 < 0 ? perMinute + 24 * 60 - 45 :perMinute - 45;
		int targetH = targetMinute / 60;
		int targetM = targetMinute % 60;
		
		sb.append(targetH).append(" ").append(targetM);
		
		System.out.println(sb);
	}
}