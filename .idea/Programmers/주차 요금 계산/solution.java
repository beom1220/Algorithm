import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<Integer, Integer> carInTime = new HashMap<>(); // (차량번호, 입차시간)
        Map<Integer, Integer> total = new HashMap<>(); // (차량번호, 주차한 시간)

        for (int i = 0; i < records.length; i++) { // records 순회
            String[] infos = records[i].split(" "); // infos 순서대로 - 시간, 차량번호, 입출차
            String[] time = infos[0].split(":"); // 시간은 시, 분으로 나눔. (분으로 변환하기 위함)
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 시간을 분으로 변환
            int num = Integer.parseInt(infos[1]); // 차 번호
            if (infos[2].equals("IN")) { // 입차면
                if (carInTime.containsKey(num)) { // 이미 입차한 적 있으면 (이젠 필요없는 코드)
                    carInTime.replace(num, minute); // 수정하고
                } else {
                    carInTime.put(num, minute); // 첫 입차면 추가
                }
            } else { // 출차
                int inTime = carInTime.remove(Integer.parseInt(infos[1])); // 들어온 시간을 뽑아오면서, 입차 기록을 삭제
                int term = minute - inTime; // 주차한 시간을 확인

                if (total.containsKey(num)) { // 이미 있는지 검사
                    int pre = total.get(num); // 이전 주차한시간 가져옴
                    total.replace(num, pre + term); // 수정
                } else {
                    total.put(num, term); // 처음이면 추가
                }
            }
        } // 여기까지 하면 기록 상의 입출차는 모두 순회함. 하지만, 출차 기록이 없는 경우에도 23:59에 출차한 것으로 해야 함.

        for (int key : carInTime.keySet()) { // 입차 기록 남은 것들을 순회 (출차하지 않은 것들)
            int outTime = 60 * 23 + 59; // 23:59 출차
            int inTime = carInTime.get(key); // 입차 시간 가져와서
            int term = outTime - inTime; // 주차한 시간 계산
            // 아래는 아까와 같음.
            if (total.containsKey(key)) {
                int pre = total.get(key);
                total.replace(key, pre + term);
            } else {
                total.put(key, term);
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(); // 우선순위 큐로 차량번호 작은 순으로 뽑으려고 함.
        for (int key : total.keySet()) { // 일단 차량번호 전부 큐에 저장.
            q.add(key);
        }
        int size = q.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) { // 큐 전부 순회
            int car = q.remove(); // car는 차 번호
            int pay = fees[1]; // 가격에 우선 기본비용 추가함.
            if (total.get(car) > fees[0]) { // 기본시간을 넘긴 경우
                int overTime = total.get(car) - fees[0]; // 넘긴 시간
                int over = overTime / fees[2]; // 단위 시간 몇 번 넘긴지 구함
                if (overTime % fees[2] != 0) { // 단위 시간으로 안 나눠떨어지면 한번더
                    over++;
                }
                pay += over * fees[3]; // 추가 비용 더해줌.
            }
            answer[i] = pay;
        }

        return answer;
    }
}
