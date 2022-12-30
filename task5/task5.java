import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class task5 {
    public static int[] encrypt(String s){
        int[] res = new int[s.length()];
        int lastChar = 0;

        for(int i =0; i<s.length(); i++){
            res[i] = s.charAt(i) - lastChar;
            lastChar = (int) s.charAt(i);
        }
        return res;
    }

    public static String decrypt(int[] s){
        char[] res = new char[s.length];
        int lastChar = 0;

        for(int i=0; i<s.length; i++){
            res[i] = (char)(lastChar+s[i]);
            lastChar = res[i];
        }
        return new String(res);
    }

    public static boolean canMove(String figure, String from, String to){
        int from_x = (int) from.charAt(0);
        int from_y = Integer.parseInt(String.valueOf(from.charAt(1)));
        int to_x = (int) to.charAt(0);
        int to_y = Integer.parseInt(String.valueOf(to.charAt(1)));

        return switch (figure){
            case ("Horse") -> (
                    (Math.abs(from_x-to_x) == 1 && Math.abs(from_y-to_y) == 2) ||
                            (Math.abs(from_y-to_y) == 1 && Math.abs(from_x-to_x) == 2)
                    );
            case ("Bishop") -> (
                    ((from_x-from_y) == (to_x-to_y)) ||
                            ((from_x+from_y) == (to_x+to_y))
                    );
            case ("Queen") -> (
                    ((from_y == to_y) && (from_x != to_x)) ||
                            (from_y != to_y && from_x == to_x) ||
                            (from_x - from_y) == (to_x - to_y) ||
                            (from_x+from_y) == (to_x+to_y)
                    );
            case ("Rook") -> (
                    (from_y == to_y && from_x != to_x) ||
                            (from_y != to_y && from_x == to_x)
            );
            case ("Pawn") -> ((from_x == to_x) && ((to_y - from_y) == 1));
            case ("King") -> (Math.abs(from_x - to_x) <= 1) && (Math.abs(from_y - to_y) <= 1);
            default -> false;
        };
    }

    public static boolean canComplete(String s1, String s2){
        int j = 0;

        for(int i = 0; i<s2.length(); i++){
            if (s1.charAt(j) == s2.charAt(i)){
                j++;
                if (j == s1.length()){
                    return true;
                }
            }
        }
        return false;
    }

    public static int sumDigProd(int... args){
        int sum = Arrays.stream(args).sum();
        String str = Integer.toString(sum);

        if(str.length() == 1)
            return sum;

        int p = 1;
        while (str.length() != 1){
            p = 1;

            for(int i =0; i < str.length(); i++){
                p *= Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            str = Integer.toString(p);
        }
        return p;
    }

    public static String[] sameVowelGroup(String[] words){

        String[] glasn = new String[] {"a", "e", "i", "o", "u", "w", "y"};
        HashSet<String> list1 = new HashSet<>();
        HashSet<String> listWord;
        ArrayList<String> res = new ArrayList<>();
        res.add(words[0]);

        for(int i = 0; i < words[0].length(); i++){
            if(List.of(glasn).contains(String.valueOf(words[0].charAt(i)))){
                list1.add(String.valueOf(words[0].charAt(i)));
            }
        }

        for(int i = 1; i < words.length; i++){

            listWord = new HashSet<>();

            for(int k = 0; k < words[i].length(); k++){
                if(List.of(glasn).contains(String.valueOf(words[i].charAt(k)))){
                    listWord.add(String.valueOf(words[i].charAt(k)));
                }
            }
            if(list1.equals(listWord)){
                res.add(words[i]);
            }

        }
        System.out.println(res.toString());
        return res.toArray(new String[0]);

    }

    public static boolean validateCard(long card){

        if((String.valueOf(card).length() < 14) || (String.valueOf(card).length() > 19))
            return false;

        String str =  String.valueOf(card);

        //убрали последний
        int control = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));

        str = str.substring(0, str.length() - 1);
        // перевернули слово
        str = new StringBuilder(str).reverse().toString();

        //считаем сумму
        int sum = 0;
        int digit;

        for(int i = 0; i < str.length(); i++){
            if(i % 2 == 1) {
                digit = Integer.parseInt(String.valueOf(str.charAt(i)));
            }else{
                digit = 2*Integer.parseInt(String.valueOf(str.charAt(i)));

                if(digit % 10 != digit){
                    digit = digit%10 + 1;
                }

            }

            sum += digit;

        }

        return control == (10 - Integer.parseInt(String.valueOf(String.valueOf(sum).charAt(String.valueOf(sum).length() - 1))));

    }

    public static String numToEng(int num){
        class Transformer {
            String oneNumberToString(int n) {
                switch (n) {
                    case 1:
                        return "one";
                    case 2:
                        return "two";
                    case 3:
                        return "three";
                    case 4:
                        return "four";
                    case 5:
                        return "five";
                    case 6:
                        return "six";
                    case 7:
                        return "seven";
                    case 8:
                        return "eight";
                    case 9:
                        return "nine";
                    default:
                        return null;
                }
            }
            String decToString(int decCount) {
                switch (decCount) {
                    case 2:
                        return "twenty";
                    case 3:
                        return "thirty";
                    case 4:
                        return "forty";
                    case 5:
                        return "fifty";
                    case 6:
                        return "sixty";
                    case 7:
                        return "seventy";
                    case 8:
                        return "eighty";
                    case 9:
                        return "ninety";
                    default:
                        return null;
                }
            }
            String dec1ToString(int n) {
                switch (n) {
                    case 0:
                        return "ten";
                    case 1:
                        return "eleven";
                    case 2:
                        return "twelve";
                    case 3:
                        return "thirteen";
                    case 4:
                        return "fourteen";
                    case 5:
                        return "fifteen";
                    case 6:
                        return "sixteen";
                    case 7:
                        return "seventeen";
                    case 8:
                        return "eighteen";
                    case 9:
                        return "nineteen";
                    default:
                        return null;
                }
            }
        }

        int hundred = (num / 100)%10;
        int dec = (num / 10) %10;
        int n = num % 10;

        Transformer transformer = new Transformer();

        String hundredString = transformer.oneNumberToString(hundred);
        String nString = null;
        String decString;

        if (dec != 1) {

            if (n == 0) {
                nString = "zero";
            }else{
                nString = transformer.oneNumberToString(n);
            }

            decString = transformer.decToString(dec);

        } else {
            decString = transformer.dec1ToString(n);
        }

        String res = "";
        if(hundredString != null){
            res += hundredString + " hundred ";
        }
        if(decString != null){
            res += decString + " ";
        }
        if(nString != null){
            res += nString;
        }

        return res;
    }

    public static String getSha256Hash(String str){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

            String res = "";
            for(byte b: hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    res += "0";
                }
                res += hex;
            }
            return res;

        } catch (Exception e) {
            return null;
        }
    }

    public static String correctTitle(String str){

        String[] words = str.toLowerCase().split(" ");
        String res = "";

        for(String word: words){
            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the"))
                res += word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
            else
                res += word.toLowerCase() + " ";
        }
        return res;
    }

    public static String hexLattice(int n) {
        //проверка на коректность
        int numIters = 1;
        int correct = 1;

        while (correct < n) {
            correct += 6 * numIters;
            numIters++;
        }
        if (correct != n)
            return "недопустимое";

        //size - размер по вертикали
        //sizewithSpace - размер середины по горизонтали с пробелами(то есть макисмальная)
        int size = numIters * 2 - 1;
        int sizeWithSpaces = size * 2 - 1;
        String[] hex = new String[size];

        for (int i = numIters - 1; i >= 0; i--) {
            int rowSizeWithSpaces = (numIters + i) * 2 - 1;
            int space = (sizeWithSpaces - rowSizeWithSpaces) / 2;
            hex[i] = " ".repeat(space) + "o ".repeat(numIters + i);

            if (i != numIters) {
                hex[size - i - 1] = hex[i];
            }
        }
        String res = "";
        for (String s : hex) {
            res += s + "\n";
        }
        return res;
    }

    public static void main(String[] args){
//        System.out.println(Arrays.toString(encrypt("Hello")));
//        System.out.println(decrypt(new int [] { 72, 33, -73, 84, -12, -3, 13, -13, -68 }));
//        System.out.println(canMove("Queen", "C4", "D6"));
//        System.out.println(canComplete("buje", "beautifule"));
//        System.out.println(sumDigProd(16, 28));
//        sameVowelGroup(new String[] {"hoops", "chuff", "bot", "bottom"});
//        System.out.println(validateCard(1234567890123452L));
//        System.out.println(numToEng(10));
//        System.out.println(getSha256Hash("password123"));
//        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
//        System.out.println(hexLattice(19));
    }
}
