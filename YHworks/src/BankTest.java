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
        
        //자식클래스는 부모클래스로 정의할수있음 (상향형변환)
        Bank[] bank = new Bank[3];
        bank[0] = new BadBank();
        bank[1] = new NormalBank();
        bank[2] = new GoodBank();

        System.out.println("BadBank의 이자율: " + bank[0].getInterestRate());
        System.out.println("NormalBank의 이자율: " + bank[1].getInterestRate());
        System.out.println("GoodBank의 이자율: " + bank[2].getInterestRate());

    }
}
