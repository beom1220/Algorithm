import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i부터 j까지 자름. 정렬함. k번째 수를 찾음.

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int[] temp = new int[end - start + 1];
            int k = 0;
            for (int j = start - 1; j < end; j++) {
                temp[k] = array[j];
                k++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}