class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        // 숫자 범위로 인해 parseInt()에서 parseLong()으로 변경...
        long pNum = Long.parseLong(p);
        
        for (int i = 0; i <= tLen - pLen; i++) {
            long compare = Long.parseLong(t.substring(i, i + pLen));
            if (compare <= pNum) {
                answer++;
            }
        }
        
        return answer;
    }
}
