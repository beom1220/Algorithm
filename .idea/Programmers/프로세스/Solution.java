import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 그게 몇 번째로 수행됐는지를 파악해야 한다.
        // 뒤에 더 큰 게 있다면 다시 맨 뒤로 가서 기다려야 하는구나.

        Queue<List<Integer>> q = new LinkedList<>();
        // 일단 큐 만들고 봄. 원래의 인덱스, 값으로 저장할 거임.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 큰 값부터 앞에 둬서 현재 값이 최댓값인지 비교하는 용으로 쓸 거임.

        for (int i = 0; i < priorities.length; i++) {
            int t = priorities[i];
            List<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(t);
            q.add(l);
            pq.add(t);
        }

        int answer = 0;
        while (true) { // location에 있는 거 실행할 때까지 반복
            List<Integer> nl = q.poll();
            int n = nl.get(1);
            if (n == pq.peek()) {
                pq.poll();
                answer++;
                if (nl.get(0) == location) {
                    break;
                }
            } else {
                q.add(nl);
            }
        }

        return answer;
    }
}