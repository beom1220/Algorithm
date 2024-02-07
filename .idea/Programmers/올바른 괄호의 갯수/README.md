# 올바른 괄호의 갯수

---

## 📌 **Algorithm**

---

- 완전 탐색

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    
    class Group { // 조합과 열린괄호, 닫힌괄호 개수를 저장.
        String s; // 현재 조합
        int o; // 열린괄호 수
        int c; // 닫힌괄호 수
        Group(String s, int o, int c) {
            this.s = s;
            this.o = o;
            this.c = c;
        }
    }
    
    public int solution(int n) {
        int answer = 0;
        
        Stack<Group> st = new Stack<>(); // 조합을 저장할 스택
        st.push(new Group("",0,0)); // 일단 빈 거 넣어서
        
        while (!st.isEmpty()){ // 스택 빌 때까지 반복
            Group now = st.pop(); // 일단 팝
            if (now.o == n && now.c == n) { // 열린 괄호와 닫힌 괄호 수가 같다는 건 완성이라는 거.
                answer++;
            }
            if (now.o < n) { // 열린 괄호 수가 n보다 작으면 열린 괄호는 아무 때나 넣어도 됨.
                st.push(new Group(now.s+"(", now.o+1, now.c));
            }
            if (now.c < now.o) { // 닫힌 괄호 수가 열린 괄호 수보다 작으면 닫힌 괄호는 아무 때나 넣어도 됨.
                st.push(new Group(now.s+")", now.o, now.c+1));
            }
        }
        
        return answer;
    }
}
```

- 열린 괄호와 닫힌 괄호의 수를 비교하면서 가능한 조합을 만들어가고, answer에 1씩 더해가면서 가능한 조합의 개수를 반환하도록 한다.
- 스택을 이용한 DFS 형태로 풀이하였지만, 큐를 이용한 BFS 형태로도 풀이할 수 있음.

## ✒️ **Review**

---

- 처음에는 무식하게 정말 가능한 모든 조합을 만들어서 모두 스택을 통한 괄호 검사를 해야하는 문제인가 했다. 하지만 가능한 최대 조합은 대충 계산해봐도 28! / (14!)^2 이라 2억 4천개가 넘는다. 이는 분명 효율성 관련된 문제를 야기할 것이었다.
- 그래서 뭔가 다른 규칙이 있을까 싶어 검색을 잠시 했는데, 카탈란 수라는 규칙이 있었다. 피보나치처럼 일종의 재귀를 통한 식이었는데, 이를 모르면 못 푸는 문제인 줄 알고 포기하려 했다.
- 하지만 동기들에게 물어보니, 카탈란 수의 존재를 모르고도 풀었다고 하길래, 다시 풀이를 시작했다.
- 일단 가능한 조합만을 뽑아내야 했다. 모든 조합을 만드는 건 확실히 효율성 문제가 발생할 것 같았기 때문이었다.
- 열린 괄호와 닫힌 괄호를 선택할 수 있는 경우를 따져보다 보니 규칙이 보였다.
- 열린 괄호는 주어진 괄호 쌍의 수만큼 사용할 때까지 언제나 들어와도 되고, 닫힌 괄호는 열린 괄호보다 그 수가 적을 때 언제나 들어와도 된다. 이에 위배되는 사항을 찾아보려 했으나 도저히 없었다.
- 이를 코드로 구현하기 위해 고민을 해봤는데, 일단 가장 먼저 생각난 방법은 가장 직관적으로 클래스에다가 현재 값과 열린 괄호, 닫힌 괄호의 수를 저장하는 것이었다. 더 나은 방법도 분명 있을 것 같지만, 일단 이 방법이 가장 먼저 생각났다.
- 그래서 일단 스택을 만들어서 거기다가 현재 상태를 넣고, while문을 통해서 완성되지 않은 건 빼서 가능한 모든 경우의 수로 진행되게끔 코드를 짰다. 짜고 보니 큐로 해야하나 싶었지만, 스택으로도 문제가 없었다.
- 다 풀어본 후 더 나은 코드를 찾아보다가 아래와 같은 코드를 발견했다.

```java
    int count;
    
    public int solution(int n) {
        count = 0;
        
        dfs(0, 0, n);
        return count;
    }
    
    public void dfs(int left, int right, int n) {
        if(left < right) return;
        if(left == n && right == n) {
            count++;
            return;
        }
        
        if(left > n || right > n) return;
        
        dfs(left + 1, right, n);
        dfs(left, right + 1, n);
    }

출처: https://tosuccess.tistory.com/173 [EI_HJ:티스토리]
```

- 내가 구상한 코드를 다듬으면 이런 모습일 것 같았다.
- 그리고 카탈란 수를 이용한 코드는 아래와 같다고 한다.

```java
public int solution(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i] += dp[i-j] * dp[j-1];
        }
    }

    return dp[n];
}

출처: https://deftkang.tistory.com/222 [deftkang의 IT 블로그:티스토리]
```

- 이 코드는 점화식을 이용한 풀이다보니 풀이가 직관적이진 않다.