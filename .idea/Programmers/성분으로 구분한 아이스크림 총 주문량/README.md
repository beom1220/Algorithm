# 성분으로 구분한 아이스크림 총 주문량

---

## 📌 **Algorithm**

---

- SQL - GROUP BY

## 📍 **Logic**

---

```sql
SELECT i.ingredient_type,
sum(f.total_order)
as total_order from icecream_info i
join first_half f on i.flavor = f.flavor
group by i.ingredient_type
```

- 각 테이블을 조인하여 그룹화하여 값을 집계하는 코드

## ✒️ **Review**

---

- 레벨1에서 풀이한 문제와 같은 테이블을 사용하는 문제가 있길래 이어서 풀이했다.
- 레벨2의 SQL 문제는 조금 어려울 줄 알았는데 꽤 쉬웠다. 이어서 레벨3까지 풀이해보고자 한다.