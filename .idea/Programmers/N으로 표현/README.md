# N으로 표현

---

- 접근법을 고민하다 모르겠어서 접근법을 찾아보고 풀었음에도 풀이 실패

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/b6256b1f-9c69-4681-9853-e650325f4013/0fe82bba-3ccd-48f2-b798-8a61fcd9d9db/Untitled.png)

## 📌 **Algorithm**

---

- 동적계획법(다이나믹 프로그래밍)

## 📍 **Logic**

---

```java
// 길을 못잡아서 30분 지난 후 방향 잡기 위한 풀이 참고를 하였음.
// 그럼에도 정답 실패 -> 사소한 실수였음. 아래 표시함.
import java.util.*;

class Solution {
    // 일단 대문자 쓰기 귀찮으니까 임의로 파라미터 소문자로 바꿈.
    
    List<HashSet<Integer>> ll = new ArrayList<>(); // n의개수가 인덱스, 나올 수 있는 값들이 뒤에 값.
    int nn;
    public int solution(int n, int number) {
        nn = n;
        // N만을 이용해서 사칙연산으로 number를 표현한다.
        // 최소 사용횟수를 반환하라.
        
        // n을 1개부터 number-1개까지 쓰는 모든 경우를 따지면서 나올 수 있는 수를 저장한다? 아니 답 나오면 멈춤이니까 while
        
        HashSet<Integer> z = new HashSet<>();
        ll.add(z); // 0번 인덱스는 안 쓸 거라서
        z.add(n); // 1번 인덱스에는 n 본인 밖에 못 들어감.
        
        if (n == number) { // 근데 number 자체가 n이면 그냥 끝내도 됨.
            return 1;
        }
        ll.add(z); // 1번 인덱스는 채우고 들어감.
        
        int i = 2;
        while (true) { // number가 나올 때까지 반복할 거임.
            HashSet<Integer> now = new HashSet<>(); // 2개부터. n 사용횟수에 따라 하나의 리스트에 저장함. 중복없어야함. HashSet으로 바꾸자.
            
            // 4개로 조합한다고 하면, 3개+1개도 있지만, 2개+2개도 있을 거란 말이야.
            // j가 1부터 i/2까지 반복하면서 j번째 리스트랑 i-j번째 리스트로 조합을 해서 중복없이 더하는 식으로.
            
            for (int j = 1; j <= i/2; j++) {
                HashSet<Integer> il = ll.get(j);
                HashSet<Integer> jl = ll.get(i-j);
                for (int ii : il) {
                    for (int jj : jl) {
                        now.add(ii+jj);
                        now.add(Math.abs(ii-jj));
                        if (jj != 0) {
                            now.add(ii/jj);    
                        }
                        if (ii != 0) {
                            now.add(jj/ii);    
                        }
                        
                        now.add(ii*jj);
                        now.add(nnn(i));
                        
                        if (now.contains(number)) {
                            return i;
                        }
                    }
                }
                //ll.add(now); 여기서 add하는 게 아니라, 내부 for문 모두 끝난 곳에서 해야.
								// 생각은 그렇게 했었는데, 그냥 잘못 보고 여기 해놓고 못 찾은 거임.
            }
						ll.add(now); // 여기로 옮김. 그렇게 하면 맞게 됨.
            
            i++;
            if (i == 9) {
                return -1;
            }
        }
    }
    
    int nnn(int i) {
        int num = 0;
        for (int j = 0; j < i; j++) {
            num += Math.pow(10, j) * nn;
        }
        return num;
    }
}
```

- **내 풀이**
    - 일단 List를 만들어서, 그 인덱스는 사용한 n의 개수이고, 값은 HashSet으로 그 개수의 n으로 만들 수 있는 수들을 저장하고자 했음.
    - n을 i개로 만들 수 있는 수의 조합은 다음과 같다고 생각했음.
    - 예) n을 4개 써서 만들 수 있는 조합 → 1개를 써서 가능한 조합과 3개를 써서 가능한 조합으로 사칙연산하기 + 2개로 가능한 조합과 2개로 가능한 조합으로 사칙연산하기 + nnnn과 같은 반복되는 숫자
    - 그래서 가능한 조합을 모두 뽑아내서 now라는 HashSet에 중복없이 저장하고, 이를 해당 인덱스와 매칭되는 List에 저장하였음.
    - 그러다가, 그 값이 number와 같다면 당시의 i를 반환하였고, 8보다 커지면 -1을 반환하였음.
    - 그보다 전에, number 자체가 n과 같을 수 있기 때문에 먼저 이를 검사하여 1을 반환하도록 함.

## ✒️ **Review**

---

- 왜 틀렸는지 확인하고 오니 열불만 더 났다.
- 일단 동적 계획법 자체가 어려워서 애초에 접근법을 검색했기 때문에 어차피 정답이라도 정답 취급할 수는 없지만, 그래도 이후 풀이는 모두 맞았는데 이상한 실수를 해서 결론적으로 못 맞췄다.
- 동적 계획법은 개념을 알고 있다고 그냥 쉽게 풀 수 있는 문제가 아니라는 걸 확실히 깨달았다.