# 피로도

---

- 풀이 실패.

## 📌 **Algorithm**

---

- 완전탐색
- DFS (깊이 우선 탐색)

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer> dc = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        // 피로도 사용해서 던전 탐험
        // 최소 필요 피로도, 소모 피로도 (마치면 소모됨)
        // 최대한 많이 탐험하고자 함.
        
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return max(dc);
    }
    
    void dfs(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
        dc.add(cnt);
    }
    
    int max(List<Integer> dc) {
        int a = 0;
        for (int c : dc) {
            a = Math.max(a, c);
        }
        return a;
    }
}
```

- dfs를 통해 가능한 조합을 모두 확인.
- 그 중 최댓값을 반환.

## ✒️ **Review**

---

- 어느 정도 dfs 코드대로 짰으나 약간의 실수가 있었다. dfs 학습할 때 다시 한번 풀어봐야겠다.