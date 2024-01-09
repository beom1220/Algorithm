# [PCCP 기출문제] 3번 - 아날로그 시계

---

- 시간을 많이 허비하여 중도 포기하였음.
- 이후 풀이를 참고한 링크 > https://howudong.tistory.com/437

## 📌 **Algorithm**

---

- 수학

## 📍 **Logic**

---

```java
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        // 시작 시간과 끝나는 시간을 초 단위로 변환
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        for (int i = start; i <= end; i++) {
            double hours = (i / 3600 % 12 + (i % 3600) / 3600.0) * 30;
            double minutes = (i % 3600 / 60 + (i % 60)/60.0) * 6;
            double seconds = (i % 60) * 6;

            if ((hours <= seconds && hours > seconds - 6) && (minutes <= seconds && minutes > seconds - 6)) {
                if (Double.compare(hours, minutes) == 0) {
                    answer++;
                } else {
                    answer += 2;
                }
            } else if ((hours <= seconds && hours > seconds - 6) || (minutes <= seconds && minutes > seconds - 6)) {
                answer++;
            }
        }
        return answer;
    }
}
```

- 시간을 초로 변환하여, 초침과 분침/시침의 초마다의 각도를 계산하여, 초침이 분침이나 시침을 지났는지 확인.
- 시침과 분침이 동시에 일치하는 경우에는 1만 증가해야 하기 때문에 예외로 계산하였음.
- 블로그에서 풀이를 보니 빼먹은 부분은, 354도에서 360도로 가는 건 0도로 바뀌는 거라 그 경우의 예외를 처리하지 않았으며, 시작 시간과 동시에 겹치는 것을 고려하지 않았던 것 같았음.

## ✒️ **Review**

---

- 내 나름 생각해서 풀었으나, 생각할 예외가 더 많았다.
- 갈 길이 한참 멀었음을 느꼈던 문제 풀이였다.
- 괜히 너무 오랜 시간 잡고 있는 바람에 시간을 너무 날렸다. 빨리 포기할 줄도 알아야겠다.
- 아직 연습이 많이 필요하다 싶었다.