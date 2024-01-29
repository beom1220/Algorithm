import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>(); // [값, 시점] 저장할 Stack 생성

        for (int i = 0; i < prices.length; i++) { // prices 전체 반복.
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) { // stack 안 비고, peek의 값이 현재값보다 크면
                int[] temp = stack.pop(); // 임시값에 pop하여 저장
                answer[temp[1]] = i - temp[1];
                // answer의 해당 위치에 값을 저장.
                // i - temp[i]면 가격이 떨어지지 않은 기간 계산 될 듯
            }
            stack.push(new int[]{prices[i], i}); // 그리고 해당 값을 push함. i는 인덱스와 같음.
        }

        while (!stack.isEmpty()) { // 스택 비우기.
            int[] temp = stack.pop();
            answer[temp[1]] = prices.length - 1 - temp[1]; // 해당 위치에다가 남은 거 넣음
        }

        return answer;
    }
}
