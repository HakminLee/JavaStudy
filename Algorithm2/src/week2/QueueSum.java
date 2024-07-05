import java.util.Arrays;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int sum1 = Arrays.stream(queue1).sum();
        int sum2 = Arrays.stream(queue2).sum();

        // 두 큐의 합이 다르면서 홀수인 경우, 합을 같게 만들 수 없음
        if (sum1 != sum2 && (sum1 + sum2) % 2 != 0) {
            return -1;
        }

        // 큐를 오름차순으로 정렬
        Arrays.sort(queue1);
        Arrays.sort(queue2);

        int moveCount = 0;
        int i = queue1.length - 1;
        int j = queue2.length - 1;

        // 큐의 합이 같아질 때까지 원소 이동 작업 수행
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                sum1 -= queue1[i--];
            } else {
                sum2 -= queue2[j--];
            }
            moveCount++;
        }

        return moveCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스 1
        int[] queue1_1 = {3, 2, 7, 2};
        int[] queue2_1 = {4, 6, 5, 1};
        System.out.println(solution.solution(queue1_1, queue2_1)); // Expected: 2

        // 테스트 케이스 2
        int[] queue1_2 = {1, 2, 1, 2};
        int[] queue2_2 = {1, 10, 1, 2};
        System.out.println(solution.solution(queue1_2, queue2_2)); // Expected: 7

        // 테스트 케이스 3
        int[] queue1_3 = {1, 1};
        int[] queue2_3 = {1, 5};
        System.out.println(solution.solution(queue1_3, queue2_3)); // Expected: -1
    }
}
