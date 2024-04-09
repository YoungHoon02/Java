public class Car {
    
    public static String color;
    public int gear;
    public int speed;

    public String toString() {

        return "Car [color="+color+"speed="+speed+"gear="+gear+"]";
    }

    //접근 지정자
    public void setColor(String color) {

        this.color = color;
    }

    public void print() {

        System.out.println("Hello, Car "+color);
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
