import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 명함을 모두 수납할 수 있는 가장 작은 지갑을 만든다.
        // 명함은 당연히 눕힐 수도 있다.

        // 그럼 일단 가로 또는 세로 하나는 가장 큰 값과 같아야 한다.
        // 일단 그럼 가로, 세로 중에 작은거, 큰거로 정리를 하고.
        // 가로 중 제일 큰 거랑 세로 중 제일 큰 거 찾으면 끝 아니가.
        int[][] s = new int[sizes.length][2];
        int gmax = 1;
        int smax = 1;
        for (int i = 0; i < sizes.length; i++) {
            int a = sizes[i][0];
            int b = sizes[i][1];
            s[i][0] = Math.min(a, b);
            s[i][1] = Math.max(a, b);

            gmax = Math.max(gmax, s[i][0]);
            smax = Math.max(smax, s[i][1]);
        }

        int answer = gmax * smax;
        return answer;
    }
}