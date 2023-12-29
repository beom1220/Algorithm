import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        List<String> ps = new ArrayList<>(Arrays.asList(players));
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < ps.size(); i++) {
            map.put(ps.get(i), i);
        }

        for (int i = 0; i < callings.length; i++) {
            int now = map.get(callings[i]);
            ps.set(now, ps.get(now-1));
            ps.set(now-1, callings[i]);
            map.put(ps.get(now), now);
            map.put(ps.get(now-1), now-1);
        }

        answer = ps.toArray(new String[0]);

        return answer;
    }
}
