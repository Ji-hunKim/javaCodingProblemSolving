package programmerss;

import java.util.*;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> hm;

        for (int i = 0; i < discount.length - 9; i++) {
            hm = new HashMap<>();
            for (int k = 0; k < number.length; k++) {
                hm.put(want[k], number[k]);
            }
            for (int j = i; j < i + 10; j++) {
                if (hm.containsKey(discount[j])) {
                    hm.replace(discount[j], hm.get(discount[j]) - 1);
                }
            }
            boolean ch = true;
            for (String key : hm.keySet()) {
                if (hm.get(key) > 0) {
                    ch = false;
                    break;
                }
            }
            if (ch) answer++;
        }
        return answer;
    }
}

