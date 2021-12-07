import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int MAX_DAYS = 256;

    private static List<Integer> toIntegerList(String [] numbers){
        List <Integer> list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++){
            list.add(Integer.parseInt(numbers[i]));
        }
        return list;
    }

    public static void solve(List<Integer> lanterfishes){
        long ret = lanterfishes.size();
        Long [] memo = new Long [7];
        for(int i = 0; i < lanterfishes.size(); i++){
            if(memo[lanterfishes.get(i)] != null){
                ret = ret + memo[lanterfishes.get(i)];
            }
            else {
                memo[lanterfishes.get(i)] = howManyChildsFrom(lanterfishes.get(i), 0, 0L);
                ret = ret + memo[lanterfishes.get(i)];
            }
        }
    }

    public static long howManyChildsFrom(Integer initialState, Integer actualDay, Long total){
        int cycles = initialState - MAX_DAYS + actualDay;
        while (cycles < 0 && actualDay <= MAX_DAYS){
            cycles = cycles + 7;
            actualDay = actualDay + 7;
            total = howManyChildsFrom(8 - (6 - initialState), actualDay, total+1); //Cycle (8) - (6 days - initialState)
        }
        return total;
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] parsed = sc.nextLine().split(",");
        List<Integer> list = toIntegerList(parsed);
        solve(list);
        sc.close();
    }
}