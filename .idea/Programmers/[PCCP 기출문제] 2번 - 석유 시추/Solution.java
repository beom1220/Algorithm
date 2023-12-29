import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static int[][] landCopy;
    static List<Integer> oil = new ArrayList<>();

    public int solution(int[][] land) {
        int answer = 0;
        landCopy = land;
        n = land.length;
        m = land[0].length;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    oil.add(dfs(i, j));
                }
            }
        }

        int[] oilSum = new int[m];
        for (int j = 0; j < m; j++) {
            HashSet<Integer> uniqueOil = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visited[i][j] != 0) {
                    uniqueOil.add(visited[i][j]);
                }
            }

            for (int oilIndex : uniqueOil) {
                oilSum[j] += oil.get(oilIndex - 1);
            }
        }

        Arrays.sort(oilSum);
        answer = oilSum[m - 1];

        return answer;
    }

    public static int dfs(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        visited[x][y] = oil.size() + 1;
        int cnt = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (landCopy[nx][ny] == 1 && visited[nx][ny] == 0) {
                        stack.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[current[0]][current[1]];
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
