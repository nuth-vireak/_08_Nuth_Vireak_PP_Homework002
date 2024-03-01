package kh.com.kshrd.staffmanagement;

public class Volunteer extends StaffMember {

    private double salary;

    public Volunteer(int id, String name, String address) {
        super(id, name, address);
    }

    public Volunteer(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    public double pay() {
        return 0;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
