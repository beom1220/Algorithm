# 큰 수 만들기

---

- 하나의 케이스에서 시간 초과

## 📌 **Algorithm**

---

- 그리디
- 스택

## 📍 **Logic**

---

```java
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
```

- 위는 시간 초과로 인해 스택을 이용하여 수정한 정답 (생성형 AI의 도움을 받음)
- 아래는 기존의 풀이 코드

```jsx
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number); // 불변인 String 대신 사용해야 함.
        
        for(int i = 0; i < sb.length()-1; i++) {
            if(k == 0) break;
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i = -1; // i가 0부터 시작하므로, 다음 루프에선 0부터 시작하게 하기 위해 -1로 설정
                k--;
            }
        }
        
        // 아직 k개를 다 제거하지 못한 경우, 뒤에서부터 제거
        if(k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }
        
        return sb.toString();
    }
}
```

- 앞자리와 다음 자리 숫자를 비교하여 더 크면 deleteCharAt을 통해 삭제하며, 다시 처음부터 검사한다.
- i - -로 1만 감소시키고 검사하는 방법을 처음에는 택했었으나, 반례가 있다는 것을 알아서 다시 처음부터 검사시키는 것으로 수정했음. 하지만 이것 때문에 하나의 케이스에서 시간 초과가 발생하였음. ⇒ 100만 자리수를 모두 이용하면서, 초반의 자리수에서는 모두 앞자리보다 뒷자리가 크거나 같으면 반복 횟수가 급증하게 됨.
- 그래서 이를 해결하기 위해 스택을 이용했음.

## ✒️ **Review**

---

- 우선 StringBuilder와 String에 대해 개념적으로는 학습했던 경험이 있었지만, 실사용을 해본 적이 없어서 이 부분부터 한번 해맸었다. 결국 검색찬스를 사용해서 그 부분은 넘겼지만, 결론적으로 시간 초과가 나서 풀이에 실패했다.
- 그럼 그냥 스택을 쓰면 되는 간단한 건데 생각을 왜 못했는지 한심스럽긴 한데, 암튼 결과적으로 못 푼 건 못 푼 거다. 변명 아닌 변명을 하자면, 탐욕법 문제라는 것에 너무 몰두해서 스택을 생각 못한 것 같긴 하다. 암튼 경험이 쌓여야 실력이 느는 거니까..