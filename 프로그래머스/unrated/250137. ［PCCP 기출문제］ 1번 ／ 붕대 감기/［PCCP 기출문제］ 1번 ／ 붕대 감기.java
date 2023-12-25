class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int heart = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int sec = 0;
        int conSuccess = 0;
        
        // 공격 받는 시점
        for(int i=0;i<attacks.length;i++){
            int betweenTime = attacks[i][0] - sec -1;
            
            // 공격받기 전 초까지 회복
            int recovery = betweenTime / t;
            heart += betweenTime * x + recovery * y; 
            if(heart>health) heart = health;
            
            // 현재 공격으로 인한 데미지
            conSuccess = 0;  //연속성공시간 초기화
            heart -= attacks[i][1];
            if(heart <= 0) return -1;
            
            sec = attacks[i][0];
        }
        
        return heart;
    }
}