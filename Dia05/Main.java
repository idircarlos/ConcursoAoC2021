import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int MAX_SIZE = 1000;

    private static int [] fixedParse(String [] parse){
        int [] res = new int [parse.length];
        res [0] = Integer.parseInt(parse[0]);
        res [1] = Integer.parseInt(parse[1].substring(0,parse[1].length()-1));
        res [2] = Integer.parseInt(parse[2].substring(1));
        res [3] = Integer.parseInt(parse[3]);
        return res;
    }

    private static void printMap(int [][] map){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    

    public static void first(){
        Scanner sc = new Scanner (System.in);
        int [][] map = new int [MAX_SIZE][MAX_SIZE];
        int coords [];
        int xs [] = new int [2];
        int ys [] = new int [2];
        int counter = 0;
        while (sc.hasNextLine()){
            String [] splited = sc.nextLine().split("->|,");
            coords = fixedParse(splited);
            xs[0] = coords[0];
            xs[1] = coords[2];
            ys[0] = coords[1];
            ys[1] = coords[3];
            if (xs[0] == xs[1]){
                for (int y = Math.min(ys[0], ys[1]); y <= Math.max(ys[0], ys[1]); y++){     
                    map[y][xs[0]] = map[y][xs[0]] + 1;
                }
            }
            else if (ys[0] == ys[1]){
                for (int x = Math.min(xs[0], xs[1]); x <=  Math.max(xs[0], xs[1]); x++){
                    map[ys[0]][x] = map[ys[0]][x] + 1;
                }
            }
        }
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map.length; j++){
                if(map[i][j] >= 2){
                    counter++;
                }
            }
        }
        System.out.println(counter);
        sc.close();
    }

    public static void second(){
        
    }

    public static void main (String [] args){
        first();
        //second();
    }
}
