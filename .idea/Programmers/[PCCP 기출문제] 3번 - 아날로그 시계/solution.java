// 시간을 너무 허비하여 중도 포기하였음.
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        // 시작 시간과 끝나는 시간을 초 단위로 변환
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        for (int i = start; i <= end; i++) {
            double hours = (i / 3600 % 12 + (i % 3600) / 3600.0) * 30;
            double minutes = (i % 3600 / 60 + (i % 60)/60.0) * 6;
            double seconds = (i % 60) * 6;

            if ((hours <= seconds && hours > seconds - 6) && (minutes <= seconds && minutes > seconds - 6)) {
                if (Double.compare(hours, minutes) == 0) {
                    answer++;
                } else {
                    answer += 2;
                }
            } else if ((hours <= seconds && hours > seconds - 6) || (minutes <= seconds && minutes > seconds - 6)) {
                answer++;
            }
        }
        return answer;
    }
}