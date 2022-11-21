import java.util.*;

public class task4 {

    public static void Bessie(int n, int k, String str){

        String[] words = str.split(" ");
        String strs = words[0];
        int len = strs.length();

        for(int i = 1; i < n; i++){
            if(len + words[i].length() > k){
                System.out.println(strs);
                strs = words[i];
                len = words[i].length();
            }
            else{
                strs = strs + " " + words[i];
                len += words[i].length();
            }
        }

        if(len < k){
            System.out.println(strs);
        }
    }
    public static String[] split(String str){

        List<String> res = new ArrayList<>();
        String now = "";
        int now_len = 0;
        int len = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ')'){
                now_len += 1;
                now += str.charAt(i);
                if(now_len == len) {
                    res.add(now);
                    now = "";
                    len = 0; now_len = 0;
                }
            }else{
                now += str.charAt(i);
                len += 1;
            }
        }
        System.out.println(res.toString());
        return res.toArray(new String[0]);
    }

    public static String toCamelCase(String str){
        String res = "";

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) != '_'){
                res+= str.charAt(i);
            }
            else {
                res+=str.substring(i+1, i+2).toUpperCase(Locale.ROOT);
                i+=1;
            }
        }
        return res;
    }
    
    public static String toSnakeCase(String str){
        String res = "";
        
        for (int i=0; i<str.length(); i++){
            if(!Character.isUpperCase(str.charAt(i))){
                res+=str.charAt(i);
            }
            else{
                res += "_" + str.substring(i, i+1).toLowerCase();
            }
        }
        return res;
    }

    public static String overTime(double[] arr){
        double res = (17-arr[0])*arr[2];
        if(arr[1] > 17){
            res+=(arr[1] - 17)*arr[2]*arr[3];
        }
        else{
            res-=(17-arr[1])*arr[2];
        }
        return "$" + res;
    }

    public static String BMI(String str1, String str2){
        String[] weight = str1.split(" ");
        String[] height = str2.split(" ");
        double rost = 0;
        double ves = 0;
        System.out.println(Arrays.stream(weight).toArray()[1]);
        if("pounds".equals(weight[1])){
            ves = Integer.parseInt(weight[0])/2.205;
        }
        else{
            ves = Integer.parseInt(weight[0]);
        }
        if("inches".equals(height[1])){
            rost = Double.parseDouble(height[0])/39.37;
        }
        else{
            rost = Double.parseDouble(height[0]);
        }

        double bmi = Math.ceil((ves/(rost*rost)) * Math.pow(10, 1)) / Math.pow(10, 1);

        if(bmi < 18.5){
            return bmi + " Underweight";
        }
        else if(bmi >= 25){
            return bmi + " Overweight";
        }
        else{
            return bmi + " Normal weight";
        }
    }

    public static int bugger(int num){
        String cur = String.valueOf(num);
        int cur_res = 1;
        int iters = 0;

        while(cur.length() != 1){
            iters+=1;

            for(int i =0; i<cur.length();i++){
                cur_res *= Integer.parseInt(String.valueOf(cur.charAt(i)));
            }
            cur = String.valueOf(cur_res);
            cur_res = 1;
        }
        return iters;
    }

    public static String toStarShorthand(String chars){
        String res = "";
        int i = 0;

        while(i < chars.length()){
            char curr = chars.charAt(i);
            int count= 0;

            while(i < chars.length() && chars.charAt(i) == curr){
                i++;
                count++;
            }

            res += curr;
            if(count != 1){
                res += "*"+count;
            }
        }
        return res;
    }

    public static boolean doesRhyme(String s1, String s2){
        String word1 = s1.split(" ")[s1.split(" ").length - 1].toLowerCase();
        String word2 = s2.split(" ")[s2.split(" ").length - 1].toLowerCase();

        char[] glasn = new char[] {'a', 'e', 'i', 'o', 'u', 'w', 'y'};

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < word1.length(); i++){
            for(int k = 0; k < glasn.length; k++){
                if(word1.charAt(i) == glasn[k]){list1.add((int)glasn[k]);}
            }
        }
        for(int i = 0; i < word2.length(); i++){
            for(int k = 0; k < glasn.length; k++){
                if(word2.charAt(i) == glasn[k]){list2.add((int)glasn[k]);}
            }
        }

        return list1.equals(list2);
    }

    public static boolean trouble(int num1, int num2){
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int i = 1;
        int cnt = 1;

        while(i<s1.length()) {
            while (i < s1.length() && s1.charAt(i - 1) == s1.charAt(i)) {
                cnt += 1;
                i += 1;
            }
            if (cnt == 3) {
                list1.add(Integer.parseInt(String.valueOf(s1.charAt(i - 1))));
            }
            cnt = 1;
            i += 1;
        }

        i=1;
        cnt =1;
        while (i<s2.length()){
            while (i < s2.length() && s2.charAt(i - 1) == s2.charAt(i)) {
                cnt+=1;
                i+=1;
            }
            if(cnt == 2){
                list2.add(Integer.parseInt(String.valueOf(s2.charAt(i-1))));
            }
            cnt =1;
            i+=1;
        }
        if(!list1.isEmpty()){
            for (int j : list1) {
                if (list2.contains(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countUniqueBooks(String stringSeq, char bookEnd){

        Set<String> set = new HashSet<String>();
        boolean flag = true;
        int cnt = 0;

        for (int i =0; i<stringSeq.length(); i++){
            if(stringSeq.charAt(i) == bookEnd){
                cnt+=1;
            }
            if(cnt%2!=0 && stringSeq.charAt(i)!=bookEnd){
                set.add(String.valueOf(stringSeq.charAt(i)));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Bessie(10, 7, "hello my name is Bessie and this is my essay");
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(toCamelCase("ghost_buster"));
        System.out.println(toSnakeCase("ghostBuster"));
        System.out.println(overTime(new double[] {9, 17, 30, 1.5}));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(bugger(9));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        System.out.println(trouble(666789, 12345667));
        System.out.println(countUniqueBooks("ZDDDZABCDZEFZ", 'Z'));
    }
}
