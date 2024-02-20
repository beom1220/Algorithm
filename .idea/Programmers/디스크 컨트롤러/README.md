# 디스크 컨트롤러

---

## 📌 **Algorithm**

---

- 우선 순위 큐
- 운영체제

## 📍 **Logic**

---

```java
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
```

- 문제에서 말하는 방법은 현재 도착한 작업 중 가장 짧은 작업을 진행하는 방법이다.
- 우선 큐에는 작업에 걸리는 시간만 넣기로 했다.
- time을 통해서 현재 시간을 기록하였고, 작업이 끝나면 그 작업시간만큼 더해주거나, 아무 작업이 없는 텀이 발생하면 1씩 더해주게끔 하였다.
- time보다 작거나 같은 요청시간의 작업은 모두 큐에 넣는다.
- 우선순위 큐이기 때문에 그 중 작은 값부터 뽑아서 작업을 진행시킨다.
- 요청을 큐에 넣을 때, 요청시간만큼 answer에서 미리 빼두고, 작업이 완료될 때 완료 당시 시간을 answer에 더해주었다.

## ✒️ **Review**

---

- 의도한 그대로 풀이했으나, 우선 순위 큐에서 원래 큰 값부터 나오는 줄 알고 처음에는 reverseOrder를 달았는데, 값이 이상하게 나오길래 sout로 출력시켜보니 그게 큰 값부터 나오더라.
- 원래는 작은 값부터 나오는 건데, 그걸 헷갈려했지만 그래도 금방 찾아내서 큰 문제는 없었다. 이번 기회에 제대로 기억하면 되겠다. 우선순위 큐는 작은 값부터 뱉는다.