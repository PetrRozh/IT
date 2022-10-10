public class Palindrom {
    public static void main(String[] args) {
        String s = "java Palindrome madam racecar apple kayak song noon";
        String[] words = s.split(" ");
        for(String word : words){
            if (isPalindrome(word)){
                System.out.println(word+"- ПОЛИНДРОМ");
            }
            else{
                System.out.println(word+"- НЕ ПОЛИНДРОМ");
            }
        }}
    public static String reverseString(String s) {
        String result = "";
        for(int i = 1; i <= s.length(); i++) {
            result+= s.charAt(s.length()-i);
        }
        return result;
    }
    public static boolean isPalindrome(String s) {
        if(s.equals(reverseString(s))) {
            return true;
        }
        return false;
    }
}

