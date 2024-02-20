# 완주하지 못한 선수

---

## 📌 **Algorithm**

---

- 해시 맵

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                hm.replace(participant[i], hm.get(participant[i]) + 1);
            } else {
                hm.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (hm.get(completion[i]) == 1) {
                hm.remove(completion[i]);
            } else {
                hm.replace(completion[i], hm.get(completion[i]) - 1);
            }
        }

        Set<String> s = hm.keySet();
        for (String ss : s) {
            answer = ss;
        }
        return answer;
    }
}
```

- key에는 선수의 이름을 넣었고, value에는 그 이름의 선수가 몇 명인지 정수 값을 저장하였다.
- 완주 목록으로 탐색하면서, key를 찾고, value가 1이면 삭제하고 1이 아니면 1을 줄이면서 최종적으로 완주하지 못한 선수만 남게 된다.

## ✒️ **Review**

---

- 처음에는 그냥 이거 List로도 되는 거 아닌가 싶었다. 해시 문제로 나온 문제지만, 그래서 일단 리스트로 풀어봤다.

```jsx
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> l = new ArrayList<>();
        for (int i = 0; i < participant.length; i++) {
            l.add(participant[i]);
        }
        for (int i = 0; i < completion.length; i++) {
            l.remove(completion[i]);
        }
        answer = l.get(0);
        return answer;
    }
}
```

- 모든 문제에 대해 정답은 나왔다. 하지만 시간 초과가 발생했다.
- 두 개의 컬렉션에서 탐색 방법에 차이가 있기 때문이었다.
- 단순하게, 선수가 10만명이고, 완주자가 10만명에서 1명 적게 되어있다고 하고, 주어지는 배열에서 선수 명단의 이름이 역순으로 완주 명단으로 오게 된다면, List는 매번 10만번에 가까운 탐색을 하게 되는 것이다. 시간초과가 발생할 수 밖에 없다.
- 하지만 HashMap은 탐색 시 시간 복잡도가 O(1)인 것으로 알고 있다.
- 이런 것도 다 잘 기억해야 문제 풀 때 점수를 지킬 수 있을 것 같다. 효율성 테스트는 제출 후에서야 확인할 수 있는 부분이라서 익숙하다고 단순히 List부터 쓰고 보는 건 안 좋은 습관인 것 같다.