public class AutoCar implements OperateCar{
    
    public void start() {
        System.out.println("Start");
    }
    public void stop() {
        System.out.println("Stop");
    }

    public void setSpeed(int speed) {
        System.out.println("setSpeed to "+speed);
    }
    public void turn(int degree) {
        System.out.println("turn to "+degree);
    }
}
