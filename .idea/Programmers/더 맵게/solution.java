import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);ㅖ
        }
        while(q.peek() < K) {
            if (q.size() >= 2) {
                int min = q.remove();
                int miin = q.remove();
                q.add(min + miin * 2);
                answer++;
            } else {
                return -1;
            }
        }

        return answer;
    }
}