package frc.robot;

public class Coordinate {
    private double m_x;
    
    /** 
     * @return x-value of Coordinate
     */
    public double getX() {
        return m_x;
    }
    
    /** 
     * @param x the new x-value of Coordinate
     */
    public void setX(double x) {
        m_x = x;
    }
    
    private double m_y;
    
    /** 
     * @return y-value of Coordinate
     */
    public double getY() {
        return m_y;
    }
    
    /** 
     * @param y the new y-value of Coordinate
     */
    public void setY(double y) {
        m_y = y;
    }

    /**
     * Constructs a new Coordinate at the point (0, 0)
     */
    public Coordinate() {
        m_x = 0;
        m_y = 0;
    }

    /**
     * Constructs a new Corodinate at the point (x, y)
     * @param x x-value of coordiate
     * @param y y-value of coordinate
     */
    public Coordinate(double x, double y) {
        m_x = x;
        m_y = y;
    }

    
    /** 
     * @param c1 (x1, y1)
     * @param c2 (x2, y2)
     * @return a new Coordinate at the point (x2 - x1, y2 - y1)
     */
    public static Coordinate difference(Coordinate c1, Coordinate c2) {
        return new Coordinate(c2.getX() - c1.getX(), c2.getY() - c1.getY());
    }

    /** 
     * @param c1 (x1, y1)
     * @param c2 (x2, y2)
     * @return a new Coordinate at the midpoint between c1 and c2
     */
    public static Coordinate midpoint(Coordinate c1, Coordinate c2) {
        return new Coordinate((c1.getX() + c2.getX()) * 0.5, (c1.getY() + c2.getY()) * 0.5);
    }

    /** 
     * @param c1 (x1, y1)
     * @param c2 (x2, y2)
     * @return the distance between c1 and c2
     */
    public static double distance(Coordinate c1, Coordinate c2) {
        return Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));
    }

    /** 
     * @param c1 vertex (x1, y1)
     * @param c2 terminal (x2, y2)
     * @return the angle betweem c1 and c2 in radians
     */
    public static double thetaRad(Coordinate c1, Coordinate c2) {
        return Math.atan((c2.getY() - c1.getY()) / (c2.getX() - c1.getX()));
    }

    /** 
     * @param c1 vertex (x1, y1)
     * @param c2 terminal (x2, y2)
     * @return the angle betweem c1 and c2 in degrees
     */
    public static double thetaDeg(Coordinate c1, Coordinate c2) {
        return Math.atan((c2.getY() - c1.getY()) / (c2.getX() - c1.getX())) * 57.295779513082325; //180 / pi
    }
}
