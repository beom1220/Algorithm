# K번째 수

---

## 📌 **Algorithm**

---

- 정렬

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i부터 j까지 자름. 정렬함. k번째 수를 찾음.
        
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int[] temp = new int[end - start + 1];
            int k = 0;
            for (int j = start - 1; j < end; j++) {
                temp[k] = array[j];
                k++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        
        return answer;
    }
}
```

- 주어진 array를 commands마다의 시작~끝으로 잘라내고 sort하여 지정된 번째의 수를 answer에 넣어주었다.

## ✒️ **Review**

---

- 정렬의 1단계 문제라 그런지 어려움없이 풀었다.