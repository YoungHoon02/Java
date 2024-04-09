public class SportsCarTest {
    
    public static void main(String[] args) {
        
        SportsCar obj1 = new SportsCar();

        obj1.setColor("red");

        //static의 장점으로 클래스에 단 하나만 있어서 어디서든 바로 불러올수있음
        Car.color = "green";

    }
}
