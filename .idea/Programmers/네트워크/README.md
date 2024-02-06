# 네트워크

---

## 📌 **Algorithm**

---

- BFS

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 방문 검사용
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int j = 0; j < n; j++) {
                        if(computers[node][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
```

- 컴퓨터마다 하나씩 정해두고 돌면서 연결된 네트워크를 찾는다. 이미 찾은 곳은 visited로 표시해서 완전 탐색하지 않게끔 한다.

## ✒️ **Review**

---

- bfs나 dfs를 쓰지 않고 풀 수 있을 줄 알고, 그냥 풀어봤었는데, 논리적인 문제가 발생할 수 있다는 것을 알았다.
- 그래서 문제를 다시 풀었는데, bfs와 dfs를 반복 학습 중이라 그래도 어느 정도 괜찮게 풀렸다.