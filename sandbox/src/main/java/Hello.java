
public class Hello {
    public static void main(String[] args) {
            var x =1;
            var y = 0;
            if (y == 0) {
                System.out.println("Division by zero is not allowed");;
            } else {
                var z = devide(x, y);
                System.out.println("Hello, World!");
            }
    }

    private static int devide(int x, int y) {
        var z = x / y;
        return z;
    }
}