import java.util.HashSet;
import java.util.Set;

public class task31 {
    public static int solutions(double a, double b, double c) {
        double D = b * b - 4 * a * c;
        if (D < 0) {
            return 0;
        } else if (D == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public static int findZip(String str){
        int idx = str.indexOf("zip");
        String sub = str.substring(idx+3);

        if(!sub.contains("zip")){
            return -1;
        }

        return str.indexOf("zip", str.indexOf("zip") + 1);
    }

    public static boolean CheckPerfect(int num){
        int res = 1;

        for(int i = 2; i<num; i++){
            if (num % i == 0) {
                res+=i;
            }
        }
        return num == res;
    }

    public static String flpEndChars(String str){
        if(str.length() < 2){
            return "Incompatible.";
        }
        if(str.charAt(0) == str.charAt(str.length()-1)){
            return "Two's a pair.";
        }
        return str.charAt(str.length()-1) + str.substring(1,str.length()-1) + str.charAt(0);
    }

    public static boolean isValidHexCode(String str){
        if((str.charAt(0) != '#') || (str.length() != 7)){
            return false;
        }
        for (int i = 1; i<str.length(); i++){
            if (!(((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57) ||
                    ((int)str.charAt(i) >= 65 && (int)str.charAt(i) <= 70)||
                    ((int)str.charAt(i) >= 97 && (int)str.charAt(i) <= 102))) {
                return false;
            }
        }
        return true;
    }

    public static boolean unique(int[] arr1, int[] arr2){
        Set<Integer> set1 = new HashSet<>();
        for (int i: arr1){
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i: arr2){
            set2.add(i);
        }

        return set1.size() == set2.size();
    }

    public static boolean isKaprekar(int num){

        String sq = Integer.toString(num*num);

        if (sq.length() < 2) {
            return num == num*num;
        }

        String left = "";
        String right = "";

        for (int i = 0; i < sq.length()/2; i++){
            left+=sq.charAt(i);
        }
        right = sq.substring(left.length());
        return Integer.parseInt(left) + Integer.parseInt(right) == num;
    }

    public static String longestZero(String str){
        int max = 0;
        int cnt = 0;

        for (int i=0; i<str.length();i++){
            if(str.charAt(i) == '0'){
                cnt += 1;
                max = Math.max(cnt,max);
            }
            else {
                cnt=0;
            }
        }
        String res = "";
        for (int i = 0; i<max; i++){
            res+="0";
        }
        return res;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int nextPrime(int start){
        for(int i = start; i < start*start; i++){
            if(isPrime(i)){
                return i;
            }
        }
        return -1;
    }

    public static boolean rightTriangle(int x, int y, int z){
        return (x*x == y*y + z*z) || (y*y == x*x + z*z) || (z*z == x*x + y*y);
    }

    public static void main(String[] args) {
        System.out.println(solutions(1, 0, -1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(CheckPerfect(6));
        System.out.println(flpEndChars("C"));
        System.out.println(isValidHexCode("#VD5C5C"));
        System.out.println(unique(new int[] {1,2,3,3,3,3}, new int[] {1,2,3}));
        System.out.println(isKaprekar(297));
        System.out.println(longestZero("00011100001100000"));
        System.out.println(nextPrime(11));
        System.out.println(rightTriangle(1, 0, -1));
    }
}