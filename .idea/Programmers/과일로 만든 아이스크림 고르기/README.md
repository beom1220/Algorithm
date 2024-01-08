# 과일로 만든 아이스크림 고르기

---

## 📌 **Algorithm**

---

- SQL - SELECT

## 📍 **Logic**

---

```sql
SELECT f.flavor from first_half f join icecream_info i on f.flavor = i.flavor
where f.total_order > 3000 and i.ingredient_type = 'fruit_based'
order by total_order desc;
```

- 각 테이블을 조인하여 조건에 맞는 맛을 출력하는 쿼리문

## ✒️ **Review**

---

- 프로그래머스에는 쿼리 문제도 있길래 레벨2를 풀어보려다가 먼저 몸풀기로 풀어봤던 레벨1 문제였다.
- 처음 입력한 답이 정답이었는데, 프로그래머스 자체의 시스템을 제대로 몰랐어서 옆에 주어진 예시에 나온 답과 테스트 코드에서 출력되는 값이 다르길래 틀린 줄 알고 어디서 틀렸나 찾느라 5분 정도 시간을 보냈다.
- 테이블을 전체 출력해보고나서야 예시랑 다른 테이블이라는 걸 알아서 제출하여 문제를 마쳤다. 이후 쿼리에서 레벨2 문제를 풀이하고자 한다.