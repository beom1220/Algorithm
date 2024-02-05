# 타겟넘버

---

- 검색하여 도움을 받아 풀이

## 📌 **Algorithm**

---

- DFS (깊이 우선 탐색)

## 📍 **Logic**

---

```java
class Solution {
    int[] numbers;
    int target;
    int answer;
    
    void dfs (int index, int sum) {
        // 1. 탈출 조건
        if (index == numbers.length){
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        // 2. 수행 동작 (먼저 코딩)
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0);
        
        return answer;
    }
}
```

- dfs를 통해, 다음 인덱스에 해당 하는 숫자를 더하는 것과 빼는 것을 모두 호출하여 모든 경우의 수를 검사하여 결과에 도달.

## ✒️ **Review**

---

- dfs를 학습한 적이 있었지만, 다시 만나니 막상 막막했다. 그래서 dfs를 사용하는 문제에 대한 풀이 방식을 검색하여 도움을 받아 풀이하였다.
- DFS를 이해하고는 있어도 실전에서 잘 사용하려면 더 훈련이 많이 필요할 것 같다고 느꼈다.