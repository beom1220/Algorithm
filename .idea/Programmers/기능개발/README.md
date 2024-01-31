# 기능 개발

---

## 📌 **Algorithm**

---

- 큐

## 📍 **Logic**

---

```java
Queue<Integer> needs = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int m = 100 - progresses[i];
            int temp = (m / speeds[i]);
            if (m % speeds[i] != 0) {
                temp++;
            }
            needs.add(temp);
        } // 여기까진 needs에 각 필요한 날짜를 저장함. 예: (7일, 3일, 9일)
        
        Queue<Integer> qanswer = new LinkedList<>(); // qanswer는 정답을 넣을 거임. 각 배포마다 기능 수.
        int date = 0; // 기준이 될 날짜
        int cnt = 0; // 배포되는 기능의 개수 카운트
        
        for (int i = 0; i < speeds.length; i++) { // needs만큼 도는 거.
            
            if (date == 0) { // 각 배포의 처음 계산 시.
                date = needs.poll(); // 맨 처음꺼 기준 삼고
                cnt++; // 기능 수 +1
            } else {
                if (date < needs.peek()) {  // date보다 뒤에가 크면 일단 여기서 배포 끝.
                    qanswer.add(cnt);
                    cnt = 1; // 카운트 초기화
                    date = needs.poll();
                } else { // 아니면 더 뽑음.
                    needs.poll();
                    cnt++;
                }
            }
        }
```

- 앞으로 필요한 날짜를 계산해서 needs라는 큐에 먼저 저장해준 다음, 이를 앞에서부터 검사해서 더 큰 수를 만나면 그만두고 qanswer에 cnt를 저장하도록 하였다.

## ✒️ **Review**

---

- 정답은 맞았지만, 생각해보면, 검사를 위한 아래의 for문은 while문으로 사용하는 편이 코드가 더 깔끔했을 것 같다. while로 needs가 isEmpty()가 아닌 동안 반복되게 했으면 코드가 좀 더 가독성도 좋아졌을 것으로 예상된다.
- 엄청 어려운 문제는 아니었지만, queue가 poll 할 수록 size가 줄어든다는 것도 종종 까먹고 for문에서 실수할 때도 있었다.
- 좀 더 자료구조를 자유롭게 다룰 수 있도록 연습이 필요할 것 같다.