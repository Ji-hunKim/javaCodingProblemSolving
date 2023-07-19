package leetcode;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(getLocal(email) + email.substring(email.indexOf("@")));
        }

        return emailSet.size();
    }

    private String getLocal(String email){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < email.length(); i++){
            if(email.charAt(i) == '.') continue;
            if(email.charAt(i) == '+' || email.charAt(i) == '@') break;
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }
}