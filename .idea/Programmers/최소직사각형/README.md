# 최소직사각형

---

## 📌 **Algorithm**

---

- 완전탐색

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 명함을 모두 수납할 수 있는 가장 작은 지갑을 만든다.
        // 명함은 당연히 눕힐 수도 있다.
        
        // 그럼 일단 가로 또는 세로 하나는 가장 큰 값과 같아야 한다.
        // 일단 그럼 가로, 세로 중에 작은거, 큰거로 정리를 하고.
        // 가로 중 제일 큰 거랑 세로 중 제일 큰 거 찾으면 끝 아니가.
        int[][] s = new int[sizes.length][2];
        int gmax = 1;
        int smax = 1;
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            s[i][0] = Math.min(a, b);
            s[i][1] = Math.max(a, b);
            
            gmax = Math.max(gmax, s[i][0]);
            smax = Math.max(smax, s[i][1]);
        }
        
        int answer = gmax * smax;
        return answer;
    }
}
```

- 명함의 사이즈를 [더 작은 거] [더 큰 거]로 정리하는 새로운 배열 s를 만든다.
- 전체를 탐색하면서 동시에 각 가로와 세로 중 가장 큰 값을 구한다.
- 그 값끼리 곱한다.

## ✒️ **Review**

---

- 레벨1이라 어려움 없이 풀었다.