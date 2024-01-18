# 다리를 지나는 트럭

---

- 큐 이용 방법 학습을 위해, 문법은 찾아보면서 풀이하였음.

## 📌 **Algorithm**

---

- 자료구조
- 큐

## 📍 **Logic**

---

```java
Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                if(q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    sum -= q.remove();
                } else {
                    if (sum + truck <= weight) {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }

        }

        time += bridge_length;
```

- 다리에 총 무게와 길이, 큐의 길이를 비교하면서 트럭을 보내면서 시간을 추가함. 자리는 있는데 총 무게가 부족한 경우에는 0을 추가한다.

## ✒️ **Review**

---

- 큐를 선언하는 방법도 몰랐었다. new Queue<>();로 했더니 바로 터지길래 학습을 위해 큐 관련 문법을 검색한 다음 풀이하였다.
- 레벨2 문제 치고 알고리즘 자체가 어려운 것은 없었다.