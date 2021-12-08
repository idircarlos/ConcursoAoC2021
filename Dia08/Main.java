import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        String [] output = new String [4];
        int counter = 0;
        while (sc.hasNextLine()){
            fillEntry(sc.nextLine(), null, output);
            int len;
            for (int i = 0; i < output.length; i++){
                len = output[i].length();
                if (len == 2 || len == 4 || len == 3 || len == 7) counter++;
            }
        }
        System.out.println(counter);
        sc.close();
    }
    
    public static void second(){
        Scanner sc = new Scanner(System.in);
        String [] signals = new String [10];
        String [] output = new String [4];
        Map<Integer,String> map = new Hashtable<Integer,String>();
        Map<String,Character> positions = new Hashtable<String,Character>();
        while (sc.hasNextLine()){
            fillEntry(sc.nextLine(), signals, output);
            initialSearch(map, signals);
            positions.put("top", getTopCharacter(map));
            System.out.println(map);
            System.out.println(positions);
            break;
        }
    }

    private static void initialSearch(Map<Integer,String> map, String[] signals){
        int len;
        for (int i = 0; i < signals.length; i++){ 
            len = signals[i].length();
            if (len == 2 || len == 4 || len == 3 || len == 7) map.put(len, signals[i]);
        }
    }

    private static Character getTopCharacter(Map<Integer,String> map){
        for (int i = 0; i < 3; i++){
            if(!stringContainsCharacter(map.get(2), map.get(3).charAt(i))) return map.get(3).charAt(i);
        }
        return null;
    }

    public static boolean stringContainsCharacter(String s, Character c){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == c){
                return true;
            }
        }
        return false;
    }

    public static void fillEntry(String entry, String [] signals, String [] output){
        String [] inTwo = entry.split("\\|");
        String [] toSignal = inTwo[0].split(" ");
        String [] toOutput = inTwo[1].split(" ");
        for (int i = 0; i < 10; i++){
            signals[i] = toSignal[i];
        }
        for (int i = 0; i < 4; i++){
            output[i] = toOutput[i+1];
        }
    }

    public static void main (String[] args){
        //first();
        second();
    }
}
