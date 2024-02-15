# 단속카메라

---

- 풀이 실패

## 📌 **Algorithm**

---

- 그리디

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int lastCamera = -30001;
        for (int[] route : routes) {
            if (lastCamera < route[0]) {
                lastCamera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
```

- 일단 들어오는 차량들을 나가는 지점 기준으로 정렬.
- lastCamera에는 최근 설치한 카메라 위치가 저장될 것이기 때문에, 가장 작은 -30000보다 작은 값을 저장하였음.
- 이후 모든 차량을 탐색하면서 그 출발 위치가 마지막 설치된 카메라보다 앞에 있다면, 단속이 되지 않으므로 카메라의 위치를 그 도착 위치로 옮기고 카메라 수를 1 더해준다.

## ✒️ **Review**

---

- 그냥 못 풀었다.
- 내가 생각한 별 이상한 방법은 다 실패했다.
- 생각하면서도 사실 반례가 있을 거 같았어서 불안불안한 방법 뿐이었다.
- 정확히 이거일 거 같다는 방법 자체가 안 떠올랐다는 것이다.
- 근데 답 보니까 진짜 허무하더라. 레벨3 들어오자마자 이렇게 방법부터 안 떠오를 줄이야.
- 보통은 큰 흐름은 떠오르고, 반례 한두개를 못 찾아서 좀 틀리거나, 전체적인 구조 문제로 시간 초과가 발생하는 케이스가 있거나 정도로 막혔다면 이번 건 아예 망했다.