class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        final int VIDEO = parseTime(video_len);
        final int POS = parseTime(pos);
        final int OP_START = parseTime(op_start);
        final int OP_END = parseTime(op_end);
        
        int answer = POS;
        
        for (String command : commands) {
            answer = skip(answer, OP_START, OP_END, VIDEO);
            answer += command.equals("next") ? 10 : -10;
            answer = skip(answer, OP_START, OP_END, VIDEO);
        }
        
        return formatTime(answer);
    }
    
    public String formatTime(int time) {
        int mm = time / 60;
        int ss = time % 60;
        
        return String.format("%02d:%02d", mm, ss);
    }
    
    public int parseTime(String time) {
        String[] parts = time.split(":");

        int mm = Integer.parseInt(parts[0]);
        int ss = Integer.parseInt(parts[1]);

        return mm * 60 + ss;
    }
    
    public int skip(int pos, int op_start, int op_end, int video) {
        if (op_start <= pos && pos <= op_end) {
            pos = op_end;
        }
        
        if (pos < 0) {
            pos = 0;
        } else if (pos > video) {
            pos = video;
        }
        
        return pos;
    }
}
