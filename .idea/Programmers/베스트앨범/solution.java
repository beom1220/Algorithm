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