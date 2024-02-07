// import java.util.*;
//
// class Solution {
//     boolean solution(String s) {
//         String[] ss = s.split("");
//         Stack<String> st = new Stack<>();
//         for (int i = 0; i < ss.length; i++) {
//             String t = ss[i];
//             if (t.equals("(")) {
//                 st.push(t);
//             } else {
//                 if (st.isEmpty() || !st.pop().equals("(")) {
//                     return false;
//                 }
//             }
//         }
//         return st.isEmpty();
//     }
// }

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
