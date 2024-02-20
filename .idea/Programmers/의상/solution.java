import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 해시맵으로, 각 종류를 키로 삼아서 밸류에다가 개수를 정수로 저장.
        // 그럼 이제 모든 value를 받아서 Set으로 함.
        // 그러고 각 value에 +1을 한 값끼리 곱함.
        // 거기서 1을 빼면 끝이지 않나.

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String[] c = clothes[i];
            if (hm.containsKey(c[1])) {
                hm.replace(c[1], hm.get(c[1]) + 1);
            } else {
                hm.put(c[1], 1);
            }
        }
        Set<String> s = hm.keySet();
        int answer = 1;
        for (String ss : s) {
            answer *= (hm.get(ss) + 1);
        }
        return answer - 1;
    }
}