package programmers;

import java.util.*;

class Solution {
  public int[] solution(int[] fees, String[] records) {
    int btime = fees[0];
    int bfee = fees[1];
    int ptime = fees[2];
    int pfee = fees[3];

    Map<String, String> hm = new HashMap<String, String>();
    Map<String, Integer> ans = new HashMap<String, Integer>();

    for(String rec : records){
      String cnum = rec.substring(6,10);
      if(rec.charAt(11) == 'I'){
        String intime = rec.substring(0,5);
        hm.put(cnum, intime);
      } else{
        String intime = hm.get(cnum);
        String outtime = rec.substring(0,5);

        int inhour = Integer.parseInt(intime.substring(0,2));
        int outhour = Integer.parseInt(outtime.substring(0,2));

        int inmin = Integer.parseInt(intime.substring(3));
        int outmin = Integer.parseInt(outtime.substring(3));

        int alltime = 0;
        if(outmin-inmin < 0){
          outhour--;
          outmin += 60;
          alltime = (outhour-inhour) * 60 + outmin-inmin;
        } else{
          alltime = (outhour-inhour) * 60 + outmin-inmin;
        }
        ans.put(cnum, ans.getOrDefault(cnum, 0) + alltime);

        hm.remove(cnum);
      }
    }

    for (String cnum : hm.keySet()) {
      String intime = hm.get(cnum);
      String outtime = "23:59";

      int inhour = Integer.parseInt(intime.substring(0,2));
      int outhour = Integer.parseInt(outtime.substring(0,2));

      int inmin = Integer.parseInt(intime.substring(3));
      int outmin = Integer.parseInt(outtime.substring(3));

      int alltime = 0;
      if(outmin-inmin < 0){
        outhour--;
        outmin += 60;
        alltime = (outhour-inhour) * 60 + outmin-inmin;
      } else{
        alltime = (outhour-inhour) * 60 + outmin-inmin;
      }
      ans.put(cnum, ans.getOrDefault(cnum, 0) + alltime);
    }

    int[] answer = new int[ans.size()];

    List<String> keyList = new ArrayList<>(ans.keySet());
    keyList.sort((s1, s2) -> s1.compareTo(s2));

    int i=0;
    for (String key : keyList) {
      int alltime = ans.get(key);
      int allfee = 0;
      if(alltime <= btime){
        answer[i] = bfee;
      } else{
        if((alltime-btime)%ptime != 0){
          allfee = bfee + ((alltime-btime)/ptime+1)*pfee;
          answer[i] = allfee;
        } else{
          allfee = bfee + ((alltime-btime)/ptime)*pfee;
          answer[i] = allfee;
        }
      }
      i++;
    }
    return answer;
  }
}