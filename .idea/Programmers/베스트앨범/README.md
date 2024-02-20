# 베스트앨범

---

## 📌 **Algorithm**

---

- 해시

## 📍 **Logic**

---

```java
import java.util.*;

class Solution {
    List<Integer> aa = new ArrayList<>(); // 여기다가 답을 일단 넣고 옮길 거임.
    public int[] solution(String[] genres, int[] plays) {
        // 일단 HashMap으로 장르이름, 재생수로 만들어.
        // 그럼 장르 순위가 나옴.
        // 그 다음, 그 장르인 것들 중에서 또 순위를 매겨야 함. 일단 HashMap 만들고 보자.
        HashMap<String, Integer> gr = new HashMap<>(); // 총 재생수를 보기 위함 <장르명, 총 재생수>
        HashMap<String, List<Integer>> gp = new HashMap<>(); // <장르명, <각 재생수>>
        
        for (int i = 0; i < genres.length; i++) { // 일단 집계. gr과 gp로 정리함.
            if (gr.containsKey(genres[i])) { // 집계된 적 있는 거면 업데이트
                gr.replace(genres[i], gr.get(genres[i]) + plays[i]);
                List<Integer> tl = gp.get(genres[i]);
                tl.add(plays[i]);
                gp.replace(genres[i], tl);
            } else { // 첫 집계면 삽입
                gr.put(genres[i], plays[i]);
                List<Integer> tl = new ArrayList<>();
                tl.add(plays[i]);
                gp.put(genres[i], tl);
            }
        }
        
        List<String> gname = new ArrayList<>(); // 여기에는 집계 많은 순서대로 장르명 집어넣으려고 의도함.
        while (!gr.isEmpty()) { // 그래서 gr이 빌 때까지 돌림.
            Set<String> g = gr.keySet(); // 현재 gr에 남은 key set을 받음.
            String mg = ""; // 현재 최대인 장르 저장
            int max = 0; // 최댓값 비교를 위한 장르재생수 저장
            for (String s : g) { // 탐색
                if (max <= gr.get(s)) { // 일단 제일 큰 값을 찾기 위함.
                    max = gr.get(s);
                    mg = s; // 최대값인 당시의 장르명도 파악하기 위함.
                }
            }
            gname.add(mg); // gname에는 넣고, gr에서는 제거하여 다음 탐색 때 안 걸리게 함.
            gr.remove(mg);
        }
        
        for (String gn : gname) {
            List<Integer> tempList = gp.get(gn);
            Collections.sort(tempList);
            Collections.reverse(tempList);
            int index = 0;
            while (true) {
                for (int i = 0; i < plays.length; i++) {
                    if (!genres[i].equals(gn)) {
                        continue;
                    } else {
                        if (plays[i] == tempList.get(index)) {
                            aa.add(i);
                            plays[i] = -1; // 이런 게 없어서 2개의 테스트 케이스에서 틀렸던 거.
                            index++;
                            break;
                        }
                    }
                }
                if (tempList.size() == 1 || index == 2) {
                    break;
                }
            }
        }
        int[] answer = new int[aa.size()];
        int i = 0;
        for (int a : aa) {
            answer[i] = a;
            i++;
        }
        
        return answer;
    }
}
```

- <장르, 총 재생수>인 gr을 생성.
- <장르, <각 재생수>>인 gp를 생성.
- gr과 gp에 대한 집계를 내는 for문을 돌림.
- 집계에 대한 순위대로 gname에 장르명을 순서대로 기록하였음.
- 순위대로 장르명을 돌면서 2곡 이상 있다면 2곡을, 1곡 뿐이라면 1곡을 List인 aa에 저장.
- 이후 List인 aa를 배열인 answer로 옮겨주었음.

## ✒️ **Review**

---

- 이렇게 푸는 게 맞는지는 모르겠지만, 암튼 해시도 잔뜩 썼고,, 답도 맞고,, 맞긴 했다.
- 해시에 더 수월하게 풀 수 있는 메소드가 있을지도 모르겠다. 다 풀고 다른 사람 정답 보니까, 내가 만든 gp보다 나은 구조가 있었다. Map<장르, Map<곡ID, 재생수>> 이렇게 했더라. 이게 더 낫네 생각해보니.
- 암튼 복잡하긴 했어도 어렵진 않은 문제였는데, 테스트 케이스 2번과 15번에서 오답이 나와서 찾느라 고생했다.
- 대체 뭘까 하면서 테스트 케이스 추가해보면서 돌려보다가, 같은 재생 수가 있는 경우에 문제가 발생한다는 것을 찾아냈다.
- 내가 값을 넣고나서 plays에서 재생 수를 그대로 둬서 거기서 두번 곡ID를 빼내고 있었더라.
- 암튼 그것만 해결하고 문제는 해결해냈다.