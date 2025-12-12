class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for (long i = l; i <= r; i++) {
            if (isOne(i - 1, n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    boolean isOne(long idx, int n) {
        long size = (long) Math.pow(5, n - 1);
        long block = idx / size;
        
        if (n == 1) {
            if (idx / size == 2) {
                return false;
            }
            
            return true;
        }
        
        return block == 2 ? false : isOne(idx - (block * size), n - 1);
    }
}