# 없어진 기록 찾기

---

## 📌 **Algorithm**

---

- SQL - JOIN

## 📍 **Logic**

---

```sql
SELECT o.animal_id, o.name from animal_outs o left join animal_ins i
on o.animal_id = i.animal_id
where i.animal_id is NULL;
```

- left join을 이용하여 누락된 정보가 있는 행을 출력하는 코드

## ✒️ **Review**

---

- NULL을 찾을 때 is를 사용해야 한다는 것을 잊었다. 그래서 = null로 적어두고 풀고 있었더니 자꾸 where절 앞까지는 맞는데 결과가 안 나와서 시간을 허비했다.
- 혹시나 내부적인 연산에서 발생한 문제일까봐 다르게도 풀이했었다.

```sql
SELECT id, name from (
select o.animal_id id, o.name name, i.animal_id nid
from animal_outs o left join animal_ins i
on o.animal_id = i.animal_id
) sub
where nid is NULL
;
```

- 물론 여기서도 is null을 몰라서 해맸다. 심지어 서브 쿼리를 사용할 때 소괄호 대신 중괄호를 사용해서 오류가 발생했었다. 또한 서브 쿼리에는 반드시 alias를 작성해줘야 한다는 것도 잊어서 오히려 더 해맸었다.
- 그러다 결국 null을 is null로 작성하고나서야 다시 원래 코드로 돌아가서 바로 풀이할 수 있었고, 위의 코드도 그와 같이 수정했다.
- 기초적인 SQL 문법을 많이 까먹은 것 같아서 쿼리 문제도 꾸준히 풀이하면서 복습해야겠다는 생각을 했다.