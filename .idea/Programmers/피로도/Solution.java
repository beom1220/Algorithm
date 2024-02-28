import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer> dc = new ArrayList<>();

    public int solution(int k, int[][] dungeons) {
        // 피로도 사용해서 던전 탐험
        // 최소 필요 피로도, 소모 피로도 (마치면 소모됨)
        // 최대한 많이 탐험하고자 함.

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        return max(dc);
    }

    void dfs(int k, int[][] dungeons, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
        dc.add(cnt);
    }

    int max(List<Integer> dc) {
        int a = 0;
        for (int c : dc) {
            a = Math.max(a, c);
        }
        return a;
    }
}