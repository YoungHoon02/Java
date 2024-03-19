import java.util.Scanner;

public class CheckInput {
    

    public static void main(String[] args) {
        
        int min, max, num;

        Scanner input = new Scanner(System.in);

        System.out.println("첫번째 수를 입력하세요 :");
        min = input.nextInt();

        System.out.println("두번째 수를 입력하세요 :");
        max = input.nextInt();

        do {
            
            System.out.println("숫자를 입력하세요 :");
            num = input.nextInt();

            System.out.println("정상적으로 입력되었습니다. :"+num);
        } 
        while (num<min || num>max); 

    }
}
