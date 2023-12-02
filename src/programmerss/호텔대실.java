package programmerss;

import java.util.*;

class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        List<int[]> book = new LinkedList<>();

        for(int i=0; i<book_time.length; i++){
            int sTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int eTime = Integer.parseInt(book_time[i][1].replace(":",""));

            eTime += 10;
            if(eTime%100 >= 60){
                eTime += 40;
            }

            book.add(new int[]{sTime, eTime});
        }

        Collections.sort(book, new Comparator<int[]>(){
            @Override
            public int compare(int[] obj1, int[] obj2){
                if(obj1[0] > obj2[0]) return 1;
                else if(obj1[0] < obj2[0]) return -1;
                else {
                    if(obj1[1] > obj2[1]) return 1;
                    else return -1;
                }
            }
        });

        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int[] schedule : book){
            if(room.size() == 0){
                room.add(schedule[1]);
                continue;
            }

            int top = room.peek();
            if(schedule[0] >= top){
                room.poll();
                room.add(schedule[1]);
            }else{
                room.add(schedule[1]);
            }
        }

        answer = room.size();

        return answer;
    }
}