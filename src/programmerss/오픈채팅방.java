package programmers;

import java.util.*;

class Solution {
  public String[] solution(String[] record) {
    Map<String, String> hm = new HashMap<String, String>();

    for(String re : record){
      String[] reString = re.split(" ");
      String order = reString[0];
      String id = reString[1];
      if(order.equals("Enter")){
        String nick = reString[2];
        hm.put(id, nick);
      } else if(order.equals("Change")){
        String nick = reString[2];
        hm.put(id, nick);
      }
    }

    List<String> an = new ArrayList<String>();

    for(String re : record){
      String[] reString = re.split(" ");
      String order = reString[0];
      String id = reString[1];
      if(order.equals("Enter")){
        String nick = hm.get(id);
        String message = nick + "님이 들어왔습니다.";
        an.add(message);
      } else if(order.equals("Leave")){
        String nick = hm.get(id);
        String message = nick + "님이 나갔습니다.";
        an.add(message);
      }
    }

    String[] answer = new String[an.size()];
    for(int i=0; i<an.size(); i++){
      answer[i] = an.get(i);
    }

    return answer;
  }
}