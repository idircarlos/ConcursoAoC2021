import java.util.Scanner;

public class Main {

    public static void first(){
        Scanner sc = new Scanner (System.in);
        int prevValue = Integer.parseInt(sc.nextLine());
        int nextValue;
        int cont = 0;
        while (sc.hasNextLine()){
            nextValue = Integer.parseInt(sc.nextLine());
            if (nextValue >= prevValue){
                cont++;
            }
            prevValue = nextValue;
        }
        sc.close();
        System.out.println(cont);
    }

    public static void second(){
        Scanner sc = new Scanner (System.in);
        int firstValue = Integer.parseInt(sc.nextLine());
        int secondValue = Integer.parseInt(sc.nextLine());
        int thirdValue = Integer.parseInt(sc.nextLine());
        int prevValue = firstValue + secondValue + thirdValue;
        firstValue = secondValue;
        secondValue = thirdValue;
        int nextValue = 0;
        int cont = 0;
        while (sc.hasNextLine()){
            thirdValue = Integer.parseInt(sc.nextLine());
            nextValue = firstValue + secondValue + thirdValue;
            if (nextValue > prevValue){
                cont++;
            }
            firstValue = secondValue;
            secondValue = thirdValue;
            prevValue = nextValue;
        }
        sc.close();
        System.out.println(cont);
    }

    public static void main (String [] args){
        // first();
        // second();
    }
}