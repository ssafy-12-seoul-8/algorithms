import java.io.*;
import java.util.*;

public class Main {
    
    static class Coord implements Comparable<Coord> {
        
        int x;
        int y;
        
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Coord other) {
            if (this.x == other.x) {
                return this.y - other.y;
            }
            
            return this.x - other.x;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coord> coords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            coords.add(new Coord(x, y));
        }
        
        Collections.sort(coords);
        
        for (int i = 0; i < n; i++) {
            Coord coord = coords.get(i);
            
            sb.append(coord.x + " " + coord.y)
                .append("\n");
        }
        
        System.out.println(sb);
    }
    
}