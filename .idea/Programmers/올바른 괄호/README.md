# 올바른 괄호

---

- 효율성 테스트 때문에 검색의 도움을 받음.

## 📌 **Algorithm**

---

- 스택

## 📍 **Logic**

---

```java
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
```

- 왼쪽 괄호를 만나면 푸시, 오른쪽 괄호를 만나면 스택이 안 비었다면 팝하여 왼쪽 괄호가 나오는지 검사를 반복한다.

## ✒️ **Review**

---

- 스택에 대해 배울 당시 배웠던 거라 풀이 방법은 어렵지 않았다.
- 다만, 아무리 풀어도 테스트 케이스는 모두 맞는데 자꾸 효율성 테스트에서 2개 모두 시간 초과가 떴다. 아래가 기존 코드.

```java
import java.util.*;

 class Solution {
     boolean solution(String s) {
         String[] ss = s.split("");
         Stack<String> st = new Stack<>();
         for (int i = 0; i < ss.length; i++) {
             String t = ss[i];
             if (t.equals("(")) {
                 st.push(t);
             } else {
                 if (st.isEmpty() || !st.pop().equals("(")) {
                     return false;
                 }
             }
         }
         return st.isEmpty();
     }
 }
```

- 찾아보니 문제는 String에 있었다. 자꾸 Stack 구조 상 문제가 있을 줄 알고 그쪽으로만 생각해서 못 찾은 거였다. 조금만 생각해보면 알 수 있는 건데, 너무 Stack에만 매몰되어 고민했었다.
- 애초에 복잡도가 O(n)이라 최대 10만번의 연산이라서 효율성 테스트에서 문제가 생길 거라고 생각도 안 했는데, 기준이 엄청 짧게 잡혀있는 문제였나보다.
- 암튼 기억하자. toCharArray()