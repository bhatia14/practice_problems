package practice;

public class SurroundedRegions {
    public static void main(String[] args) {
        //char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        char[][] board = new char[][]{
                {'X','X','X','X','O'},
                {'X','O','O','O','X'},
                {'X','X','O','O','X'},
                {'X','X','O','O','X'},
                {'X','X','O','O','X'},
                {'X','O','0','X','X'}};
        if(board[0].length > 2 && board.length > 2){
            char[][] innerBoard = new char[board.length - 2][board[0].length-2];
            int k=0,q=0;
            for(int i=1;i< board.length-1;i++){
                for (int j=1;j< board[0].length-1;j++){
                    innerBoard[k][q] = board[i][j];
                    q++;
                }
                k++;
                q=0;
            }
//            if(innerBoard.length>2 && innerBoard[0].length>2){
//                for(int i=2;i< board.length-2;i++){
//                    for (int j=2;j< board[0].length-2;j++){
//                        board[i][j] = 'X';
//                    }
//                }
//            }

            System.out.println(innerBoard);
        }
    }
}
