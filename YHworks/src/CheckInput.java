import java.util.Scanner;

public class CheckInput {
    

    public static void main(String[] args) {
        
        int min, max, num;

        Scanner input = new Scanner(System.in);

        System.out.println("작은 수를 입력하세요 :");
        min = input.nextInt();

        System.out.println("큰 수를 입력하세요 :");
        max = input.nextInt();

        do {
            
            System.out.println("숫자를 입력하세요 :");
            num = input.nextInt();

        } 
        while (num>=min && num<=max); 

        System.out.println("비 정상적으로 입력되었습니다. :"+num);

    }
}
