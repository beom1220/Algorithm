# 전화번호 목록

---

## 📌 **Algorithm**

---

- 정렬

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
								break;
            }
        }
        return answer;
    }
}
```

- 배열을 사전 순으로 정렬하여, 다음 것과 비교한다. 사전 순이기 때문에 다음 것에 접두어가 아닌 이상 접두어일 수 없다.

## ✒️ **Review**

---

- 최대 100만건의 전화번호를 준다고 해서, 이중  for문은 안 될 거라고 생각했다.
- 일단 사전순 정렬을 하는 건 당연하다고 생각해서 진작 해뒀는데, 막상 저 간단한 해법이 당장 떠오르질 않았다.
- 문득 생각해보니 어차피 당장 아니면 그 뒤는 아닌 거더라. 그래서 풀었다.