import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int BOARD_SIZE = 5;
    
    private static int [] toInt(String [] numbers){
        int [] res;
        if (numbers[0].equals("")){
            res = new int [numbers.length-1];
            for (int i = 0; i < res.length; i++){
                res [i] = Integer.parseInt(numbers[i+1]);
            }
        }
        else {
            res = new int [numbers.length];
            for (int i = 0; i < res.length; i++){
                res [i] = Integer.parseInt(numbers[i]);
            }
        }
        return res;
    }

    static class Board {
        private int [][] board;
        private boolean [][] marked;
        private boolean finished;
        
        public Board (int [][] board){
            this.board = board;
            this.marked = new boolean [BOARD_SIZE][BOARD_SIZE];
            finished = false;
        }

        public int get(int i, int j) { return board[i][j]; }

        public void mark(int i, int j) { this.marked[i][j] = true; }

        public String toString(){
            String res = "";
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    res = res + board[i][j] + " ";
                }
                res = 
                res + "\n";
            }
            return res;
        }

        public String showMarked(){
            String res = "";
            for (int i = 0; i < marked.length; i++){
                for (int j = 0; j < marked[0].length; j++){
                    if (marked[i][j]) res = res +  "T ";
                    else res = res +  "F ";
                    
                }
                res = 
                res + "\n";
            }
            return res;
        }

        public void finished(){
            this.finished = true;
        }

        public boolean isSolved(){
            return this.finished;
        }

        public boolean checkLine() {
            int horizontalCounter = 0;
            int verticalCounter = 0;
            for (int i = 0; i < BOARD_SIZE; i++){
                for (int j = 0; j < BOARD_SIZE; j++){
                    if (marked[i][j] == true){
                        horizontalCounter++;
                    }
                    if (marked[j][i] == true){
                        verticalCounter++;
                    }
                }
                if (horizontalCounter == BOARD_SIZE || verticalCounter == BOARD_SIZE) { return true; }
                horizontalCounter = 0;
                verticalCounter = 0;
            }
            return false;
        }

        public int sumUnmarked(){
            int res = 0;
            for (int i = 0; i < marked.length; i++){
                for (int j = 0; j < marked.length; j++){
                    if (marked[i][j] == false) {
                        res = res + board[i][j];
                    }
                }
            }
            return res;
        }
    }
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        int [] numbers = toInt(sc.nextLine().split(","));
        List<Board> boards = new LinkedList<>();
        sc.nextLine();
        int [] row;
        while (sc.hasNextLine()){
            row = toInt(sc.nextLine().split("[ ]+"));
            int [][] actualBoard = new int [BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++){
                for (int j = 0; j < BOARD_SIZE; j++){
                    actualBoard[i][j] = row[j];
                }
                if (sc.hasNextLine()) row = toInt(sc.nextLine().split("[ ]+"));
                else break;
            }
            boards.add(new Board(actualBoard));
        }
        int res = 0;
        boolean cortar = false;
        for (int n = 0; n < numbers.length && !cortar; n++){
            for (Board b : boards){
                if (!cortar){
                    for (int i = 0; i < BOARD_SIZE && !cortar; i++){
                        for (int j = 0; j < BOARD_SIZE && !cortar; j++){
                            if (b.get(i, j) == numbers[n]){
                                b.mark(i, j);
                                if (b.checkLine()) {
                                    res = b.sumUnmarked()*numbers[n];
                                    cortar = true;
                                }
                            }
                        }
                    }
                }
                
            }
        }
        System.out.println(res);
        sc.close();
    }

    public static void second(){
        Scanner sc = new Scanner(System.in);
        int [] numbers = toInt(sc.nextLine().split(","));
        List<Board> boards = new LinkedList<>();
        sc.nextLine();
        int [] row;
        while (sc.hasNextLine()){
            row = toInt(sc.nextLine().split("[ ]+"));
            int [][] actualBoard = new int [BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++){
                //System.out.println(Arrays.toString(row));
                for (int j = 0; j < BOARD_SIZE; j++){
                    actualBoard[i][j] = row[j];
                }
                if (sc.hasNextLine()) row = toInt(sc.nextLine().split("[ ]+"));
                else break;
            }
            boards.add(new Board(actualBoard));
        }
        boolean cortar = false;
        Board lastBoard = null;
        int lastNum = 0;
        for (int n = 0; n < numbers.length && !cortar; n++){
            for (Board b : boards){
                if (!b.isSolved()){
                    for (int i = 0; i < BOARD_SIZE; i++){
                        for (int j = 0; j < BOARD_SIZE; j++){
                            if (b.get(i, j) == numbers[n]){
                                b.mark(i, j);
                                if (b.checkLine()) {
                                    b.finished();
                                    lastBoard = b;
                                    lastNum = numbers[n];
                                }
                            }
                        }
                    }
                }
                
            }
        }
        System.out.println(lastBoard.sumUnmarked()*lastNum);
    }

    public static void main (String [] args){
        //first();
        second();
    }
}
