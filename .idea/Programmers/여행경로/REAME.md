# 여행경로

---

- 백트래킹을 코드로 해결하지 못해서 검색의 도움을 받아 풀이하였음.

## 📌 **Algorithm**

---

- DFS
- 백트래킹

## 📍 **Logic**

---

```java
class Solution {
    String[] answer;
    boolean[] visited;
    ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            else return o1[0].compareTo(o2[0]);
        });
        list.add("ICN");
        dfs("ICN", tickets, 0);
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    void dfs(String start, String[][] tickets, int count) {
        if(count == tickets.length) {
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                if(list.size() == tickets.length + 1) return;
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
```

- 모든 경로를 찾되, 완성되지 않은 경로에서는 백트래킹을 통해 다시 돌아와서 마지막 경로를 삭제한다.
- 이후 찾은 경로를 알파벳 순으로 정렬시켜 답을 제출한다.

## ✒️ **Review**

---

- 백트래킹 없이 풀었을 때, 논리적 오류를 범해서 틀렸다.
- 단순히 갈 수 있는 목적지를 알파벳 순으로 정렬해서 빠른 알파벳의 목적지로 가는 코드를 짰었다. (아래 코드)

```java
import java.util.*;

 class Solution {
     String[] answer;
     int cnt = 1;
     public String[] solution(String[][] tickets) {
         answer = new String[tickets.length + 1];
         // 주어진 항공권 "모두" 이용하여 여행경로 짜기. 시작은 icn
         // 출발지, 도착지로 이뤄진 티켓 정보들이 들어있음.
         // bfs냐 dfs냐 이거네 일단.
         // 일단 첫번째로 icn이 출발지인 곳을 찾아서, 거기 도착지부터 시작함.
         // 거기 도착지가 출발지인 티켓을 또 찾아야 하고.
         // 가능한 경로가 2개 이상이면 알파벳 순서가 앞서는 경로.
         // 일단 icn이 출발지인 것도 2개 이상일 수 있음.
         // dfs 써도 되는 이유 -> 안 되는 경우가 없으며, 중복에는 알파벳 순서대로 하면 된다는 조건이 있음.
         answer[0] = "ICN";
         dfs("ICN", tickets);

         return answer;
     }

     void dfs(String start, String[][] tickets) {
         // 탈출 조건
         if (cnt == tickets.length + 1) {
             return;
         }

         List<Integer> index = new ArrayList<>(); // 출발지가 일치하는 ticket의 인덱스 번호를 저장.
         for (int i = 0; i < tickets.length; i++) {
             if (tickets[i][0].equals(start)) {
                 index.add(i);
             }
         }

         String check = tickets[index.get(0)][1]; // 알파벳 순 정렬을 위해 도착지 이름을 저장.
         int choice = index.get(0); // 다음으로 사용될 티켓의 인덱스 번호를 저장.
         if (index.size() > 1) { // 도착지 후보가 여럿일 때
             for (int i : index) { // 도착지 후보 모두 돌면서 검사
                 if (tickets[i][1].compareTo(check) < 0) { // 알파벳 순으로 더 앞이면 바꾸기
                     check = tickets[i][1];
                     choice = i;
                 }
             }
         }
         // 최종 선정된 걸로 answer에 추가, 티켓 삭제하고 dfs 돌리기.
         answer[cnt++] = check;
         tickets[choice][0] = "";
         dfs(check, tickets);
     }
 }
```

- 하지만, 예를 들어 "ICN"->"ABC", "ICN"->"DEF", "DEF"->"ICN" 이런 티켓이 입력값으로 들어오면 문제가 생긴다.
- ICN 다음으로 갈 수 있는 두 목적지 중 알파벳 순으로 빠른 ABC를 고르게 되고, 이후 갈 수 있는 곳이 없기 때문에 index.get(0)에서 IndexOutOfBoundsException이 발생하게 되는 것이다.
- 그래서 개념적으로 배웠던 백트래킹을 사용해야 한다는 것은 깨달았지만, 실제로 사용해본 적이 없었기에 직접 구현하는 데 오랜 시간이 들어서 포기하고 검색하여 도움을 받은 후 학습하였다.
- dfs를 재귀로 호출한 다음, 그 뒤에 조건을 하나 둬서 옳게 되었다면 return하게끔 하고, 아니라면 이전의 것을 되돌릴 수 있도록 하면 된다는 것을 알았다. 모든 경로를 탐색해야 하기 때문에 방문 여부를 나타내는 visited와 같은 배열은 거의 필수적으로 필요할 듯 했다.