# 의상

---

## 📌 **Algorithm**

---

- 해시 맵

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해시맵으로, 각 종류를 키로 삼아서 밸류에다가 개수를 정수로 저장.
        // 그럼 이제 모든 value를 받아서 Set으로 함.
        // 그러고 각 value에 +1을 한 값끼리 곱함.
        // 거기서 1을 빼면 끝이지 않나.
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String[] c = clothes[i];
            if (hm.containsKey(c[1])) {
                hm.replace(c[1], hm.get(c[1]) + 1);
            } else {
                hm.put(c[1], 1);
            }
        }
        Set<String> s = hm.keySet();
        int answer = 1;
        for (String ss : s) {
            answer *= (hm.get(ss) + 1);
        }
        return answer - 1;
    }
}
```

- key에는 의상 종류를, value에는 그 개수를 저장하였다.
- 이후 모든 의상 종류에 +1을 하여 곱하고 1을 빼주었다.
- 의상들 중 하나를 선택하거나(의상 종류 수), 아예 선택하지 않을 수 있지만(+1), 모든 의상을 선택하지 않을 수는 없기 때문이다. (전체에서 -1)

## ✒️ **Review**

---

- 의도한 그대로 문제가 풀이되었다.
- 사실 말이 해시 문제지, 경우의 수 문제라 풀이에 어려움이 없었던 것 같다.