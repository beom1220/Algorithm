# 뒤에 있는 큰 수 찾기

---

- 시간 초과로 풀이 실패

## 📌 **Algorithm**

---

- 자료구조
- 스택

## 📍 **Logic**

---

```java
// 내 답변
public int[] solution(int[] numbers) {
        nums = numbers;
        int[] answer = {};
        List<Integer> as = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            as.add(dks(k));
        }

        answer = as.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public int dks(int c) {
        for (int i = c; i < nums.length; i++) {
            if (nums[c] < nums[i]) {
                return nums[i];
            }
            if (i == nums.length) {
                return -1;
            }
        }
        return -1;
    }
```

- 일일이 numbers의 모든 배열에 대해 뒤에 있는 배열을 순회하여 뒷큰수를 탐색하게끔 하는 단순한 코드

```java
// 스택을 사용한 풀이
import java.util.Stack;

 class Solution {
     public int[] solution(int[] numbers) {
         Stack<Integer> stack = new Stack<>();
         int[] answer = new int[numbers.length];

         for (int i = 0; i < numbers.length; i++) {
             while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                 answer[stack.pop()] = numbers[i];
             }
             stack.push(i);
         }

         while (!stack.isEmpty()) {
             answer[stack.pop()] = -1;
         }

         return answer;
     }
 }
```

- 스택을 이용해서, 스택에는 인덱스를 저장해두고 조건에 따라 push와 pop을 하여 해당 index에 답을 넣어두고, 마지막에는 남은 곳에 -1을 넣도록 하는 코드.

## ✒️ **Review**

---

- 시간복잡도 때문에 시간 초과가 예상되긴 했으나, 다른 방안이 떠오르지 않아서 이대로 풀이해봤으나, 역시 입력되는 numbers의 길이가 길어지면 시간 초과가 발생하였음.
- gpt를 이용해서 스택을 이용하는 코드를 받아봤는데, 이 문제에서 스택은 아예 생각하지도 못했던 방식이었다.
- 스택을 사용하는 것에 익숙하지 않아서인 것 같긴 하지만, 결국 내 실력 부족이라는 사실에는 다름이 없었다.
- 다양한 자료구조를 사용하는 것에 익숙해질 때까지 알고리즘 학습을 해야겠다고 느꼈다.