package TPS.TP4.ej3_4;

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
        
        System.out.println("\n=== TESTING DIAGONAL MOVEMENTS ===");
        testDiagonalMovements();
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
    
    private static void testDiagonalMovements() {
        System.out.println("--- Testing MovablePoint diagonal movements ---");
        MovablePoint point = new MovablePoint(10, 10);
        System.out.println("Initial point: " + point);
        
        point.moveNorthEast(2, 3);
        System.out.println("After moveNorthEast(2, 3): " + point);
        
        point.moveNorthWest(1, 1);
        System.out.println("After moveNorthWest(1, 1): " + point);
        
        point.moveSouthEast(3, 2);
        System.out.println("After moveSouthEast(3, 2): " + point);
        
        point.moveSouthWest(2, 1);
        System.out.println("After moveSouthWest(2, 1): " + point);
        
        System.out.println("\n--- Testing MovableCircle diagonal movements ---");
        MovablePoint center = new MovablePoint(5, 5);
        MovableCircle circle = new MovableCircle(center, 3);
        System.out.println("Initial circle: " + circle);
        
        circle.moveNorthEast(2, 2);
        System.out.println("After moveNorthEast(2, 2): " + circle);
        
        circle.moveSouthWest(1, 3);
        System.out.println("After moveSouthWest(1, 3): " + circle);
        
        System.out.println("\n--- Testing MovableTriangle diagonal movements ---");
        MovablePoint t1 = new MovablePoint(0, 0);
        MovablePoint t2 = new MovablePoint(2, 0);
        MovablePoint t3 = new MovablePoint(1, 2);
        MovableTriangle triangle = new MovableTriangle(t1, t2, t3);
        System.out.println("Initial triangle: " + triangle);
        
        triangle.moveNorthWest(1, 2);
        System.out.println("After moveNorthWest(1, 2): " + triangle);
        
        triangle.moveSouthEast(3, 1);
        System.out.println("After moveSouthEast(3, 1): " + triangle);
    }
}
