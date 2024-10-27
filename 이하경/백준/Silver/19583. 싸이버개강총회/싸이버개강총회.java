import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();

        Set<String> entrance = new HashSet<>(); // 개강총회에 입장한 사람들
        Set<String> exit = new HashSet<>(); // 입장과 퇴장이 확인된 사람들

        String input = br.readLine();
        while (input != null) {
            st = new StringTokenizer(input);
            input = br.readLine();
            String time = st.nextToken();
            String name = st.nextToken();

            if (time.compareTo(s) <= 0) { // time이 s보다 작거나같으면 입장 확인
                entrance.add(name);
                continue;
            }

            if (time.compareTo(e) < 0) { // 시작~끝 사이는 pass
                continue;
            }

            if (time.compareTo(q) <= 0 && entrance.contains(name)) { // 스밍 끝나기 전에 퇴장, 입장기록 있음
                exit.add(name);
            }
        }

        System.out.println(exit.size());
    }
}
