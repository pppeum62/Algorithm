class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = timelogs.length;
        int answer = n;
        
        for (int i = 0; i < n; i++) {
            int hr = schedules[i] / 100;
            int min = schedules[i] % 100;
            
            int time = min + 10 >= 60
                ? (hr + 1) * 100 + (min + 10 - 60)
                : hr * 100 + (min + 10);
            
            for (int j = 0; j < 7; j++) {
                if ((startday + j) % 7 == 0 || (startday + j) % 7 == 6) continue;
                if (timelogs[i][j] > time) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}
