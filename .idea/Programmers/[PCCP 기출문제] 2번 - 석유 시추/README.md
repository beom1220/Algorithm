# [PCCP 기출문제] 2번 - 석유 시추

---

- 풀이 실패

## 📌 **Algorithm**

---

- DFS
- 그래프 탐색

## 📍 **Logic**

---

```java
public static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        visited[x][y] = oil.size() + 1;
        int cnt = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (landCopy[nx][ny] == 1 && visited[nx][ny] == 0) {
                        stack.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[current[0]][current[1]];
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
```

- 인접한 곳에 1이 있다면, 체크해서 해당 덩어리에 석유의 양을 반환하기 위한 깊이 우선 탐색 함수. 재귀를 이용해서 풀이했다가, 스택 오버 플로우가 발생해서 명시적인 Stack을 사용하는 코드로 변경하였다.

## ✒️ **Review**

---

- 이번 문제는 혼자 힘으로 풀이하지 못했다.
- 풀이 방법을 생각해내는 것까지는 어느 정도 했었으나, 깊이 우선 탐색에 익숙하지 않아서 결국 구글링의 도움을 받아서 풀었다.
- 이번 기회를 통해 DFS와 BFS에 대해 다시 공부해보면서 실제 코드에 어떻게 적용하는지 학습했다.
- 알고리즘 문제 풀이에서는 단순한 재귀를 통한 스택 사용은 위험하다는 사실도 깨달았다.