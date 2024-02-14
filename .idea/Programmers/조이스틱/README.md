# 조이스틱

---

- 풀이 실패

## 📌 **Algorithm**

---

- 그리디

## 📍 **Logic**

---

```java
class Solution {
    public int solution(String name) {
        int updown = 0; // 위아래 움직임 수 체크
        int length = name.length();

        int index; // 다음 값 확인에 사용
        int move = length - 1; // 좌우 움직임 수 체크 

        for(int i = 0; i < name.length(); i++){
            updown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); // 어차피 A면 0 나옴.

            index = i + 1; // 다음 알파벳 미리 확인용
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i + length - index + Math.min(i, length - index));
        }
        return updown + move;
    }
}
```

- 연속되는 A의 개수를 파악하고, 그게 끝나는 지점까지 정방향으로 가거나 역방향으로 이동하는 것 중에 빠른 것을 계산하는 move와, 각 문자에 대해 위 아래로 이동하는 횟수를 계산하는 updown을 구해서 더한 값을 반환.

## ✒️ **Review**

---

- 일단 내 코드는 아래와 같았다.

```jsx
class Solution {
    int answer;
    char[] names;
    public int solution(String name) {
        names = name.toCharArray();
        boolean[] check = new boolean[names.length];
        answer = 0;
        int c = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == 65) {
                check[i] = true;
                c++;
            }
        }
        int index = 0;
        while (true) {
            // 1. 탈출 조건
            if (c == check.length) {
                break;
            }

            // 2. 수행 동작
            if (!check[index]) { // A 아닌 곳이면
                char now = names[index];
                if (now >= 'O') {
                    answer += 'Z' - now + 1;
                } else {
                    answer += now - 'A';
                }
                check[index] = true;
                c++;
            }
            index = next(check, index);
        }

        return answer;
    }

    int next(boolean[] check, int index) {
        int left = 0;
        int right = 0;
        while (true) { // 오른쪽 먼저 확인
            if ((index + right == check.length - 1) && check[index+right]) { // 시작이 맨 오른쪽이면 바로 오른쪽 검사 없이 끝.
                right = 0;
                break;
            }
            if(!check[index + right]) { // 이동한 곳이 검사된 곳인지 검사.
                break;
            } else {
                right++;
            }
        }

        while (true) { // 왼쪽 확인
            if (index - left == 0 && check[index-left]) {
                left = 0;
                break;
            }
            if (!check[index - left]) {
                break;
            } else {
                left++;
            }
        }

        if (left == 0 || left >= right) { // 맨 왼쪽이거나, 왼쪽이 오른쪽보다 멀어서 "오른쪽"으로 갈 때
            // 근데 또 반대 방향으로 가야 될 수도 있잖어.
            if (right > names.length / 2) {
                answer += names.length - right;
            } else {
                answer += right;
            }
            return index + right;
        } else if (right == 0 || right > left) { // "왼쪽"으로 갈 때
            if (left > names.length / 2) {
                answer += names.length - left;
            } else {
                answer += left;
            }
            return index - left;
        }
        return 0;
    }
}
```

- 결과는 턱도 없이 48.1점이 나왔다.
- 위아래 계산은 쉬우니까 빼두고, 좌우 이동에 대한 로직이 당연히 문제가 있는 거였는데, 아무리 생각해봐도 모르겠더라.
- 내 방식에서는 좌우 이동할 때, 매번 다음으로 갈 곳을 찾았다. 현재 위치에서 가장 가까운 ‘아직 완성되지 않은 곳’의 위치를 확인하고 정방향으로 갈지 역방향으로 갈지 정했었다.
- 이 로직에서의 예외는 생각이 안 나서 결국 더 이상 풀이하지 못하고 답을 찾게 되었다.
- 근데 답을 봐도 바로 이해가 되질 않았다. 아래는 참고한 블로그이다.

[[프로그래머스] 조이스틱_JAVA](https://born2bedeveloper.tistory.com/26#google_vignette)

- 자꾸 난 매번 이동 횟수를 누적해서 더해야 한다고 생각하고 있는데, 찾아보는 답에서는 항상 좌우 이동 횟수의 Math.min으로 갱신하는 부분이 이해가 안 됐다.