class Solution {
    public String solution(int[] food) {
        String answer = "";
        String halfFoods = "";
        
        for (int i = 1; i < food.length; i++) {
            halfFoods += String.valueOf(i).repeat(food[i] / 2);
        }
        
        StringBuffer sb = new StringBuffer(halfFoods);
        answer = halfFoods + 0 + sb.reverse().toString();
        
        return answer;
    }
}
