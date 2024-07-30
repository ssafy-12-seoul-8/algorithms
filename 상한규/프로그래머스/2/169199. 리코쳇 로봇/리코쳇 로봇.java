import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        String[][] boardArray = new String[board.length][board[0].split("").length];
        int[] dirR = {0, 0, -1, 1};
        int[] dirC = {-1, 1, 0, 0};
        boolean[][] visited = new boolean[board.length][board[0].split("").length];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < board.length; i++){
            String[] rowString = board[i].split("");
            for(int j = 0; j < boardArray[0].length; j++){
                boardArray[i][j] = rowString[j];
                if(boardArray[i][j].equals("R")){
                    int[] startXY = {j, i, 0};
                    queue.offer(startXY);
                    visited[startXY[1]][startXY[0]] = true;
                }
            }
        }
        
        while(!(queue.isEmpty())){
            int[] cursorXY = queue.poll();
            
            for(int i = 0; i < dirR.length; i++){
                int cursorX = cursorXY[0];
                int cursorY = cursorXY[1];
                
                while(cursorX + dirR[i] >= 0 && cursorX + dirR[i] < boardArray[0].length && cursorY + dirC[i] >= 0 && cursorY + dirC[i] < boardArray.length && !(boardArray[cursorY + dirC[i]][cursorX + dirR[i]].equals("D"))){
                    cursorX += dirR[i];
                    cursorY += dirC[i];
                    
                }
                int[] newCursorXY = new int[3];
                
                newCursorXY[0] = cursorX;
                newCursorXY[1] = cursorY;
                newCursorXY[2] = cursorXY[2] + 1;

                if(boardArray[cursorY][cursorX].equals("G")){
                    answer = Math.min(answer, newCursorXY[2]);
                }
                else if(!visited[cursorY][cursorX]){
                    visited[cursorY][cursorX] = true;
                    queue.offer(newCursorXY);
                }
            }
        }
        
        return answer = answer == Integer.MAX_VALUE ? -1 : answer;
    }
}