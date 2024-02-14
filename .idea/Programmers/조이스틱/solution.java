class Solution {
    int answer;
    char[] names;
    public int solution(String name) {
        names = name.toCharArray();
        boolean[] check = new boolean[names.length];
        answer = 0;
        int c = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == 65) {
                check[i] = true;
                c++;
            }
        }
        int index = 0;
        while (true) {
            // 1. 탈출 조건
            if (c == check.length) {
                break;
            }

            // 2. 수행 동작
            if (!check[index]) { // A 아닌 곳이면
                char now = names[index];
                if (now >= 'O') {
                    answer += 'Z' - now + 1;
                } else {
                    answer += now - 'A';
                }
                check[index] = true;
                c++;
            }
            index = next(check, index);
        }

        return answer;
    }

    int next(boolean[] check, int index) {
        int left = 0;
        int right = 0;
        while (true) { // 오른쪽 먼저 확인
            if ((index + right == check.length - 1) && check[index+right]) { // 시작이 맨 오른쪽이면 바로 오른쪽 검사 없이 끝.
                right = 0;
                break;
            }
            if(!check[index + right]) { // 이동한 곳이 검사된 곳인지 검사.
                break;
            } else {
                right++;
            }
        }

        while (true) { // 왼쪽 확인
            if (index - left == 0 && check[index-left]) {
                left = 0;
                break;
            }
            if (!check[index - left]) {
                break;
            } else {
                left++;
            }
        }

        if (left == 0 || left >= right) { // 맨 왼쪽이거나, 왼쪽이 오른쪽보다 멀어서 "오른쪽"으로 갈 때
            // 근데 또 반대 방향으로 가야 될 수도 있잖어.
            if (right > names.length / 2) {
                answer += names.length - right;
            } else {
                answer += right;
            }
            return index + right;
        } else if (right == 0 || right > left) { // "왼쪽"으로 갈 때
            if (left > names.length / 2) {
                answer += names.length - left;
            } else {
                answer += left;
            }
            return index - left;
        }
        return 0;
    }
}
