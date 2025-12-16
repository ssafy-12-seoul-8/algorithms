import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        int idx = 0;
        int currTime = 0;
        
        Arrays.sort(plans, (o1, o2) -> {
            String[] t1 = o1[1].split(":");
            String[] t2 = o2[1].split(":");
            int min1 = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
            int min2 = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);
            return min1 - min2;
        });
        
        Stack<String[]> stack = new Stack<>();
        
        for (String[] plan : plans) {
            System.out.println(Arrays.toString(plan));
        }
        
        for (String[] plan : plans) {
            String[] t = plan[1].split(":");
            int restTime = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]) - currTime;
            currTime = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            
            while (!stack.isEmpty() && restTime != 0) {
                String[] curr = stack.pop();
                String name = curr[0];
                int playtime = Integer.parseInt(curr[1]);
                
                if (restTime >= playtime) {
                    answer[idx++] = name;
                    restTime -= playtime;
                } else {
                    playtime -= restTime;
                    restTime = 0;
                    stack.add(new String[] {name, String.valueOf(playtime)});
                }
            }
            
            stack.add(new String[] {plan[0], plan[2]});
        }
        
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop()[0];
        }
        
        return answer;
    }
}