class Solution {
    public int solution(String[] friends, String[] gifts) {
    
        int answer = 0;
        int[] moneyList = new int[friends.length];
        
        for (int i = 0; i < friends.length - 1; i++) {
        	for (int j = i + 1; j < friends.length; j++) {
            	String A = friends[i];
            	String B = friends[j];
				int compareCount = 0;
				int price = 0;
				
            	for (int k = 0; k < gifts.length; k++) {
					String giver = gifts[k].split(" ")[0];
					String receiver = gifts[k].split(" ")[1];
					
					if(A.compareTo(giver) == 0 || B.compareTo(receiver) == 0) {
						price++;
					}
					else if(A.compareTo(receiver) == 0 || B.compareTo(giver) == 0) {
						price--;
					}
					if(A.compareTo(giver) == 0 && B.compareTo(receiver) == 0) {
						compareCount++;
					}
					else if(B.compareTo(giver) == 0 && A.compareTo(receiver) == 0) {
						compareCount--;
					}
				}

				if(compareCount > 0) {
					moneyList[i]++;
				}
				else if(compareCount < 0) {
					moneyList[j]++;
				}
				else {
					if(price > 0) {
						moneyList[i]++;
					}
					else if(price < 0) {
						moneyList[j]++;
					}
				}
			}
		}
        
        for (int i = 0; i < moneyList.length; i++) {
			answer = Math.max(answer, moneyList[i]);
		}
        
        
        return answer;
    }
}