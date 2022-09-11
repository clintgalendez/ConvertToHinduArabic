import java.util.Scanner;
//Clint Jonathan A. Galendez
//BSCS 2 - CSCC 20 A
class convertFormat{
    public int toHinArab(String romanNumeral) throws Exception {
        int finalValue = 0;

        for (int i = 0; i < romanNumeral.length(); i++){
            switch (romanNumeral.charAt(i)) {
                case 'I' -> finalValue += 1;
                case 'V' -> finalValue += 5;
                case 'X' -> finalValue += 10;
                case 'L' -> finalValue += 50;
                case 'C' -> finalValue += 100;
                case 'D' -> finalValue += 500;
                case 'M' -> finalValue += 1000;
                default -> throw new Exception("Invalid Roman Numeral");
            }

            if (i > 0 && (romanNumeral.charAt(i) == 'V' || romanNumeral.charAt(i) == 'X') && romanNumeral.charAt(i - 1) == 'I') {
                finalValue -= 2;
            }

            if (i > 0 && (romanNumeral.charAt(i) == 'L' || romanNumeral.charAt(i) == 'C') && romanNumeral.charAt(i - 1) == 'X') {
                finalValue -= 20;
            }

            if (i > 0 && (romanNumeral.charAt(i) == 'D' || romanNumeral.charAt(i) == 'M') && romanNumeral.charAt(i - 1) == 'C') {
                finalValue -= 200;
            }
        }
        return finalValue;
    }
}

public class PE_Galendez {
    public static void main(String[] args){
        convertFormat convert = new convertFormat();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a Roman Numeral: ");
            String romanNumeral = input.nextLine().toUpperCase();
            try {
                System.out.println("Converted Number: " + convert.toHinArab(romanNumeral));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}