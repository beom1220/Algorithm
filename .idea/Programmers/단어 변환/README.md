# 단어 변환

---

## 📌 **Algorithm**

---

- BFS (너비 우선 탐색)

## 📍 **Logic**

---

```java
class Solution {
    public int solution(String begin, String target, String[] words) {
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
```

- BFS를 통해 큐에 변환 가능한 단어를 추가함.
- 큐에는 단어와 해당 단어까지의 변환 횟수를 함께 저장했음.

## ✒️ **Review**

---

- BFS 문제를 처음으로 처음부터 끝까지 혼자 풀이해봤다.
- 레벨3의 문제라 걱정도 많았지만, 차근차근 순서대로 풀이했더니 괜찮았다.
- 아래는 기존 코드인데,

```jsx
class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int level = 0;
        
        while (!q.isEmpty()) {
            String check = q.poll();
            if (check.equals(target)) {
                return level;
            }
            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals("") && canChange(words[i], check)) {
                    q.add(words[i]);
                    words[i] = "";
                }
            }
            level++;
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
```

- 이때는 level을 for문이 끝나면 더해줘서 문제가 있었다.
- 쉽게 생각하면 큐 하나마다 level이 추가되는 방식이라, 같은 레벨에서 여러개가 들어왔더라도 결론적으로는 큐 길이만큼의 level이 반환되었던 것이다.
- 그걸 해결하기 위해서 String[]을 큐에 넣어서, level을 거기서 저장해줬다.