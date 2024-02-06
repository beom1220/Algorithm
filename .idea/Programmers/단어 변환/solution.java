import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 일단 최소 단계를 물었기 때문에, 아마 BFS이지 않을까.
        // 그럼 어떤 식으로 가느냐...
        // 예를 들어, hit이 들어왔어.
        // 그럼 h 또는 i 또는 t 중에 하나만 다른 것들로 가야 함.
        // 그럼 일단 예시 입력에서 가능한 건 hot 하나.
        // hot 다음으로 가능한 건, dot, lot
        // dot이라면 dog lot이 가능하고
        // lot이라면 log dot이 가능
        // dog라면 log cog
        // log라면 dog cog
        // 그 다음은 반드시 cog로 와서 끝.
        // 일단 bfs니까 큐를 쓰고. 그럼 일단 큐에다가 begin을 넣어.
        // 음 근데 음. 아. 음.
        // 일단 단순하게만 생각해봄.
        // 그럼 begin이랑 하나만 다른 애들을 다 뽑는 거임.
        // 그리고 걔네를 혼자 넣는 게 아니라, 정수값이랑 같이 넣어야 level도 판단이 되지 않으려나.
        // 암튼 그러고 또 이걸 반복하면서 빼내다가, 답이랑 같은 게 뽑히면 되는 건가.
        // 뭔가 논리적인 오류가 없으려나.
        Queue<String[]> q = new LinkedList<>();
        String[] b = {begin, "0"};
        q.add(b);

        while (!q.isEmpty()) {
            String[] checkArr = q.poll();
            String check = checkArr[0];
            if (check.equals(target)) {
                return Integer.parseInt(checkArr[1]);
            }
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals("") && canChange(words[i], check)) {
                    int wl = Integer.parseInt(checkArr[1]) + 1;
                    String[] w = {words[i], wl + ""};
                    q.add(w);
                    words[i] = "";
                }
            }
        }
        return 0;
    }

    boolean canChange(String now, String check) {
        String[] nows = now.split("");
        String[] checks = check.split("");
        int k = 0;
        for (int i = 0; i < nows.length; i++) {
            if (!nows[i].equals(checks[i])) {
                k++;
            }
        }
        return k == 1;
    }
}