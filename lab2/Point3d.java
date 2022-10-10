public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public Point3d (double x, double y, double z) {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }

    public Point3d () {
        this(0, 0, 0);
    }

    public double distanceTo (Point3d p) {
        double xx = this.xCoord - p.xCoord;
        double yy = this.yCoord - p.yCoord;
        double zz = this.zCoord - p.zCoord;
        return (Math.sqrt(xx*xx + yy*yy + zz*zz));
    }

    public double getX () {
        return xCoord;
    }

    public double getY () {
        return yCoord;
    }

    public double getZ () {
        return zCoord;
    }

    public void setX (double val) {
        xCoord = val;
    }

    public void setY (double val) {
        yCoord = val;

    }

    public void setZ (double val) {
        zCoord = val;
    }
}
