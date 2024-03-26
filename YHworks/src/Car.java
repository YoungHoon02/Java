public class Car {
    
    String color;
    int gear;
    int speed;

    public String toString() {

        return "Car [color="+color+"speed="+speed+"gear="+gear+"]";
    }

    void changeGear(int g) {

        gear = g;
    }

    void speedUp() {

        speed = speed + 1;
    }

    void speedDown() {

        speed = speed - 1;
    }
}
