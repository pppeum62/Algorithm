import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int mat = mats[i];

            for (int x = 0; x <= park.length - mat; x++) {
                for (int y = 0; y <= park[0].length - mat; y++) {
                    if (isEmptyArea(park, x, y, mat)) {
                        return mat;
                    }
                }
            }
        }
        
        return -1;
    }

    public boolean isEmptyArea(String[][] park, int x, int y, int len) {
        if (x + len > park.length || y + len > park[0].length) {
            return false;
        }
        
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (!"-1".equals(park[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }
}
