public class task1_2 {

    public static int remainder(int a, int b) {
        return a % b;
    }

    public static int triArea(int a, int b) {
        return (a * b) / 2;
    }

    public static int animals(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4;
    }

    public static boolean profitableGamble(double prob, int prize, int pay) {
        return ((prob * prize) - pay) > 0;
    }

    public static String operation(int first, int second, int res) {
        if (first + second == res) {
            return ("сложить");
        } else if (first * second == res) {
            return ("умножить");
        } else if (first / second == res) {
            return ("разделить");
        } else if (first - second == res) {
            return ("вычесть");
        } else {
            return ("none");
        }
    }

    public static int ctoa(char ch) {
        int ascii = ch;
        return (ascii);
    }


    public static int addUpTo(int a) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        return (sum);
    }

    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }

    public static int sumOfCubes(int[] arr) {
        int s = 0;
        for(int i: arr){
            s+=i*i*i;
        }

        return s;
    }

    public static boolean abcmath(int a, int b, int c) {
        for(int i=1; i<=b; i++) {
            a=a*2;
        }
        return a%c==0;
    }

    public static void main(String[] args) {
        System.out.println(remainder(1, 3));
        System.out.println(triArea(3,2));
        System.out.println(animals(2,3,5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(operation(24, 15, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(nextEdge(8, 10));
        System.out.println(sumOfCubes(new int[]  {1, 5, 9}));
        System.out.println(abcmath(42, 5, 10));
    }
}
