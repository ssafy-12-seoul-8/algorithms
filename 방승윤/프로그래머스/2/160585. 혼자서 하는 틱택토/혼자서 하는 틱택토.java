class Solution {
    public int solution(String[] board) {
        int bingoFirst = 0;
        int bingoSecond = 0;
        
        one: for (int i = 0; i < 3; i++) {
            char alphabet = board[i].charAt(0);
            
            if (alphabet == '.') {
                continue;
            }
            
            for (int j = 1; j < 3; j++) {
               if (alphabet != board[i].charAt(j)) {
                   continue one;
               }
            }
            
            if (alphabet == 'O') {
                bingoFirst++;
            } else {
                bingoSecond++;
            }
        }
        
        one: for (int i = 0; i < 3; i++) {
            char alphabet = board[0].charAt(i);
            
            if (alphabet == '.') {
                continue;
            }
            
            for (int j = 1; j < 3; j++) {
               if (alphabet != board[j].charAt(i)) {
                   continue one;
               }
            }
            
            if (alphabet == 'O') {
                bingoFirst++;
            } else {
                bingoSecond++;
            }
        }
        
        boolean flag = false;
        char alphabet = board[0].charAt(0);
        
        if (alphabet == '.') {
                flag = true;
        }
        
        for (int i = 1; i < 3; i++) {
            if (alphabet != board[i].charAt(i)) {
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            if (alphabet == 'O') {
                bingoFirst++;
            } else {
                bingoSecond++;
            }
        }
        
        flag = false;
        alphabet = board[2].charAt(0);
        
        if (alphabet == '.') {
                flag = true;
        }
        
        for (int i = 1; i < 3; i++) {
            if (alphabet != board[2 - i].charAt(i)) {
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            if (alphabet == 'O') {
                bingoFirst++;
            } else {
                bingoSecond++;
            }
        }
        
        if (bingoFirst > 0 && bingoSecond > 0) {
            return 0;
        }
        
        int cntFirst = 0;
        int cntSecond = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    cntFirst++;
                }
                
                if (board[i].charAt(j) == 'X') {
                    cntSecond++;
                }
            }
        }
        
        if ((bingoFirst > 0 && cntFirst - cntSecond == 1) || (bingoSecond > 0 && cntFirst - cntSecond == 0)) {
            return 1;
        }
        
        if (bingoFirst == 0 && bingoSecond == 0) {
            if (cntFirst - cntSecond == 1 || cntFirst - cntSecond == 0) {
            return 1;
        }
        }
        
        return 0;
    }
}