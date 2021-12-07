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

    public static int first(List<Integer> lanterfishes){
        return firstAux(lanterfishes);
    }

    public static int firstAux(List<Integer> lanterfishes){
        int ret = lanterfishes.size();
        for(int i = 0; i < lanterfishes.size(); i++){
            ret = ret + howManyChildsFrom(lanterfishes.get(i), 0, 0, 0);
        }
        System.out.println(ret);
        return 0;
    }

    public static int howManyChildsFrom(Integer initialState, Integer actualDay, Integer total, Integer id){
        int cycles = initialState - MAX_DAYS + actualDay;
        while (cycles < 0 && actualDay <= MAX_DAYS){
            cycles = cycles + 7;
            actualDay = actualDay + 7;
            total = howManyChildsFrom(8 - (6 - initialState), actualDay, total+1, id+1); //Cycle (8) - (6 days - initialState)
        }
        return total;
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] parsed = sc.nextLine().split(",");
        List<Integer> list = toIntegerList(parsed);
        first(list);
        //second(list);
        sc.close();
    }
}
