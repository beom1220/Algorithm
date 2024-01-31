import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
        // 각 작업의 개발 속도가 적힌 정수 배열 speeds
        // 각 배포마다 몇 개의 기능이 배포되는지 return
        // 하루 speed%씩
        // 앞의 기능이 다 돼야 배포가 가능하고.
        // 대충 이해는 됐다. 어떻게 푸는가.
        // 일단 대충 생각해보면, 더 필요한 기간의 큐를 만드는 게 맞지 않을까.
        // 그러고 앞에 있는 거 출력하면서 그거 이하인 거 개수를 세고.
        Queue<Integer> needs = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int m = 100 - progresses[i];
            int temp = (m / speeds[i]);
            if (m % speeds[i] != 0) {
                temp++;
            }
            needs.add(temp);
        } // 여기까진 needs에 각 필요한 날짜를 저장함. 예: (7일, 3일, 9일)

        Queue<Integer> qanswer = new LinkedList<>(); // qanswer는 정답을 넣을 거임. 각 배포마다 기능 수.
        int date = 0; // 기준이 될 날짜
        int cnt = 0; // 배포되는 기능의 개수 카운트

        for (int i = 0; i < speeds.length; i++) { // needs만큼 도는 거.

            if (date == 0) { // 각 배포의 처음 계산 시.
                date = needs.poll(); // 맨 처음꺼 기준 삼고
                cnt++; // 기능 수 +1
            } else {
                if (date < needs.peek()) {  // date보다 뒤에가 크면 일단 여기서 배포 끝.
                    qanswer.add(cnt);
                    cnt = 1; // 카운트 초기화
                    date = needs.poll();
                } else { // 아니면 더 뽑음.
                    needs.poll();
                    cnt++;
                }
            }
        }
        qanswer.add(cnt);

        int[] answer = new int[qanswer.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = qanswer.poll();
        }
        return answer;

    }
}