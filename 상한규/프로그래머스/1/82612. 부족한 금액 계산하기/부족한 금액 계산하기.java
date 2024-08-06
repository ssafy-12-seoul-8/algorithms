class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        double totalCount = 0;
        totalCount = count == 1 ? 1 : (1 + count) * ((double)count / 2);
        answer = (long)totalCount * price - money;

        return answer >= 0 ? answer : 0;
    }
}