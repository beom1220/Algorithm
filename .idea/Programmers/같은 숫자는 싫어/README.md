# 같은 숫자는 싫어

---

## 📌 **Algorithm**

---

- 스택

## 📍 **Logic**

---

```java
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> st = new Stack<>();
        st.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (st.peek() != arr[i]) {
                st.add(arr[i]);
            }
        }

        int[] answer = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        return answer;
    }
}
```

- 첫 숫자는 무조건 중복 없으니 일단 스택에 넣음.
- 이후부터는 peek과 비교하여 다르면 스택에 넣음.
- 배열을 스택 사이즈로 생성하여, 뒤에서부터 스택에서 팝한 값을 넣음.

## ✒️ **Review**

---

- 레벨1이니까 그냥 무난하고 쉽게 풀긴 했는데, 뭔가 더 간결하게 끝낼 수 있을 거 같기도 하지만 일단 당장 생각난 건 이 코드라 이렇게 풀었다.