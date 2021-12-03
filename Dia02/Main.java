import java.util.Scanner;

public class Main {
    public static void first(){
        Scanner sc = new Scanner (System.in);
        int horizontal = 0;
        int depth = 0;
        while(sc.hasNextLine()){
            String [] splited = sc.nextLine().split(" ");
            switch (splited[0]){
                case "forward":
                    horizontal = horizontal + Integer.parseInt(splited[1]);
                    break;
                case "down":
                    depth = depth + Integer.parseInt(splited[1]);
                    break;
                case "up":
                    depth = depth - Integer.parseInt(splited[1]);
                    break;
            }
        }
        sc.close();
        System.out.println(horizontal*depth);
    }

    public static void second(){
        Scanner sc = new Scanner (System.in);
        int aim = 0;
        int horizontal = 0;
        int depth = 0;
        while(sc.hasNextLine()){
            String [] splited = sc.nextLine().split(" ");
            switch (splited[0]){
                case "forward":
                    horizontal = horizontal + Integer.parseInt(splited[1]);
                    depth = depth + aim*Integer.parseInt(splited[1]);
                    break;
                case "down":
                    aim = aim + Integer.parseInt(splited[1]);
                    break;
                case "up":
                    aim = aim - Integer.parseInt(splited[1]);
                    break;
            }
        }
        sc.close();
        System.out.println(horizontal*depth);
    }

    public static void main (String [] args){
        //first();
        second();
    }
}