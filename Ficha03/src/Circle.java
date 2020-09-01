public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(Circle circle) {
        this.x = circle.getX();
        this.y = circle.getY();
        this.radius = circle.getRadius();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void changeCenter(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double area() {
        return Math.PI * Math.pow(this.radius,2);
    }

    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("Circle{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }
}
