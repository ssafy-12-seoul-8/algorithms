class Solution {
    static int answer;
    static int[] nums;
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        
        for (int number : numbers) {
            sum += number;
        }
        
        target = (sum - target) / 2;
        nums = numbers;
        recur(0, 0, target);
        return answer;
    }
    
    public void recur(int idx, int sum, int target) {
        if (sum == target) {
            answer++;
            return;
        }
        
        if (sum > target || idx == nums.length) {
            return;
        }
        
        recur(idx + 1, sum + nums[idx], target);
        recur(idx + 1, sum, target);
    }
}