import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 일단 총 마릿수를 nums.length가 아니라 n이라고 함.
        // 2/n은 무조건 정수고. 일단 편의상 e라고 함.
        // 일단 nums에서 종류를 알아봐야 함.
        // 종류의 수가 e보다 많으면 그냥 e를 리턴해주면 됨.
        // 종류가 e보다 적으면 이제 문제가 있는데.
        // 아 문제 없네. 종류의 수를 리턴해주면 되네.
        // 즉, 종류의 수를 파악하면 끝.
        HashSet<Integer> nn = new HashSet<>();
        for (int k = 0; k < nums.length; k++) {
            nn.add(nums[k]);
        }
        return Math.min(nn.size(), nums.length / 2);
    }
}