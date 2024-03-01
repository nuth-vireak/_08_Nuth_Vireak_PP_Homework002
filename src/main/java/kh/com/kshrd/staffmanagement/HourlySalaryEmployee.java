package kh.com.kshrd.staffmanagement;

public class HourlySalaryEmployee extends StaffMember {

    private int hoursWorked;
    private double rate;

    public HourlySalaryEmployee(int id, String name, String address) {
        super(id, name, address);
    }

    public HourlySalaryEmployee(int id, String name, String address, int hoursWorked, double rate) {
        super(id, name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    @Override
    public double pay() {
        return hoursWorked * rate;
    }

    @Override
    public String toString() {
        return "HourlySalaryEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", rate=" + rate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
