class Solution {
    public int solution(int[] cards) {
        int boxCnt = 0;
        int first = 1;
        int second = 1;
        
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == -1) {
                continue;
            }
            
            if (cards[i] == i + 1) {
                boxCnt++;
                continue;
            }
            
            int idx = cards[i];
            int cnt = 1;
            
            while (true) {
                int temp = idx;
                idx = cards[idx - 1];
                cards[temp - 1] = -1;
                
                if (cards[idx - 1] == -1) {
                    break;
                }
                
                cnt++;
            }
            
            second = Math.max(second, cnt);
            int temp1 = first;
            int temp2 = second;
            first = Math.max(temp1, temp2);
            second = Math.min(temp1, temp2);
            boxCnt++;
        }
        
        return boxCnt == 1 ? 0 : first * second;
    }
}