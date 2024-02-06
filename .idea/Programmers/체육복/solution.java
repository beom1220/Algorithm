import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        List<Integer> losts = new ArrayList<>();
        List<Integer> reserves = new ArrayList<>();
        losts = arrToList(lost);
        reserves = arrToList(reserve);

        for (int num : losts) {
            if (reserves.contains(num)) {
                reserves.remove(reserves.indexOf(num));
                losts.set(losts.indexOf(num), 0);
                answer++;
            }
        }

        for (int num : losts) {
            if (num == 0) {
                continue;
            }
            if (reserves.contains(num-1)) {
                reserves.remove(reserves.indexOf(num-1));
                losts.set(losts.indexOf(num), 0);
                answer++;
            } else if (reserves.contains(num+1)) {
                reserves.remove(reserves.indexOf(num+1));
                losts.set(losts.indexOf(num), 0);
                answer++;
            }
        }

        return answer;
    }

    List<Integer> arrToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list;
    }
}
