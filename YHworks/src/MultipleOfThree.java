import java.util.Scanner;

public class MultipleOfThree {
    
    public static void main(String[] args) {
        
        int value;

        Scanner input = new Scanner(System.in);

        System.out.print("���ڸ� �Է��ϼ���: ");
        value = input.nextInt();
        
        if(value % 3 == 0)
            System.out.println("�Է� ���� ���� 3�� ����Դϴ�.");

        else
            System.out.println("�Է� ���� ���� 3�� ����� �ƴմϴ�.");
        
    }
}
