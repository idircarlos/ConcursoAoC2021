import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int MAX_SIZE = 10;

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
        while (sc.hasNextLine()){
            String [] splited = sc.nextLine().split("->|,");
            coords = fixedParse(splited);
            if (coords[0] == coords[2]){
                for (int p = coords[1]; p < coords[3]; p++){
                    map[coords[0]][p] = map[coords[0]][p] + 1;
                }
            }
            else if (coords[1] == coords[3]){
                for (int p = coords[0]; p < coords[2]; p++){
                    map[coords[1]][p] = map[coords[1]][p] + 1;
                }
            }
            printMap(map);
        }
        
    }

    public static void second(){
        
    }

    public static void main (String [] args){
        first();
        //second();
    }
}
