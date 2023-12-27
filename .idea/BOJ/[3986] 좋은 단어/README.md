# [3986] 좋은 단어

---

## 📌 **Algorithm**

---

- 자료 구조
- 스택

## 📍 **Logic**

---

```java
for (String s : l) {
    String[] ls = s.split("");
    Stack<String> st = new Stack<>();

    for (int i = 0; i < ls.length; i++) {
        String check = ls[i];
        if (!st.empty() && st.peek().equals(check)) {
            st.pop();
        } else {
            st.push(check);
        }
    }

    if (st.empty()) {
        cnt++;
    }
}
```

- 각 단어를 돌면서 문자마다 규칙에 따라 푸쉬와 팝을 하며, 좋은 단어인지 검사하는 로직.

## ✒️ **Review**

---

- 스택에 대한 개념은 알고 있었지만, 직접 코드에서 사용해보는 것은 처음이었다.
- 검색없이도 push나 pop, empty는 직관적으로 사용할 수 있었지만, peek의 존재를 몰라서 처음에는 복잡하게 검사하는 로직을 짰으나, 한번 틀렸었다.
- 왜 틀렸는지 찾아보다가 결국 찾지 못하고 구글링을 통해 peek의 존재를 알아내서, 이를 적용시켜 풀이할 수 있었다. 앞으로의 스택 문제 풀이에는 검색 없이 할 수 있을 듯 하다.