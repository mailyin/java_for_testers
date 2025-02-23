public class Geometry {
    public static void main(String[] args) {
        printSquareArea(7.3);
        printSquareArea(5.2);
        printSquareArea(3.6);

        printRectangleArea(3.8, 5.4);
        printRectangleArea(3.2, 5.9);
    }

    private static void printRectangleArea(double b, double c) {
        System.out.println("Площадь прямоугольника со сторонами " + b + " и " + c + " = " + rectangleArea(b, c));
    }

    private static double rectangleArea(double b, double c) {
        return b * c;
    }

    static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }

    private static double squareArea(double a) {
        return a * a;
    }

}
