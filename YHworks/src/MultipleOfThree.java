import java.util.Scanner;

public class MultipleOfThree {
    
    public static void main(String[] args) {
        
        int value;

        Scanner input = new Scanner(System.in);

        System.out.print("숫자를 입력하세요: ");
        value = input.nextInt();
        
        if(value % 3 == 0)
            System.out.println("입력 받은 수는 3의 배수입니다.");

        else
            System.out.println("입력 받은 수는 3의 배수가 아닙니다.");
        
    }
}
