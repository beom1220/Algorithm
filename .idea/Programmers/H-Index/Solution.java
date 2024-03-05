import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 생산성과 영향력을 나타내는 지표다.
        // 구하는 방법은 n편 논문 중, h번 이상 인용된 논문이 h편 이상이고, 나머지는 h번 이하 인용일 때의 h의 최댓값.
        // 논문의 수는 1000 이하. 최대 h는 1000인가?
        // 인용 횟수는 0 ~ 10000까지. 그럼 일단 정렬을 시키고.
        // 테케로 예를 들자.
        // 정렬하면 0 1 3 5 6.
        // 그럼 일단 5편이 있다.
        // h가 5이려면, 5개 모두 5번 이상 인용되어야 함.
        // 즉, c[0] >= 5 여야 5임.
        // 다시 말해, c[c.length - i] >= i 면 i임.
        Arrays.sort(citations);
        for (int i = citations.length; i > 0; i--) {
            if (citations[citations.length - i] >= i) {
                return i;
            }
        }
        return 0;
    }
}