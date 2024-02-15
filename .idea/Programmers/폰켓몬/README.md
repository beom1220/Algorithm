# 폰켓몬

---

## 📌 **Algorithm**

---

- 해시 셋

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> nn = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            nn.add(nums[k]);
        }
        return Math.min(nn.size(), nums.length / 2);
    }
}
```

- nn에는 중복없는 폰켓몬이 들어가기 때문에, size는 종류의 수와 같다.
- 종류의 수가 더 적으면 종류의 수를, 데려갈 수 있는 수가 더 적으면 그 수를 반환해주면 된다.

## ✒️ **Review**

---

- 레벨1이라지만 이렇게 쉬워도 되나 싶었다.
- 뭔가 내가 생각 못한 반례가 있겠거니 했다.
- 아니었다.
- 쉬운 거였다.