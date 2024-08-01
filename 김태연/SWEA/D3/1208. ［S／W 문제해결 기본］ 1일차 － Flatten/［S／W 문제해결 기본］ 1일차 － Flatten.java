import static java.util.Collections.reverseOrder;
 
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
         
         
        for(int test_case = 1; test_case <= 10; test_case++)
        {
         
            int dumpNumber = sc.nextInt();
            List<Integer> boxs = new ArrayList<Integer>();
            PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(reverseOrder());
             
            int sum = 0;
            double avg = 0;
            // 박스 100번 받기
            for (int i=0; i<100; i++) {
                int box = sc.nextInt();
                boxs.add(box);
                sum += box;
            }
             
            avg = (double) sum / 100;
            for (int i=0; i<100; i++) {
                int box = boxs.get(i);
                if (box >= avg) maxQueue.add(box);
                else minQueue.add(box);
            }
             
            while (dumpNumber > 0) {
                int max = maxQueue.poll();
                max--;
                int min = minQueue.poll();
                min++;
                if (max > avg) maxQueue.add(max);
                else minQueue.add(max);
                 
                if (min < avg) minQueue.add(min);
                else maxQueue.add(min);
                 
                 
                dumpNumber--;
            }
             
            int result = maxQueue.poll() - minQueue.poll();
            System.out.println("#" + test_case + " " + result);
        }
    }
}