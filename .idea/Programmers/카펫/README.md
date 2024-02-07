# 카펫

---

## 📌 **Algorithm**

---

- 완전탐색

## 📍 **Logic**

---

```java
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 일단 brown과 yellow를 더한 값이 총 넓이. 편의상 area라 하겠다.
        // area의 sqrt 전까지 반복하면서 area를 나누어, 곱할 수 있는 쌍을 찾는다.
        // 쌍의 각 값에서 2을 빼서 곱했을 때 yellow와 같은 값이 나오면 된다.
        // 그럼 그 값이 바로 가로, 세로 값이 된다. (가로가 더 큰 값)
        int area = brown + yellow;
        int limit = (int) Math.sqrt(area);
        for (int i = 3; i <= limit; i++) {
            if (area % i == 0) {
                int garo = area / i;
                int sero = i;
                if ((garo - 2) * (sero - 2) == yellow) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                }
            }
        }
        return answer;
    }
}
```

- 총 넓이를 구해서 정수의 곱으로 넓이가 나올 수 있는 쌍을 구한다. (단, yellow는 총 넓이에서 테두리를 뺀 내부에 존재해야 하기 때문에 가로와 세로는 최소 3 이상이어야 함.)
- 중복되는 값을 포함하지 않기 위해 넓이의 루트값 이하에서 쌍을 찾는다.
- 구해진 쌍 중에서, 가로와 세로에 각 2를 빼서 곱했을 때 yellow와 같은 값이 나오면 그때의 가로, 세로 값이 정답이 된다.

## ✒️ **Review**

---

- 완전탐색 문제라 겁을 먹고 들어왔는데 생각보다 쉬운 수학 문제여서 어렵지 않게 풀 수 있었다.