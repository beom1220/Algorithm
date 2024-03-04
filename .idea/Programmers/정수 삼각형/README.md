# 정수 삼각형

---

## 📌 **Algorithm**

---

- 동적계획법(다이나믹 프로그래밍)

## 📍 **Logic**

---

```java
class Solution {
    public int solution(int[][] triangle) {
        // 동적이면 일단 단계별로 저장한다.
        // 그럼 그 시점마다의 최대합을 저장하면?
        // 일단 그럼 똑같이 생긴 삼각형을 만들고 채워가?
        int[][] copy = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            copy[i] = new int[triangle[i].length];
        }
        
        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5
        
        copy[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            int len = triangle[i].length;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    copy[i][j] = triangle[i][j] + copy[i-1][j];
                } else if (j == len - 1) {
                    copy[i][j] = triangle[i][j] + copy[i-1][j-1];
                } else {
                    copy[i][j] = Math.max(triangle[i][j] + copy[i-1][j], triangle[i][j] + copy[i-1][j-1]);
                }
            }
        }
        
        int answer = 0;
        int[] bot = copy[triangle.length - 1];
        
        for (int i = 0; i < bot.length; i++) {
            answer = Math.max(answer, bot[i]);
        }
        
        return answer;
    }
}
```

- 똑같은 모양의 배열을 만들어서, 각 위치에서 가능한 최댓값을 저장해가면서 진행했음.
- 맨 앞 줄과 맨 끝 줄은 값이 하나 뿐이기 때문에 index out of bounds를 방지하기 위해 값을 바로 넣어주고, 외에는 Math.max로 더 큰 값이 저장되도록 했음.

## ✒️ **Review**

---

- 동적 계획법 문제를 직접 풀어보니 재밌긴 했다. 근데 매번 이렇게 방법이 떠올라야 할텐데, 이번엔 운이 좋았다.
- 운으로 풀지 않으려면 계속해서 연습해야겠다.