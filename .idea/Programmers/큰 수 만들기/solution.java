// class Solution {
//     public String solution(String number, int k) {
//         StringBuilder sb = new StringBuilder(number); // 불변인 String 대신 사용해야 함.

//         for(int i = 0; i < sb.length()-1; i++) {
//             if(k == 0) break;
//             if(sb.charAt(i) < sb.charAt(i+1)) {
//                 sb.deleteCharAt(i);
//                 i = -1; // i가 0부터 시작하므로, 다음 루프에선 0부터 시작하게 하기 위해 -1로 설정
//                 k--;
//             }
//         }

//         // 아직 k개를 다 제거하지 못한 경우, 뒤에서부터 제거
//         if(k > 0) {
//             sb.delete(sb.length() - k, sb.length());
//         }

//         return sb.toString();
//     }
// }

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
