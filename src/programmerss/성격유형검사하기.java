package programmers;

class Solution {
  public String solution(String[] survey, int[] choices) {
    String answer = "";
    int[] temp = new int[4];
    for(int i=0;i<survey.length;i++){
      if(survey[i].equals("RT")){
        temp[0] += 4-choices[i];
      }
      else if(survey[i].equals("TR")){
        temp[0] += choices[i]-4;
      }
      else if(survey[i].equals("CF")){
        temp[1] += 4-choices[i];
      }
      else if(survey[i].equals("FC")){
        temp[1] += choices[i]-4;
      }
      else if(survey[i].equals("JM")){
        temp[2] += 4-choices[i];
      }
      else if(survey[i].equals("MJ")){
        temp[2] += choices[i]-4;
      }
      else if(survey[i].equals("AN")){
        temp[3] += 4-choices[i];
      }
      else{
        temp[3] += choices[i]-4;
      }

    }

    String ss = "RTRCFCJMJANA";
    for(int j=0;j<4;j++){
      System.out.println(temp[j]);
      if(temp[j]>0){
        answer += String.valueOf(ss.charAt(j*3));
      }
      else if(temp[j]<0){
        answer += String.valueOf(ss.charAt(j*3+1));
      }
      else{
        answer += String.valueOf(ss.charAt(j*3+2));
      }
    }
    return answer;
  }
}