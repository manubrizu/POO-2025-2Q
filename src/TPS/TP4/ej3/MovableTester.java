package TPS.TP4.ej3;

public class MovableTester {
    public static void main(String[] args) {
        System.out.println("=== TESTING MOVABLE POINT ===");
        testMovablePoint();
        
        System.out.println("\n=== TESTING MOVABLE CIRCLE ===");
        testMovableCircle();
        
        System.out.println("\n=== TESTING MOVABLE RECTANGLE ===");
        testMovableRectangle();
        
        System.out.println("\n=== TESTING MOVABLE TRIANGLE ===");
        testMovableTriangle();
        
        System.out.println("\n=== TESTING MOVABLE ELLIPSE ===");
        testMovableEllipse();
    }
    
    private static void testMovablePoint() {
        MovablePoint point = new MovablePoint(5, 3);
        System.out.println("Initial point: " + point);
        
        point.moveNorth(2);
        System.out.println("After moveNorth(2): " + point);
        
        point.moveSouth(1);
        System.out.println("After moveSouth(1): " + point);
        
        point.moveEast(3);
        System.out.println("After moveEast(3): " + point);
        
        point.moveWest(2);
        System.out.println("After moveWest(2): " + point);
    }
    
    private static void testMovableCircle() {
        MovablePoint center = new MovablePoint(0, 0);
        MovableCircle circle = new MovableCircle(center, 5);
        System.out.println("Initial circle: " + circle);
        
        circle.moveNorth(3);
        System.out.println("After moveNorth(3): " + circle);
        
        circle.moveEast(2);
        System.out.println("After moveEast(2): " + circle);
    }
    
    private static void testMovableRectangle() {
        MovablePoint topLeft = new MovablePoint(1, 4);
        MovablePoint bottomRight = new MovablePoint(6, 1);
        MovableRectangle rectangle = new MovableRectangle(topLeft, bottomRight);
        System.out.println("Initial rectangle: " + rectangle);
        
        rectangle.moveSouth(2);
        System.out.println("After moveSouth(2): " + rectangle);
        
        rectangle.moveWest(1);
        System.out.println("After moveWest(1): " + rectangle);
    }
    
    private static void testMovableTriangle() {
        MovablePoint p1 = new MovablePoint(0, 0);
        MovablePoint p2 = new MovablePoint(3, 0);
        MovablePoint p3 = new MovablePoint(1.5, 2.6);
        MovableTriangle triangle = new MovableTriangle(p1, p2, p3);
        System.out.println("Initial triangle: " + triangle);
        
        triangle.moveNorth(1);
        System.out.println("After moveNorth(1): " + triangle);
        
        triangle.moveEast(2);
        System.out.println("After moveEast(2): " + triangle);
    }
    
    private static void testMovableEllipse() {
        MovablePoint center = new MovablePoint(2, 3);
        MovableEllipse ellipse = new MovableEllipse(center, 4, 2);
        System.out.println("Initial ellipse: " + ellipse);
        
        ellipse.moveWest(1);
        System.out.println("After moveWest(1): " + ellipse);
        
        ellipse.moveSouth(2);
        System.out.println("After moveSouth(2): " + ellipse);
    }
}
