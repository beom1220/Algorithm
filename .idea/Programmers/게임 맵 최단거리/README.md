# 게임 맵 최단거리

---

- 풀이 실패하여 검색 도움받아 풀이

## 📌 **Algorithm**

---

- BFS (너비 우선 탐색)

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    // 상하좌우 이동 시 사용하는 델타 정의
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>(); // bfs 위한 큐 생성
        queue.add(new int[]{0, 0}); // 시작 위치가 될 0,0 추가

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 한 반복 -> 더 이상 탐색할 위치 X
            int[] current = queue.poll(); // 위치 하나 꺼내서 bfs 수행
            for (int i = 0; i < 4; i++) { // 상하좌우 이동 가능 여부 확인
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 맵 범위 벗어나면 무시
                if (maps[nx][ny] == 1) { // 다음 위치에 벽이 없으며 방문한 적 없는지 검사
                    maps[nx][ny] = maps[current[0]][current[1]] + 1;
                    // 시작 위치에서 이동한 위치까지의 거리 +1을 저장
                    queue.add(new int[]{nx, ny}); // 큐에 다시 넣어서 bfs 수행하도록 함.
                }
            }
        }

        return (maps[n - 1][m - 1] == 1) ? -1 : maps[n - 1][m - 1];
        // 목적지에 도착한 적 있으면 1이 아님. 도착한 적 없으면 1이니까 -1 반환.
    }
}
```

- 큐를 이용한 bfs로 좌표를 이동해가면서 최단거리를 기록.
- 벽이 아닌 곳에는 각 지점까지의 최단거리가 기록되는 방식

## ✒️ **Review**

---

- BFS 또한 DFS처럼 개념적으로는 학습하여 이해하고 있지만 코드로 직접 구현하는 것은 아직 어려웠다. 애초에 BFS와 DFS를 정확히 언제 사용해야 하는지부터가 익숙하지 않았다.
- 최단거리를 물어본다면 BFS로 풀이해야 한다는 것을 다시 학습하여 숙지하였고, DFS는 미로 찾기나 특정 노드를 찾는 문제에서 사용해야 한다는 것을 숙지하였다.
- 그걸 모르고 처음에 DFS로 이 문제를 풀이하려고 했다보니 자꾸 논리적인 오류가 발생해서 해결하지 못했었다.
- 진짜 연습 한참 더 필요하구나를 매번 느끼고 있다.