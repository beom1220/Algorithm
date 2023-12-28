# [PCCP 기출문제] 1번 - 붕대감기

---

## 📌 **Algorithm**

---

- 그리디 알고리즘
- 시뮬레이션

## 📍 **Logic**

---

```java
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health; // 현재 체력에 최대 체력을 저장.
        for (int i = 0; i < attacks.length; i++) { // 준비된 공격만큼 반복.
            int nowAtk = attacks[i][0]; // 현재 공격 시간을 저장
            answer -= attacks[i][1]; // 현재 공격만큼 체력이 닳음.
            if (answer <= 0) { // 죽었는지 확인
                return -1; // 죽었으면 -1 반환하여 끝냄.
            }
            if (i + 1 < attacks.length) { // 다음 공격이 있다면
                int nextAtk = attacks[i+1][0]; // 다음 공격 시간을 저장.
                int term = nextAtk - nowAtk - 1;
								// 현재 공격과 다음 공격의 시간의 차이를 계산.
                if (term >= bandage[0]) { // 차이가 붕대 시간보다 길면
                    for (int j = 0; j < term / bandage[0]; j++) {
                        answer += bandage[0] * bandage[1] + bandage[2];
                    }
                    // **틀린 부분 발견**
										// 보너스 체력을 주는 식이었는데, 2번 이상 될 때가 있구나.
                } else {
                    answer += term * bandage[1];
										// 차이가 붕대 시간보다 짧으면 그냥 시간만큼 회복
                }
                if (answer > health) {
                    answer = health; // 최대 체력 넘으면 최대 체력으로 바꿈.
                }
            }
        }
        return answer;
    }
}
```

- 문제를 읽어본 후, 공격 시간 사이마다의 남는 시간에 회복을 할 수 있는 것으로 판단했다.
- 남는 시간과 붕대 감기 시전 시간을 비교하면서 코드를 진행시켰다.

## ✒️ **Review**

---

- 맨 처음에는 문제에서 주어진 텍스트 그대로 코드를 짜려고 했다. 그러다 문제를 보니 그렇게 짤 필요가 없을 것 같았다.
- 전체적인 코드를 짜는 것은 그렇게 오래 걸리지 않았지만, 처음 제출했을 때는 대부분의 테스트 케이스에서 통과됐지만 3개 정도의 테스트 케이스에서 실패하였다.
- 실패한 원인을 찾기 위해 내가 짠 코드마다 기능에 대한 해설을 적다보니 문제점을 발견했다.
- 붕대 시전을 끝까지 성공하면 보너스 체력이 주어지는데, 그것이 한번의 텀 안에 2번도 가능하다는 사실을 간과하고 있었다.
- 해당 부분을 수정하고나니 바로 통과되었다.