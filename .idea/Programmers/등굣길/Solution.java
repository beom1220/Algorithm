class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 수학 시간에 많이 했던 거네.
        // 일단 각 지점까지의 최소값을 저장.
        // 합치고.
        // 물 있는 곳은 -1로 저장하고, 가로 세로 해서 각각 일단 0 박고. 검사해 나가면서 이케저케....
        // 몰라 일단 시작을 해보면.
        // 집에서 바로 좌우는 항상 1. 물만 없으면.
        // 일단 왼쪽 위에서부터 채워나가면 될 거 같긴 함.

        int[][] road = new int[n][m]; // 길을 저장할 거임. 일단 전부 0이 들어갔을 거임.
        // [0, 1, 0, 0]
        // [1, -, 0, 0]
        // [0, 0, 0, 0] * 물이 (x,y)라고 하면 실제로는 [y-1][x-1]임.
        for (int i = 0; i < puddles.length; i++) {
            int[] water = puddles[i];
            int wm = water[0] - 1;
            int wn = water[1] - 1;
            road[wn][wm] = -1; // 물 있는 곳은 전부 -1로 채움.
        }
        // 옆라인과 아랫라인은 물웅덩이 없는 한, 1로 먼저 채우고 감.
        for (int i = 1; i < road[0].length; i++) {
            if (road[0][i] != -1) {
                road[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < road.length; i++) {
            if (road[i][0] != -1) {
                road[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < road.length; i++) { // 같은 n부터 도는 거임.
            for (int j = 1; j < road[i].length; j++) {
                if (road[i][j] != -1) {
                    int down = 0;
                    int right = 0;
                    if (road[i-1][j] != -1) {
                        down = road[i-1][j];
                    }
                    if (road[i][j-1] != -1) {
                        right = road[i][j-1];
                    }
                    // 아래 내용을 수정 후 효율성 테스트 정답.
                    //road[i][j] = down + right;
                    road[i][j] = (down + right) % 1000000007;
                }
            }
        }
        int answer = road[n-1][m-1];
        return answer;
    }
}