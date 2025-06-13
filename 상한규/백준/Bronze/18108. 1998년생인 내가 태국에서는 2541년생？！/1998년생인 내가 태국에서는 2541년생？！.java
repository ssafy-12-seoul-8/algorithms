import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int bullYear = Integer.parseInt(br.readLine());
    System.out.println(bullYear - (2541 - 1998));
  }
}