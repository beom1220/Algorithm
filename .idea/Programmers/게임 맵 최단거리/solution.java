import java.util.*;

class Solution {
    // 상하좌우 이동 시 사용하는 델타 정의
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>(); // bfs 위한 큐 생성
        queue.add(new int[]{0, 0}); // 시작 위치가 될 0,0 추가

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 한 반복 -> 더 이상 탐색할 위치 X
            int[] current = queue.poll(); // 위치 하나 꺼내서 bfs 수행
            for (int i = 0; i < 4; i++) { // 상하좌우 이동 가능 여부 확인
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 맵 범위 벗어나면 무시
                if (maps[nx][ny] == 1) { // 다음 위치에 벽이 없으며 방문한 적 없는지 검사
                    maps[nx][ny] = maps[current[0]][current[1]] + 1;
                    // 시작 위치에서 이동한 위치까지의 거리 +1을 저장
                    queue.add(new int[]{nx, ny}); // 큐에 다시 넣어서 bfs 수행하도록 함.
                }
            }
        }

        return (maps[n - 1][m - 1] == 1) ? -1 : maps[n - 1][m - 1];
        // 목적지에 도착한 적 있으면 1이 아님. 도착한 적 없으면 1이니까 -1 반환.
    }
}
