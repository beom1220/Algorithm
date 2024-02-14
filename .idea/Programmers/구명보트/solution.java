import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        // 구명보트 최대 2명에 무게제한도
        // 구명보트 사용횟수 최소로
        // 순서는 상관없는 듯.
        // 그럼 일단, limit에서 people[n]을 뺀 값이랑 작은 거를 비교해서 가능하면 같이 빼낸다는 느낌. 오케이?
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            p.add(people[i]);
        } // 최대 5만번이니까 문제 없을 듯.

        Collections.sort(p); // 작은 거부터 앞으로 오게끔.
        Collections.reverse(p); // 큰 거부터 앞으로.
        int i = p.size() - 1;
        for (int j = 0; j < p.size(); j++) {
            // 지우는 건 remove 말고 0 저장하자. 사람 무게 40키로 이상이라고 했음.
            if (p.get(j) == 0) {
                continue;
            }
            int remain = limit - p.get(j);
            p.set(j, 0);
            if (p.get(i) <= remain) { // 맨 앞이 젤 큰 거. 맨 뒤가 젤 작은 거니까 이렇게만 검사하면 됨.
                p.set(i, 0);
                i--;
            }
            boat++;
        }

        return boat;
    }
}