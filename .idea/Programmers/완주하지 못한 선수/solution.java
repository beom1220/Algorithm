import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                hm.replace(participant[i], hm.get(participant[i]) + 1);
            } else {
                hm.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (hm.get(completion[i]) == 1) {
                hm.remove(completion[i]);
            } else {
                hm.replace(completion[i], hm.get(completion[i]) - 1);
            }
        }

        Set<String> s = hm.keySet();
        for (String ss : s) {
            answer = ss;
        }
        return answer;
    }
}

// 시간 초과발생하는 코드. 해시 써서 다시 풀었음.
//import java.util.*;
//
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        List<String> l = new ArrayList<>();
//        for (int i = 0; i < participant.length; i++) {
//            l.add(participant[i]);
//        }
//        for (int i = 0; i < completion.length; i++) {
//            l.remove(completion[i]);
//        }
//        answer = l.get(0);
//        return answer;
//    }
//}