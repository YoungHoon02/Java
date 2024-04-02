public class Employee {
    
    public String name;
    String address;
    protected int salary;
    private int RRN;

    public Employee(String name, String address, int salary, int RRN) {

        this.name = name;
        this.address = address;
        this.salary = salary;
        this.RRN = RRN;
    }

    //getRRN 와 setRRN으로 private 인자 RRN을 Manager에서 상속받는 대신 메소드로 값을 불러옴
    public int getRRN() {

        return RRN;
    }
    public void setRRN(int RRN) {

        this.RRN = RRN;
    }

    //오버로딩
    public String toString() {

        return "Employee [name="+name+", adress="+address+", salary="+salary+", rrn="+RRN+"]";
    }
}
