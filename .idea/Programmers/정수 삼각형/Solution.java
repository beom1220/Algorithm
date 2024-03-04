class Solution {
    public int solution(int[][] triangle) {
        // 동적이면 일단 단계별로 저장한다.
        // 그럼 그 시점마다의 최대합을 저장하면?
        // 일단 그럼 똑같이 생긴 삼각형을 만들고 채워가?
        int[][] copy = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            copy[i] = new int[triangle[i].length];
        }

        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5

        copy[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            int len = triangle[i].length;
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    copy[i][j] = triangle[i][j] + copy[i-1][j];
                } else if (j == len - 1) {
                    copy[i][j] = triangle[i][j] + copy[i-1][j-1];
                } else {
                    copy[i][j] = Math.max(triangle[i][j] + copy[i-1][j], triangle[i][j] + copy[i-1][j-1]);
                }
            }
        }

        int answer = 0;
        int[] bot = copy[triangle.length - 1];

        for (int i = 0; i < bot.length; i++) {
            answer = Math.max(answer, bot[i]);
        }

        return answer;
    }
}