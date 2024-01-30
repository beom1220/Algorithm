import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int zero = 0;
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = numbers[i] + "";
            zero += numbers[i];
        }

        if (zero == 0) {
            return "0";
        }

//         Arrays.sort(arr, Collections.reverseOrder());

//         for (int i = 0; i < arr.length - 1; i++) {
//             String tempA = arr[i] + arr[i+1];
//             String tempB = arr[i+1] + arr[i];
//             int ta = Integer.parseInt(tempA);
//             int tb = Integer.parseInt(tempB);
//             if (ta < tb) {
//                 String ti = arr[i];
//                 arr[i] = arr[i+1];
//                 arr[i+1] = ti;
//             }
//         }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1+o2));

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        return answer;
    }
}