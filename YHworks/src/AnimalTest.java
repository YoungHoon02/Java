class Animal {

    String sound;

    String sound() {
        return sound;
    }
}

class Dog extends Animal {

    @Override
    String sound() {
        return "멍멍";

    /*Dog() {
        sound = "멍멍";
    }*/
    }
}

class Cat extends Animal {

    @Override
    String sound() {
        return "야옹";
    }
}

public class AnimalTest {
    
    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.println("Animal 클래스의 sound()");
        System.out.println(dog.sound());
        System.out.println(cat.sound());
    }
}
