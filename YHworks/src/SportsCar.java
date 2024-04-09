//스포츠카는 Car를 상속받는다
public class SportsCar extends Car{
    
    //오버라이딩 써서 검사받을수있음 함수를 재정의하는지 새로 정의한건지
    @Override
    public void print() { //부모 클래스를 건들지 않고 자식이 대체할 뿐

        super.print(); //super 통해 부모클래스 print()를 불러오는게 가능
        System.out.println("Hello Sports Car : "+speed);
    }
}
