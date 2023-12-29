# 달리기 경주

---

## 📌 **Algorithm**

---

- 배열, 리스트
- 해시맵
- 시뮬레이션

## 📍 **Logic**

---

```java
List<String> ps = new ArrayList<>(Arrays.asList(players));
HashMap<String, Integer> map = new HashMap<>();

for (int i = 0; i < ps.size(); i++) {
    map.put(ps.get(i), i);
}

for (int i = 0; i < callings.length; i++) {
    int now = map.get(callings[i]);
    ps.set(now, ps.get(now-1));
    ps.set(now-1, callings[i]);
    map.put(ps.get(now), now);
    map.put(ps.get(now-1), now-1);
}

answer = ps.toArray(new String[0]);
```

- String[] 형태로 주어진 players를 List형태로 바꾸고, 이를 HashMap형태와 병행하여 사용.
- 조건대로 진행한 뒤, 다시 List 형태를 String[]형태로 변환.

## ✒️ **Review**

---

- 내부적으로 배열과 리스트의 메서드들이 어떻게 동작하는지에 대해서는 잘 몰랐다.
- asList나 toArray는 내부적으로 반복하지 않아서 시간 복잡도가 O(1)이라는 것도 처음 알았고, List에서 사용하는 indexOf 메서드는 해당 value를 가지는 index를 찾기 위해 내부적으로 반복문을 수행한다는 사실도 처음 알았다.
- indexOf로 찾으려고 했었기 때문에 처음에는 시간 초과로 일부 테스트케이스에서 실패했었다가, 해당 부분에 대해 알아본 다음 수정할 수 있었다.
- 평소에 사용하는 메서드들의 내부적인 구조를 알지 못하면 코딩 테스트에서 불리할 수 밖에 없다는 것을 배울 수 있었다.