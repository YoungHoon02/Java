class Bank {
    
    public double getInterestRate() {
        return 0.0;
    }
}

//BadBank Class 정의
class BadBank extends Bank {

    @Override
    public double getInterestRate() {
        return 10.0;
    }
}

//NormalBank Class 정의
class NormalBank extends Bank {

    @Override
    public double getInterestRate() {
        return 5.0;
    }
}

//GoodBank Class 정의
class GoodBank extends Bank {

    @Override
    public double getInterestRate() {
        return 3.0;
    }
}

public class BankTest {
    
    public static void main(String[] args) {
        
        BadBank b1 = new BadBank();
        NormalBank b2 = new NormalBank();
        GoodBank b3 = new GoodBank();

        System.out.println("BadBank의 이자율: " + b1.getInterestRate());
        System.out.println("NormalBank의 이자율: " + b2.getInterestRate());
        System.out.println("GoodBank의 이자율: " + b3.getInterestRate());

    }
}
