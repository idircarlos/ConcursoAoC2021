import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int MAX_DAYS = 80;
    private static List<Integer> toIntegerList(String [] numbers){
        List <Integer> list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++){
            list.add(Integer.parseInt(numbers[i]));
        }
        return list;
    }

    public static void first(){
        Scanner sc = new Scanner(System.in);
        String [] parsed = sc.nextLine().split(",");
        List<Integer> list = toIntegerList(parsed);
        //System.out.println(list);
        int day = 0;
        while (day < MAX_DAYS){
            System.out.printf("Day %d\n",day);
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) == 0){
                    list.add(9);
                    list.set(i, 7);
                }
                list.set(i, list.get(i) - 1);
                
            }
            //System.out.printf("Day %d: %s\n",day,list);
            day++;
        }
        
        System.out.println(list.size());
    }

    public static void second(){

    }
    
    public static void main(String [] args){
        first();
        second();
    }
}
