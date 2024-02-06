import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; // 방문 검사용
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for(int j = 0; j < n; j++) {
                        if(computers[node][j] == 1 && !visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
