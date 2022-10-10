import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int k = 0;
        k = a % b;
        System.out.println(k);
    }
}
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int square = 0;
//        square = (a * b)/2;
//        System.out.println(square);
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int chickens = in.nextInt();
//        int cows = in.nextInt();
//        int pigs = in.nextInt();
//        int sum = 0;
//        sum = chickens*2+cows*4+pigs*4;
//        System.out.println(sum);
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        float prob = in.nextFloat();
//        int prize = in.nextInt();
//        int pay = in.nextInt();
//        if((prob*prize)-pay>0) {
//            System.out.println("True");
//        }
//        else {
//            System.out.println("False");
//        }
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int res = in.nextInt();
//        int first = in.nextInt();
//        int second = in.nextInt();
//        if(first+second == res) {
//            System.out.println("сложить");
//        }
//        else if(first*second == res) {
//            System.out.println("умножить");
//        }
//        else if(first/second == res) {
//            System.out.println("разделить");
//        }
//        else if(first-second == res) {
//            System.out.println("вычесть");
//        }
//        else {
//            System.out.println("none");
//        }
//    }
//}
//
//
//import java.io.IOException;
//
//public class task1 {
//    public static void main(String[] args) throws IOException{
//        char ch;
//        ch = (char) System.in.read();
//
//        int ascii = ch;
//        System.out.println(ascii);
//
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        float prob = in.nextFloat();
//        int prize = in.nextInt();
//        int pay = in.nextInt();
//        if((prob*prize)-pay>0) {
//            System.out.println("True");
//        }
//        else {
//            System.out.println("False");
//        }
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int a = in.nextInt();
//        int sum = 0;
//        for(int i=1; i<=a; i++) {
//            sum+=i;
//        }
//        System.out.println(sum);
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int c = 0;
//        c = a+b-1;
//        System.out.println(c);
//    }
//}
//
//
//public class task1 {
//    public static int sumOfCubes(int [] arr) {
//        int num1 = arr[0];
//        int num2 = arr[1];
//        int num3 = arr[2];
//
//        return num1*num1*num1 + num2*num2*num2 + num3*num3*num3;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[3];
//        arr[0] = 1;
//        arr[1] = 5;
//        arr[2] = 9;
//
//        System.out.println(sumOfCubes(arr));
//    }
//}
//
//
//import java.util.Scanner;
//
//public class task1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int c = in.nextInt();
//        int sum = 0;
//        for(int i=1; i<=b; i++) {
//            a=a*2;
//        }
//        System.out.println(a%c==0);
//    }
//}