# 체육복

---

## 📌 **Algorithm**

---

- 그리디 알고리즘

## 📍 **Logic**

---

```java
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();
        losts = arrToList(lost);
        reserves = arrToList(reserve);
        
        for (int num : losts) {
            if (reserves.contains(num)) {
                reserves.remove(reserves.indexOf(num));
                losts.set(losts.indexOf(num), 0);
                answer++;
            }
        }
        
        for (int num : losts) {
            if (num == 0) {
                continue;
            }
            if (reserves.contains(num-1)) {
                reserves.remove(reserves.indexOf(num-1));
                losts.set(losts.indexOf(num), 0);
                answer++;
            } else if (reserves.contains(num+1)) {
                reserves.remove(reserves.indexOf(num+1));
                losts.set(losts.indexOf(num), 0);
                answer++;
            }
        }
        
        return answer;
    }
    
    List<Integer> arrToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list;
    }
}
```

- 먼저 체육복을 잃어버린 본인이 여벌을 가졌는지 검사하고, 이후에 잃어버린 체육복 주인의 이전 번호와 다음 번호 순으로 여벌 체육복을 가졌는지 검사해서 체육복을 빌린다.

## ✒️ **Review**

---

- 문제가 어렵지는 않았는데 자꾸 테스트 케이스 30개 중에 2~3개씩 틀렸다.
- 찾느라 한참이 걸렸는데, sort를 안 해줘서 생긴 문제였다.
- 정렬을 안 하면, 규칙대로 진행하는 것에 문제가 생기는 듯 했다.
- 무조건 순서대로 진행하며 앞 번호부터 차지하는 규칙에서, 순서대로 진행하는 부분이 꼬이니 문제가 생길지도 모른다는 생각이었는데, 다행히 그게 맞았다.