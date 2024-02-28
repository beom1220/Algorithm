# 소수 찾기

---

- 풀이 실패. 순열과 조합을 구현하지 못했음.

## 📌 **Algorithm**

---

- 완전탐색
- 백트래킹
- DFS (깊이 우선 탐색)

## 📍 **Logic**

---

```java
import java.util.HashSet;
import java.util.Set;
 
public class Solution {
    static Set<Integer> set;
    static boolean[] visited = new boolean[7]; // numbers는 길이 1 이상 7 이하인 문자열
 
    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);
 
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
 
    public static void dfs(String numbers, String s, int depth) {
		// numbers 의 끝까지 다 탐색했다면 종료
        if (depth > numbers.length()) {
            return;
        }
 
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
 
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }
}
```

- dfs를 통해 조합할 수 있는 수들을 조합함.
- 중복 없이 저장하기 위해 HashSet에 저장.
- set에 저장된 수들을 모두 소수 검사를 거침.

## ✒️ **Review**

---

- 아직도 DFS 이용에 익숙하지 않은 것 같다. 한창 DFS를 학습할 때는 나름 익숙해졌다고 생각했지만, 다른 문제에서 사용해야 하는 경우가 나오면 이를 눈치채지 못하고 이렇게 또 해맸다.