class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health; // 현재 체력에 최대 체력을 저장.
        for (int i = 0; i < attacks.length; i++) { // 준비된 공격만큼 반복.
            int nowAtk = attacks[i][0]; // 현재 공격 시간을 저장
            answer -= attacks[i][1]; // 현재 공격만큼 체력이 닳음.
            if (answer <= 0) { // 죽었는지 확인
                return -1; // 죽었으면 -1 반환하여 끝냄.
            }
            if (i + 1 < attacks.length) { // 다음 공격이 있다면
                int nextAtk = attacks[i+1][0]; // 다음 공격 시간을 저장.
                int term = nextAtk - nowAtk - 1; // 현재 공격과 다음 공격의 시간의 차이를 계산.
                if (term >= bandage[0]) { // 차이가 붕대 시간보다 길면
                    for (int j = 0; j < term / bandage[0]; j++) {
                        answer += bandage[0] * bandage[1] + bandage[2];
                    }
                    // **틀린 부분 발견** 보너스 시간을 주는 식이었는데, 2번 이상 될 때가 있구나.
                } else {
                    answer += term * bandage[1]; // 차이가 붕대 시간보다 짧으면 그냥 시간만큼 회복
                }
                if (answer > health) {
                    answer = health; // 최대 체력 넘으면 최대 체력으로 바꿈.
                }
            }
        }
        return answer;
    }
}