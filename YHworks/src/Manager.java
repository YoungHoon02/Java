public class Manager extends Employee{
    
    public Manager(String name, String address, int salary, int RRN, int bonus) {

        super(name, address, salary, RRN);
        this.bonus = bonus;

    }

    private int bonus;

    void test() {

        System.out.println("name="+name);
        System.out.println("address="+address);
        System.out.println("salary="+(salary+bonus));
        System.out.println("rrn="+getRRN());
    }
}