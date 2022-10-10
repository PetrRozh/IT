import java.util.Scanner;

public class Lab1 {

    public static void main (String[] args) {
        Point3d[] threePoints = new Point3d[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            double[] point = new double[3];
            for(int j = 0; j<3;++j){
                System.out.println("point" + i + " " + (char)(120+j) + "Coord: ");
                point[j] = sc.nextDouble();
            }
            System.out.println();
            threePoints[i] = new Point3d(point[0],point[1],point[3]);
        }
        if(!threePoints[0].equals(threePoints[1]) && !threePoints[1].equals(threePoints[2]) && !threePoints[2].equals(threePoints[0])) {
            double res = computeArea(threePoints[0],threePoints[1],threePoints[2]);
            System.out.println(res);
        }
        else {
            System.out.println("Eror");
        }
        sc.close();
    }

    public static double computeArea (Point3d p1, Point3d p2, Point3d p3) {
        double a = p1.distanceTo(p2);
        double b = p2.distanceTo(p3);
        double c = p3.distanceTo(p1);
        double per = ((a+b+c)/2);
        return (Math.sqrt(per*(per-a)*(per-b)*(per-c)));
    }
}