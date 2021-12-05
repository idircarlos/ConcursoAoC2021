import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static int binaryToDecimal(String binary){
        int decimal = 0;
        int nBits = binary.length();
        for (int i = 0; i < nBits; i++){
            if(binary.charAt(i) == '1'){
                decimal = decimal + (int)Math.pow(2,nBits-i-1);
            }
        }
        return decimal;
    }

    public static void first(){
        Scanner sc = new Scanner (System.in);
        String number;
        String gamma = "";
        String epsilon = "";
        List<Integer> amountOfOnes = new LinkedList<>();
        int lines = 0;
        while(sc.hasNextLine()){
            number = sc.nextLine();
            for (int bit = 0; bit < number.length(); bit++){
                if (lines == 0){
                    amountOfOnes.add(bit, 0);
                }
                if (number.charAt(bit) == '1'){
                    amountOfOnes.set(bit,amountOfOnes.get(bit) + 1);
                }
            }
            lines++;
        }
        for (int i = 0; i < amountOfOnes.size(); i++){
            if (amountOfOnes.get(i) > lines/2){
                gamma = gamma + 1;
                epsilon = epsilon + 0;
            }
            else {
                gamma = gamma + 0;
                epsilon = epsilon + 1;
            }
        }
        sc.close();
        System.out.println(binaryToDecimal(gamma)*binaryToDecimal(epsilon));
    }

    public static void second(){
        Scanner sc = new Scanner (System.in);
        List<String> numbersOx = new LinkedList<>();
        List<String> numbersO2 = new LinkedList<>();
        List<String> auxiliarOx = new LinkedList<>();
        List<String> auxiliarO2 = new LinkedList<>();
        String finalOx = "";
        String finalO2 = "";
        int cerosOx = 0;
        int onesOx = 0;
        int cerosO2 = 0;
        int onesO2 = 0;
        int numberSize;
        while(sc.hasNextLine()){
            numbersOx.add(sc.nextLine());
        }
        numbersO2.addAll(numbersOx);
        numberSize = numbersOx.get(0).length();
        for (int i = 0; i < numberSize; i++){
            if (numbersOx.size() != 1){
                for (int j = 0; j < numbersOx.size(); j++){
                    if (numbersOx.get(j).charAt(i) == '1'){
                        onesOx++;
                    }
                    else{
                        cerosOx++;
                    }
                }
                if (onesOx > cerosOx){
                    int sizeOx = numbersOx.size();
                    for (int j = 0; j < sizeOx; j++){
                        if (numbersOx.get(j).charAt(i) == '0'){
                            auxiliarOx.add(numbersOx.get(j));
                        }
                    }
                    numbersOx.removeAll(auxiliarOx);;
                    auxiliarOx.clear();
                }
                else if (onesOx < cerosOx){
                    int sizeOx = numbersOx.size();
                    for (int j = 0; j < sizeOx; j++){
                        if (numbersOx.get(j).charAt(i) == '1'){
                            auxiliarOx.add(numbersOx.get(j));
                        }
                    }
                    numbersOx.removeAll(auxiliarOx);
                    auxiliarOx.clear();
                }
                else {
                    int sizeOx = numbersOx.size();
                    for (int j = 0; j < sizeOx; j++){
                        if (numbersOx.get(j).charAt(i) == '0'){
                            auxiliarOx.add(numbersOx.get(j));
                        }
                    }
                    numbersOx.removeAll(auxiliarOx);
                    auxiliarOx.clear();
                }
            }
            
            if (numbersO2.size() != 1) {
                for (int j = 0; j < numbersO2.size(); j++){
                    if (numbersO2.get(j).charAt(i) == '1'){
                        onesO2++;
                    }
                    else{
                        cerosO2++;
                    }
                }
                if (onesO2 > cerosO2){
                    int sizeO2 = numbersO2.size();
                    for (int j = 0; j < sizeO2; j++){
                        if (numbersO2.get(j).charAt(i) == '1'){
                            auxiliarO2.add(numbersO2.get(j));
                        }
                    }
                    numbersO2.removeAll(auxiliarO2);;
                    auxiliarO2.clear();
                }
                else if (onesO2 < cerosO2){
                    int sizeO2 = numbersO2.size();
                    for (int j = 0; j < sizeO2; j++){
                        if (numbersO2.get(j).charAt(i) == '0'){
                            auxiliarO2.add(numbersO2.get(j));
                        }
                    }
                    numbersO2.removeAll(auxiliarO2);
                    auxiliarO2.clear();
                }
                else {
                    int sizeO2 = numbersO2.size();
                    for (int j = 0; j < sizeO2; j++){
                        if (numbersO2.get(j).charAt(i) == '1'){
                            auxiliarO2.add(numbersO2.get(j));
                        }
                    }
                    numbersO2.removeAll(auxiliarO2);
                    auxiliarO2.clear();
                }
            }
            cerosOx = 0;
            onesOx = 0;
            cerosO2 = 0;
            onesO2 = 0;
        }
        finalOx = numbersOx.get(0);
        finalO2 = numbersO2.get(0);
        System.out.println(binaryToDecimal(finalO2)*binaryToDecimal(finalOx));
        sc.close();
    }

    public static void main (String [] args){
        //first();
        second();
    }
}