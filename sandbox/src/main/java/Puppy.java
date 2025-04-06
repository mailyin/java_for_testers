public class Puppy{

    public Puppy(String nick, String breed){
        // Это конструктор и у него два параметр, nick и breed.
        System.out.println("Передаваемое имя: " + nick );
    }
    public static void main(String []args){
        // Создание объекта myPuppy.
        Puppy myPuppy = new Puppy( "Багет", "Mops");
    }
}

