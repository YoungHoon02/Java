import java.util.Scanner;

public class CheckInput {
    

    public static void main(String[] args) {
        
        int min, max, num;

        Scanner input = new Scanner(System.in);

        System.out.println("ù��° ���� �Է��ϼ��� :");
        min = input.nextInt();

        System.out.println("�ι�° ���� �Է��ϼ��� :");
        max = input.nextInt();

        do {
            
            System.out.println("���ڸ� �Է��ϼ��� :");
            num = input.nextInt();

            System.out.println("���������� �ԷµǾ����ϴ�. :"+num);
        } 
        while (num<min || num>max); 

    }
}
