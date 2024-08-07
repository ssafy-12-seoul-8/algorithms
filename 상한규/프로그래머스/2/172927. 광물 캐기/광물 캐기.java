import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxMinerals = 0;
        String[] ableMinerals = minerals;
        
        for(int i = 0; i < picks.length; i++){
            maxMinerals += picks[i] * 5;
        }
        
        if(minerals.length > maxMinerals){
            ableMinerals  = Arrays.copyOf(minerals, maxMinerals);
        }
        
        int[] energyArray = new int[(int)Math.ceil((double)ableMinerals.length / 5)];
        int[] rankArray = new int[energyArray.length];
        
        for(int i = 0; i < ableMinerals.length; i++){
            int energyIndex = i / 5;
            if(ableMinerals[i].equals("diamond")){
                energyArray[energyIndex] += 25;
            }
            else if(ableMinerals[i].equals("iron")){
                energyArray[energyIndex] += 5;
            }
            else if(ableMinerals[i].equals("stone")){
                energyArray[energyIndex] += 1;
            }
        }
        
        loop: while(true){
            int maxMineralCount = 0;
            int maxIndex = 0;
            int pickIndex = 0;
            
            for(int i = 0; i < energyArray.length; i++){
                if(maxMineralCount < energyArray[i]){
                    maxMineralCount = energyArray[i];
                    maxIndex = i;
                }
            }
            for(int i = 0; i < picks.length; i++){
                if(i == 2 && picks[i] == 0){
                    break loop;
                }
                if(picks[i] == 0){
                    continue;
                }
                picks[i]--;
                pickIndex = i;
                break;
            }
            
            for(int i = maxIndex * 5; i < maxIndex * 5 + 5;i++){
                if(i >= ableMinerals.length || ableMinerals[i].equals("")){
                    continue;
                }
                if(pickIndex == 0){
                    answer += 1;
                    ableMinerals[i] = "";
                }
                else if(pickIndex == 1){
                    if(ableMinerals[i].equals("diamond")){
                        answer += 5;
                        ableMinerals[i] = "";
                    }
                    else{
                        answer += 1;
                        ableMinerals[i] = "";
                    }
                }
                else if(pickIndex == 2){
                    if(ableMinerals[i].equals("diamond")){
                        answer += 25;
                        ableMinerals[i] = "";
                    }
                    else if(ableMinerals[i].equals("iron")){
                        answer += 5;
                        ableMinerals[i] = "";
                    }
                    else{
                        answer += 1;
                        ableMinerals[i] = "";
                    }
                }
            }
            energyArray[maxIndex] = 0;
        }
        
        System.out.println(Arrays.toString(energyArray));
        System.out.println(Arrays.toString(ableMinerals));
        return answer;
    }
}