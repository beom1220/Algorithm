import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        // 시점에 따라서 큐에다가 add해줌.
        // 그리고 크기에 따라 작은 게 먼저 나오도록 priority queue를 colloections.reverseOrder 해주고,
        // 그때마다 poll 해주면 일단 될 거는 같은데.
        // 일단 시작해보겠음.

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작은 거부터 나옴.
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 도착 시간 앞인 것부터 일단 두겠다.
        int time = 0;
        int i = 0;
        while (true) {
            while (true) { // 도착시간만큼 된 작업들 다 넣기.
                if (i == jobs.length) { // jobs에 있는 걸 다 넣었으면 그만.
                    break;
                }
                if (jobs[i][0] <= time) {
                    pq.add(jobs[i][1]);
                    answer -= jobs[i][0];
                    i++;
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) { // 큐가 안 비었다면
                int jt = pq.poll(); // 다음 작업을 뺌 (도착한 것 중에 가장 짧은 작업시간)
                time += jt; // 시간은 그만큼 흐름
                answer += time;
            } else {
                if (i == jobs.length) { // 큐 비었는데, i가 jobs에서 끝까지 이미 다 뺐다면 완전히 끝.
                    break;
                } else { // 아니면 시간이 흘러야 함. 사이가 떠 있을 수도 있으니까.
                    time++;
                }
            }
        }

        return answer / jobs.length;
    }
}