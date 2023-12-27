
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
        int w = Integer.parseInt(bf.readLine());
        List<String> l = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            l.add(bf.readLine());
        }
        int cnt = 0;

        for (String s : l) {
            String[] ls = s.split("");
            Stack<String> st = new Stack<>();

            for (int i = 0; i < ls.length; i++) {
                String check = ls[i];
                if (!st.empty() && st.peek().equals(check)) {
                    st.pop();
                } else {
                    st.push(check);
                }
            }

            if (st.empty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}