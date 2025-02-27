public class Probe {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double c = 5;
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p-a) * (p-b) * (p-c));
        System.out.println("S равняется " + s);
    }
}
