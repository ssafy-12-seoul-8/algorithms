class Solution {
    public int solution(int[] stones, int k) {
        
        return binarySearch(stones, 0, 200_000_000, k);
    }
    
    // canGo == true가 되는 최댓값
    public int binarySearch(int[] stones, int start, int end, int k) {
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (canGo(stones, mid, k)) { // 이 값이 가능하다면 아래는 볼 필요 없지
                start = mid;
                continue;
            }
            end = mid - 1;
        }
        return start;
    }
    
    // mid명이 건너면 mid보다 큰거만 이용가능
    public boolean canGo(int[] stones, int mid, int k) {
        int cnt = 0;
        for (int stone : stones) {
            if (stone < mid) {
                cnt++;
                if (cnt == k) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}
