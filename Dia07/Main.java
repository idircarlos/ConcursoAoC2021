import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Integer> toIntegerList(String [] numbers){
        List <Integer> list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++){
            list.add(Integer.parseInt(numbers[i]));
        }
        return list;
    }

    public static void first(List<Integer> horizontal){
        int min = -1;
        int sum = 0;
        for (int i = 0; i < horizontal.size(); i++){
            for (int j = 0; j < horizontal.size(); j++){
                sum = sum + Math.abs(horizontal.get(j) - horizontal.get(i));
            }
            if (min == -1) min = sum;
            else if (sum < min) min = sum;
            sum = 0;
        }
        System.out.println(min);
    }

    public static void second(List<Integer> horizontal){
        long min = -1;
        long sum = 0;
        for (int i = 0; i < horizontal.size(); i++){
            for (int j = 0; j < horizontal.size(); j++){
                sum = sum + sumFactorial(Math.abs(horizontal.get(j) - horizontal.get(i)));
            }
            if (min == -1) min = sum;
            else if (sum < min) min = sum;
            sum = 0;
        }
        System.out.println(min);
    }

    public static long sumFactorial (long num){
        long res = 0;
        for (int i = 1; i <= num; i++){
            res = res + i;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        List<Integer> list = toIntegerList(sc.nextLine().split(","));
        //first(list);
        second(list);


    }
}

