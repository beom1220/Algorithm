import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 답이 정해져있고, 1~3번이 다 찍는다.
        // 1번은 1 2 3 4 5 반복
        // 2번은 21 23 24 25 반복
        // 3번은 33 11 22 44 55 반복
        // 대충 바로 생각나는 거는 answers 길이만큼 하는 거? 그럼 일단 그만큼 답을 채우고? 아니다. 그냥 각각 10씩 맞추자.
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int sone = 0;
        int stwo = 0;
        int sthr = 0;
        for (int i = 0; i < answers.length; i++) {
            int none = i % 5;
            int ntwo = i % 8;
            int nthr = i % 10;
            int a = answers[i];
            if (a == one[none]) {
                sone++;
            }
            if (a == two[ntwo]) {
                stwo++;
            }
            if (a == three[nthr]) {
                sthr++;
            }
        }
        int max = Math.max(sone, Math.max(stwo, sthr));
        List<Integer> p = new ArrayList<>();
        if (max == sone) {
            p.add(1);
        }
        if (max == stwo) {
            p.add(2);
        }
        if (max == sthr) {
            p.add(3);
        }

        int[] answer = new int[p.size()];
        for (int i = 0; i < p.size(); i++) {
            answer[i] = p.get(i);
        }

        return answer;
    }
}