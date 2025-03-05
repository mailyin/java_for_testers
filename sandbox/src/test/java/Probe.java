public class Probe {
    public static void main(String[] args) {


        class Pet {
            int weight;
            String name;
            String type;
        }


        Pet animal = new Pet();
        animal.type = "Cat";
        animal.name = "Richard";
        animal.weight = 10;

        System.out.println(
                "Домашнее животное: " + animal.type + "\nКличка: " + animal.name + "\nВес: " + animal.weight
        );
    }
}