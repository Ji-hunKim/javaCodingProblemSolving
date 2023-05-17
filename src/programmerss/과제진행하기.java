package programmerss;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        Stack<String[]> queue = new Stack<>();

        Arrays.sort(plans, new Comparator<String[]>() {
            int timeInt1;
            int timeInt2;

            @Override
            public int compare(String[] obj1, String[] obj2) {
                timeInt1 = toInt(obj1[1]);
                timeInt2 = toInt(obj2[1]);

                if (timeInt1 > timeInt2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        String now = plans[0][1];

        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];

            String curSubject = plan[0];
            String curTime = plan[1];
            String curAdd = plan[2];

            String left = "";

            if (i == plans.length - 1) {
                if (queue.isEmpty()) {
                    answerList.add(curSubject);
                } else {
                    if (toInt(now) < toInt(curTime)) {
                        //queue now 비교
                        while (toInt(now) != toInt(curTime)) {
                            if (queue.isEmpty()) {
                                break;
                            }

                            String[] queuePlan = queue.pop();
                            String queueSubject = queuePlan[0];
                            String queueLeft = queuePlan[1];

                            int temp = Integer.parseInt(queueLeft) - timetimeMinus(now, curTime);
                            left = String.valueOf(temp);
                            if (Integer.parseInt(left) > 0) {

                                now = curTime;
                                queue.push(new String[]{queueSubject, left});
                            } else {

                                now = timeAdd(now, queueLeft);
                                answerList.add(queueSubject);
                            }
                        }

                        answerList.add(curSubject);
                        while (!queue.isEmpty()) {
                            answerList.add(queue.pop()[0]);
                        }
                    } else {
                        answerList.add(curSubject);
                        while (!queue.isEmpty()) {
                            answerList.add(queue.pop()[0]);
                        }
                    }
                }
                break;
            }

            String[] nextPlan = plans[i + 1];
            String nextTime = nextPlan[1];

            if (toInt(timeAdd(curTime, curAdd)) > toInt(nextTime)) {

                now = nextTime;

                int temp = Integer.parseInt(curAdd) - timetimeMinus(curTime, nextTime);
                left = String.valueOf(temp);

                queue.push(new String[]{curSubject, left});
            } else {
                answerList.add(curSubject);
                now = timeAdd(curTime, curAdd);
                while (toInt(now) != toInt(nextTime)) {
                    if (queue.isEmpty()) {
                        now = nextTime;
                        break;
                    }

                    String[] queuePlan = queue.pop();
                    String queueSubject = queuePlan[0];
                    String queueLeft = queuePlan[1];

                    int temp = Integer.parseInt(queueLeft) - timetimeMinus(now, nextTime);
                    left = String.valueOf(temp);
                    if (Integer.parseInt(left) > 0) {

                        now = nextTime;
                        queue.push(new String[]{queueSubject, left});
                    } else {

                        now = timeAdd(now, queueLeft);
                        answerList.add(queueSubject);
                    }
                }
            }
        }

        return answerList.toArray(new String[0]);
    }

    public int toInt(String t) {
        int idx = t.indexOf(":");
        int h = Integer.parseInt(t.substring(0, idx));
        int m = Integer.parseInt(t.substring(idx + 1));

        return h * 100 + m;
    }

    public String timeAdd(String t, String plus) {
        int idx = t.indexOf(":");
        int h = Integer.parseInt(t.substring(0, idx));
        int m = Integer.parseInt(t.substring(idx + 1));
        int p = Integer.parseInt(plus);
        int cnt = 0;
        while (m + p >= 60) {
            h++;
            cnt++;
            p = p - 60;
        }
        m = m + p;

        if (h == 0) {
            return "00" + ":" + String.valueOf(m);
        }

        return String.valueOf(h) + ":" + String.valueOf(m);
    }


    public int timetimeMinus(String a, String b) {
        int aIdx = a.indexOf(":");
        int bIdx = b.indexOf(":");

        int ah = Integer.parseInt(a.substring(0, aIdx));
        int am = Integer.parseInt(a.substring(aIdx + 1));

        int bh = Integer.parseInt(b.substring(0, bIdx));
        int bm = Integer.parseInt(b.substring(bIdx + 1));

        if (bm - am >= 0) {
            return (bh - ah) * 60 + (bm - am);
        } else {
            bh--;
            return (bh - ah) * 60 + (bm - am + 60);
        }
    }
}
