import java.util.*;

class Solution {
    PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder()); // 큰 것부터.
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 작은 것부터.
    int[] answer = {0, 0};
    boolean empty = true;
    public int[] solution(String[] operations) {
        int value = 0;

        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            int op; // 명령어 구분. 0=삽입, 1=최대삭제, 2=최소삭제
            if (s.startsWith("I")) {
                String[] v = s.split(" ");
                value = Integer.parseInt(v[1]);
                op = 0; // 삽입
            } else {
                String[] v = s.split(" ");
                if (v[1].equals("-1")) {
                    op = 2;
                } else {
                    op = 1;
                }
            }
            oper(op, value);
        }

        answer[0] = oper(1, 0);
        empty = false;
        answer[1] = oper(2, 0); // 이때 생기는 문제. 길이가 1짜리였다면 [1]부분에 [0]과 같은 값이어야 하는데, 0이 들어감.
        // 그렇다고 0일 때 무조건 [1] 부분꺼를 넣으면 실제로 0인 경우에 고장남.
        // if (answer[0] + answer[1] != 0) {
        //     if (answer[0] == 0) {
        //         answer[0] = answer[1];
        //     } else if (answer[1] == 0) {
        //         answer[1] = answer[0];
        //     }
        // }
        if (empty) {
            answer[1] = answer[0];
        }

        return answer;
    }

    int oper(int op, int value) {
        int temp;
        if (op == 0) {
            pq.add(value);
            rpq.add(value);
            System.out.println("삽입 : " + value);
        } else if (op == 1) {
            while (true) {
                if (!rpq.isEmpty()) {
                    temp = rpq.poll();
                    if (pq.contains(temp)) {
                        System.out.println("최대삭제 : " + temp);
                        return temp;
                    }
                } else {
                    pq.clear();
                    System.out.println("비움1");
                    if (!empty) {
                        empty = true;
                    }
                    return 0;
                }
            }
        } else {
            while (true) {
                if (!pq.isEmpty()) {
                    temp = pq.poll();
                    if (rpq.contains(temp)) {
                        System.out.println("최소삭제 : " + temp);
                        return temp;
                    }
                } else {
                    rpq.clear();
                    System.out.println("비움2");
                    if (!empty) {
                        empty = true;
                    }
                    return 0;
                }
            }
        }
        return 0;
    }
}