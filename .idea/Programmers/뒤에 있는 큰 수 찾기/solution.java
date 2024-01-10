import java.util.List;
import java.util.ArrayList;


class Solution {
    public static int[] nums = {};

    public int[] solution(int[] numbers) {
        nums = numbers;
        int[] answer = {};
        List<Integer> as = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            as.add(dks(k));
        }

        answer = as.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public int dks(int c) {
        for (int i = c; i < nums.length; i++) {
            if (nums[c] < nums[i]) {
                return nums[i];
            }
            if (i == nums.length) {
                return -1;
            }
        }
        return -1;
    }
}

// import java.util.Stack;
//
// class Solution {
//     public int[] solution(int[] numbers) {
//         Stack<Integer> stack = new Stack<>();
//         int[] answer = new int[numbers.length];
//
//         for (int i = 0; i < numbers.length; i++) {
//             while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
//                 answer[stack.pop()] = numbers[i];
//             }
//             stack.push(i);
//         }
//
//         while (!stack.isEmpty()) {
//             answer[stack.pop()] = -1;
//         }
//
//         return answer;
//     }
// }
