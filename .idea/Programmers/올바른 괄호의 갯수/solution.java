import java.util.*;

class Solution {

    class Group { // 조합과 열린괄호, 닫힌괄호 개수를 저장.
        String s; // 현재 조합
        int o; // 열린괄호 수
        int c; // 닫힌괄호 수
        Group(String s, int o, int c) {
            this.s = s;
            this.o = o;
            this.c = c;
        }
    }

    public int solution(int n) {
        int answer = 0;

        Stack<Group> st = new Stack<>(); // 조합을 저장할 스택
        st.push(new Group("",0,0)); // 일단 빈 거 넣어서

        while (!st.isEmpty()){ // 스택 빌 때까지 반복
            Group now = st.pop(); // 일단 팝
            if (now.o == n && now.c == n) { // 열린 괄호와 닫힌 괄호 수가 같다는 건 완성이라는 거.
                answer++;
            }
            if (now.o < n) { // 열린 괄호 수가 n보다 작으면 열린 괄호는 아무 때나 넣어도 됨.
                st.push(new Group(now.s+"(", now.o+1, now.c));
            }
            if (now.c < now.o) { // 닫힌 괄호 수가 열린 괄호 수보다 작으면 닫힌 괄호는 아무 때나 넣어도 됨.
                st.push(new Group(now.s+")", now.o, now.c+1));
            }
        }

        return answer;
    }
}