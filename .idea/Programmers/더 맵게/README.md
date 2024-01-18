# 더 맵게

---

- 힙 문제 풀이에 대한 학습을 위해, 문법은 찾아보면서 풀이하였음.

## 📌 **Algorithm**

---

- 자료구조
- 힙
- 우선순위 큐

## 📍 **Logic**

---

```java
PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        while(q.peek() < K) {
            if (q.size() >= 2) {
                int min = q.remove();
                int miin = q.remove();
                q.add(min + miin * 2);
                answer++;
            } else {
                return -1;
            }
        }
```

- 우선순위 큐에서 가장 작은 값을 뽑아서, 정해진 로직에 따라 풀이함.

## ✒️ **Review**

---

- 큐의 선언에는 new LinkedList<>();를 사용했었기 때문에, PriorityQueue도 마찬가지인 줄 알았지만, 아니었다.
- 자료구조에 맞는 컬렉션들의 사용법을 익히는 것이 우선이라고 생각해서 하나씩 풀이하고 있는데, 얼마나 무지했는지 조금 파악할 수 있었다.
- 작은 값부터 뽑는 걸 이해한 후에는 큰 값부터 뽑는 것도 궁금해서 알아봤더니, Collections.reverseOrder()를 선언 시 소괄호에 넣으면 된다고 해서 그것도 이번에 학습했다.
- 이번에도 로직 자체는 레벨2 치고는 너무 쉬웠다. 우선순위 큐에 대해 인지하고 있으면 쉽게 풀 수 있는 문제인 것 같다.