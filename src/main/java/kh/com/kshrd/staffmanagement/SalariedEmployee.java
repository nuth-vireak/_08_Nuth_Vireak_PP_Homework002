package kh.com.kshrd.staffmanagement;

public class SalariedEmployee extends StaffMember {

    private double salary;
    private double bonus;

    public SalariedEmployee(int id, String name, String address) {
        super(id, name, address);
    }

    public SalariedEmployee(int id, String name, String address, double salary, double bonus) {
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public double pay() {
        return salary + bonus;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
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

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
