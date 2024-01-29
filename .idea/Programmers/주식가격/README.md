# 주식가격

---

## 📌 **Algorithm**

---

- 자료구조
- 스택

## 📍 **Logic**

---

```java
for (int i = 0; i < prices.length; i++) { // prices 전체 반복.
            while (!stack.isEmpty() && stack.peek()[0] > prices[i]) { // stack 안 비고, peek의 값이 현재값보다 크면
                int[] temp = stack.pop(); // 임시값에 pop하여 저장
                answer[temp[1]] = i - temp[1];
                // answer의 해당 위치에 값을 저장.
                // i - temp[i]면 가격이 떨어지지 않은 기간 계산 될 듯
            }
            stack.push(new int[]{prices[i], i}); // 그리고 해당 값을 push함. i는 인덱스와 같음.
        }

        while (!stack.isEmpty()) { // 스택 비우기.
            int[] temp = stack.pop();
            answer[temp[1]] = prices.length - 1 - temp[1]; // 해당 위치에다가 남은 거 넣음
        }
```

- 각 시점과 가격을 스택에 저장하여, 현재 시점과 비교하여 큰지 작은지 검사한다.

## ✒️ **Review**

---

- Stack 내부에 int형 배열을 넣을 생각을 안 했어서 처음엔 복잡한 방식으로 풀이하다가, 답에는 어느 정도 접근하였지만, 아무리 생각해도 풀이방법이 아닌 것 같았다.
- 시간도 이미 꽤나 지났기 때문에 풀이에 실패한 것으로 하고 풀이를 찾아보고 다시 풀이하였다.