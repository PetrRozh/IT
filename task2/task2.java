import java.util.Arrays;

public class task2 {
    public static String repeat(String str, int cnt) {
        String res ="";
        for(int i=0; i<str.length();i++){
            for(int j = 0; j<cnt ; j++){
                res+=str.charAt(i);
            }
        }
        return res;
    }
    public static int differenceMaxMin(int[] arr){
        return(Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt());
    }

    public static boolean isAvgWhole(int[] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum=sum+arr[i];
        }
        return sum % arr.length == 0;
    }

    public static int[] cumulativeSum(int[] arr){
        int[] res= new int[arr.length];
        res[0]=arr[0];
        for(int i = 1; i<arr.length; i++){
            res[i] = arr[i]+res[i-1];
        }
        return res;
    }

    public static int getDecimalPlaces(String num){
        for(int i = 0; i < num.length();i++){
            if (num.charAt(i) == '.'){
                return num.length()-i-1;
            }
        }
        return 0;
    }

    public static int Fibonacci(int fib){
        if (fib == 1){
            return 1;
        }
        if (fib == 2){
            return 2;
        }
        return Fibonacci(fib-1)+Fibonacci(fib-2);
    }

    public static boolean isValid(String adr){
        for(char i = 0; i < adr.length(); i++){
            if((int)(adr.charAt(i))<48 || (int)(adr.charAt(i))>57) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStrangePair(String str1, String str2){
        if(str1.charAt(0) == str2.charAt(str2.length()-1) && str1.charAt(str1.length()-1) == str2.charAt(0)){
            return true;
        }
        return false;
    }

    public static boolean isPrefix(String word, String pref){
        for(char i=0; i<pref.length()-1; i++){
            if(word.charAt(i)==pref.charAt(i)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static boolean isSuffix(String word, String suf) {
        for(int i=suf.length()-1; i>0;i--) {
            if(word.charAt(word.length()-suf.length()+i)!=suf.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static int boxSeq(int step){
        int res=0;
        for(int i =1; i <= step; i++){
            if (i%2 == 1){
                res += 3;
            }
            else{
                res -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(repeat("ght", 3));
        System.out.println(differenceMaxMin(new int[] {1,2,3,4,67}));
        System.out.println(isAvgWhole(new int[] {1,1,1}));
        int[] res = cumulativeSum(new int[] {1,2,3});
        for(int i:res){
            System.out.print(i);
            System.out.print(";");
        }
        System.out.println();
        System.out.println(getDecimalPlaces("55"));
        System.out.println(Fibonacci(1));
        System.out.println(isValid("12lk"));
        System.out.println(isStrangePair("ratio","orator"));
        System.out.println(isPrefix("automation","auto-"));
        System.out.println(isSuffix("arachnophobia","-phobia"));
        System.out.println(boxSeq(2));
    }
}

