# 가장 큰 수

---

- 풀이 실패

## 📌 **Algorithm**

---

- 정렬

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int zero = 0;
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i] + "";
            zero += numbers[i];
        }
        
        if (zero == 0) {
            return "0";
        }
        
//         Arrays.sort(arr, Collections.reverseOrder());
        
//         for (int i = 0; i < arr.length - 1; i++) {
//             String tempA = arr[i] + arr[i+1];
//             String tempB = arr[i+1] + arr[i];
//             int ta = Integer.parseInt(tempA);
//             int tb = Integer.parseInt(tempB);
//             if (ta < tb) {
//                 String ti = arr[i];
//                 arr[i] = arr[i+1];
//                 arr[i+1] = ti;
//             }
//         }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1+o2));
        
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}
```

- 입력받은 정수 배열을 문자열 배열로 바꿔서, 두개씩 결합하여 사전 순으로 정렬하는 퀵 정렬을 하고, 이후 더해서 반환한다.
- 모두 0이 들어오는 경우에는 0을 반환한다.

## ✒️ **Review**

---

- 주석 코드가 내가 짰던 코드고, 그 바로 아래에 있는 한 줄의 코드가 정답 코드이다.
- 방식 자체는 천천히 접근하고 있었다. 우선 처음에는 문자열 그대로 냅다 역정렬만 해서 더했었는데, 당장 테스트 코드에서도 되는 것도 있고 안 되는 것도 있었다.
- 뭐가 문제일지 생각해보다가 그 방식을 벗어나는 예외를 발견했다.
- 그래서 고민하다보니 문자열들을 두개씩 더해서 정렬해볼까 싶긴 했지만, 저 코드가 틀린 건 인지하면서 치고 있었던 게, 앞에 비교했던 건 뒤에 있는 항목과는 애초에 비교를 하지 않는다. 문제가 생길 수 밖에 없는 것이다. 버블 정렬로 하려고 코드를 짜보다가, 복잡도를 생각해서 코드를 끝까지 짜지 않았다.
- 그래서 결국 검색의 힘을 빌렸고, compareTo를 사용하게 되었다.
- 퀵 정렬을 비롯한 각종 정렬에 대해 좀 더 학습할 필요성을 절실히 느꼈다.