import java.util.Scanner;

public class Lec3Ex2 {
    
    public static void main(String[] args) {
        
        int num;

        Scanner input = new Scanner(System.in);

        System.out.print("���� ������ �Է��Ͻÿ�: ");
        num = input.nextInt();
        System.out.println();

        System.out.println(num+"�� ����� ������ �����ϴ�.");
        for (int i=1; i<num; i++) {

            if(num % i == 0) {

                System.out.print(i+" ");
            }
        }
    }
}
