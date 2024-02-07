class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 일단 brown과 yellow를 더한 값이 총 넓이. 편의상 area라 하겠다.
        // area의 sqrt 전까지 반복하면서 area를 나누어, 곱할 수 있는 쌍을 찾는다.
        // 쌍의 각 값에서 2을 빼서 곱했을 때 yellow와 같은 값이 나오면 된다.
        // 그럼 그 값이 바로 가로, 세로 값이 된다. (가로가 더 큰 값)
        int area = brown + yellow;
        int limit = (int) Math.sqrt(area);
        for (int i = 3; i <= limit; i++) {
            if (area % i == 0) {
                int garo = area / i;
                int sero = i;
                if ((garo - 2) * (sero - 2) == yellow) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                }
            }
        }
        return answer;
    }
}