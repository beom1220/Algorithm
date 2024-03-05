# H-Index

---

## 📌 **Algorithm**

---

- 정렬

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length; i > 0; i--) {
            if (citations[citations.length - i] >= i) {
                return i;
            }
        }
    }
}
```

- 일단 논문 배열을 정렬한 뒤, index와 인용 수를 비교하면서 값을 리턴한다.

## ✒️ **Review**

---

- 원리를 파악해보고, 코드로 옮겼는데 그대로 맞아서 얼떨떨하다.
- 근데 생각해보면 0인 경우도 있어야 할 거 같은데, for문 뒤에 return 0이 필요하지 않을까 싶다. 아마 테스트케이스에서 빼먹은 듯.