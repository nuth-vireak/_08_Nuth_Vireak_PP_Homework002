package kh.com.kshrd.staffmanagement;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManagement {

    private final Scanner input = new Scanner(System.in);
    private final List<StaffMember> staffMembers = new ArrayList<>();
    private static int lastId = 1;

    private final CellStyle centerStyle = new CellStyle(CellStyle.HorizontalAlign.center); // Center align style for table
    private final CellStyle leftStyle = new CellStyle(CellStyle.HorizontalAlign.left); // Left align style for table

    public StaffManagement() {

        staffMembers.add(new Volunteer(lastId++, "John Doe", "Phnom Penh", 100));
        staffMembers.add(new SalariedEmployee(lastId++, "Jane Doe", "Siem Reap", 1000, 100));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));

        displayMenu();
    }

    private void displayMenu() {

        int option;
        do {
            displayMenuTable();
            System.out.println("-----------------------------");
            System.out.print("-> Choose an option() : ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1 -> insertEmployee();
                case 2 -> updateEmployee();
                case 3 -> displayEmployee();
                case 4 -> removeEmployee();
                case 5 -> {
                    System.out.println();
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option!");
            }
        } while (true);
    }

    private void insertEmployee() {

        System.out.println("");
        System.out.println("======* Insert Employee *======");
        System.out.println("Choose Type : ");

        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 25);
        table.setColumnWidth(1, 25, 25);
        table.setColumnWidth(2, 25, 25);
        table.setColumnWidth(3, 20, 25);

        table.addCell("1. Volunteer", centerStyle);
        table.addCell("2. Salaried Employee", centerStyle);
        table.addCell("3. Hourly Employee", centerStyle);
        table.addCell("4. Back", centerStyle);

        System.out.println(table.render());

        System.out.print("=> Enter Type Number : ");
        int type = Integer.parseInt(input.nextLine());

        switch (type) {
            case 1 -> insertVolunteer();
            case 2 -> insertSalariedEmployee();
            case 3 -> insertHourlyEmployee();
            case 4 -> displayMenu();
            default -> System.out.println("Invalid option!");
        }
    }

    private void insertVolunteer() {

        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("ID : " + lastId);

        System.out.print("=> Enter Name : ");
        String name = input.nextLine();

        System.out.print("=> Enter Address : ");
        String address = input.nextLine();

        System.out.print("=> Enter Salary : ");
        double salary = Double.parseDouble(input.nextLine());

        Volunteer volunteer = new Volunteer(lastId++, name, address, salary);

        staffMembers.add(volunteer);

        System.out.println("-----------------------------");
        System.out.println("* You added " + volunteer.getName() + " of type " + volunteer.getClass().getSimpleName() + " successfully! *");
        System.out.println();
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    private void insertSalariedEmployee() {

        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("ID : " + lastId);

        System.out.print("=> Enter Name : ");
        String name = input.nextLine();

        System.out.print("=> Enter Address : ");
        String address = input.nextLine();

        System.out.print("=> Enter Salary : ");
        double salary = Double.parseDouble(input.nextLine());

        System.out.print("=> Enter Bonus : ");
        double bonus = Double.parseDouble(input.nextLine());

        SalariedEmployee salariedEmployee = new SalariedEmployee(lastId++, name, address, salary, bonus);

        System.out.println("=> Payment : " + salariedEmployee.pay());

        staffMembers.add(salariedEmployee);

        System.out.println("-----------------------------");
        System.out.println("* You added " + salariedEmployee.getName() + " of type " + salariedEmployee.getClass().getSimpleName() + " successfully! *");
        System.out.println();

        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    private void insertHourlyEmployee() {

        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("ID : " + lastId);

        System.out.print("=> Enter Name : ");
        String name = input.nextLine();

        System.out.print("=> Enter Address : ");
        String address = input.nextLine();

        System.out.print("=> Enter Hours Worked : ");
        int hoursWorked = Integer.parseInt(input.nextLine());

        System.out.print("=> Enter Rate : ");
        double rate = Double.parseDouble(input.nextLine());

        HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee(lastId++, name, address, hoursWorked, rate);

        System.out.println("=> Payment : " + hourlySalaryEmployee.pay());

        staffMembers.add(hourlySalaryEmployee);

        System.out.println("-----------------------------");
        System.out.println("* You added " + hourlySalaryEmployee.getName() + " of type " + hourlySalaryEmployee.getClass().getSimpleName() + " successfully! *");
        System.out.println();

        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    private void updateEmployee() {

        System.out.println("");

        System.out.println("======* Update Employee *======");
        System.out.print("=> Enter or Search ID to update : ");
        int id = Integer.parseInt(input.nextLine());

        for (StaffMember staffMember : staffMembers) {
            if (staffMember.getId() == id) {
                if (staffMember instanceof Volunteer) {
                    updateVolunteer((Volunteer) staffMember);
                } else if (staffMember instanceof SalariedEmployee) {
                    updateSalariedEmployee((SalariedEmployee) staffMember);
                } else if (staffMember instanceof HourlySalaryEmployee) {
                    updateHourlyEmployee((HourlySalaryEmployee) staffMember);
                }
            }
        }
    }

    private void updateHourlyEmployee(HourlySalaryEmployee staffMember) {

            displayHourlyEmployeeTable(staffMember);

            System.out.println("=> Choose one column to update : ");
            System.out.println("1. Name \t 2. Address \t 3. Hours Worked \t 4. Rate \t 0. Cancel");

            System.out.print("=> Enter column number : ");
            int column = Integer.parseInt(input.nextLine());

            switch (column) {
                case 1 -> {
                    System.out.print("=> Enter new Name : ");
                    String name = input.nextLine();
                    staffMember.setName(name);
                    System.out.println("* Name updated successfully! *");
                    updateHourlyEmployee(staffMember);
                }
                case 2 -> {
                    System.out.print("=> Enter new Address : ");
                    String address = input.nextLine();
                    staffMember.setAddress(address);
                    System.out.println("* Address updated successfully! *");
                    updateHourlyEmployee(staffMember);
                }
                case 3 -> {
                    System.out.print("=> Enter new Hours Worked : ");
                    int hoursWorked = Integer.parseInt(input.nextLine());
                    staffMember.setHoursWorked(hoursWorked);
                    System.out.println("* Hours Worked updated successfully! *");
                    updateHourlyEmployee(staffMember);
                }
                case 4 -> {
                    System.out.print("=> Enter new Rate : ");
                    double rate = Double.parseDouble(input.nextLine());
                    staffMember.setRate(rate);
                    System.out.println("* Rate updated successfully! *");
                    updateHourlyEmployee(staffMember);
                }
                case 0 -> displayMenu();
                default -> System.out.println("Invalid option!");
            }
    }

    private void displayHourlyEmployeeTable(HourlySalaryEmployee staffMember) {

        System.out.println();

        Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 25);
        table.setColumnWidth(1, 10, 10);
        table.setColumnWidth(2, 20, 20);
        table.setColumnWidth(3, 20, 25);
        table.setColumnWidth(4, 10, 25);
        table.setColumnWidth(5, 10, 25);
        table.setColumnWidth(6, 10, 25);

        table.addCell("Type", centerStyle);
        table.addCell("ID", centerStyle);
        table.addCell("Name", centerStyle);
        table.addCell("Address", centerStyle);
        table.addCell("Hours", centerStyle);
        table.addCell("Rate", centerStyle);
        table.addCell("Pay", centerStyle);

        table.addCell("Hourly Employee", centerStyle);
        table.addCell(String.valueOf(staffMember.getId()), centerStyle);
        table.addCell(staffMember.getName(), centerStyle);
        table.addCell(staffMember.getAddress(), centerStyle);
        table.addCell(String.valueOf(staffMember.getHoursWorked()), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.getRate()), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);

        System.out.println(table.render());

        System.out.println();
    }

    private void updateSalariedEmployee(SalariedEmployee staffMember) {

        displaySalariedEmployeeTable(staffMember);

        System.out.println("=> Choose one column to update : ");
        System.out.println("1. Name \t 2. Address \t 3. Salary \t 4. Bonus \t 0. Cancel");

        System.out.print("=> Enter column number : ");
        int column = Integer.parseInt(input.nextLine());

        switch (column) {
            case 1 -> {
                System.out.print("=> Enter new Name : ");
                String name = input.nextLine();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 2 -> {
                System.out.print("=> Enter new Address : ");
                String address = input.nextLine();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 3 -> {
                System.out.print("=> Enter new Salary : ");
                double salary = Double.parseDouble(input.nextLine());
                staffMember.setSalary(salary);
                System.out.println("* Salary updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 4 -> {
                System.out.print("=> Enter new Bonus : ");
                double bonus = Double.parseDouble(input.nextLine());
                staffMember.setBonus(bonus);
                System.out.println("* Bonus updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 0 -> displayMenu();
            default -> System.out.println("Invalid option!");
        }

    }

    private void displaySalariedEmployeeTable(SalariedEmployee staffMember) {

        System.out.println();

        Table table = new Table(7, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 25);
        table.setColumnWidth(1, 10, 10);
        table.setColumnWidth(2, 20, 20);
        table.setColumnWidth(3, 20, 25);
        table.setColumnWidth(4, 10, 25);
        table.setColumnWidth(5, 10, 25);
        table.setColumnWidth(6, 10, 25);

        table.addCell("Type", centerStyle);
        table.addCell("ID", centerStyle);
        table.addCell("Name", centerStyle);
        table.addCell("Address", centerStyle);
        table.addCell("Salary", centerStyle);
        table.addCell("Bonus", centerStyle);
        table.addCell("Pay", centerStyle);

        table.addCell("Salaried Employee", centerStyle);
        table.addCell(String.valueOf(staffMember.getId()), centerStyle);
        table.addCell(staffMember.getName(), centerStyle);
        table.addCell(staffMember.getAddress(), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.getSalary()), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.getBonus()), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);

        System.out.println(table.render());

        System.out.println();
    }

    private void updateVolunteer(Volunteer staffMember) {

        displayVolunteerTable(staffMember);

        System.out.println("=> Choose one column to update : ");
        System.out.println("1. Name \t 2. Address \t 3. Salary \t 0. Cancel");

        System.out.print("=> Select Column Number : ");
        int column = Integer.parseInt(input.nextLine());

        switch (column) {
            case 1 -> {
                System.out.print("=> Enter new Name : ");
                String name = input.nextLine();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateVolunteer(staffMember);
            }
            case 2 -> {
                System.out.print("=> Enter new Address : ");
                String address = input.nextLine();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateVolunteer(staffMember);
            }
            case 3 -> {
                System.out.print("=> Enter new Salary : ");
                double salary = Double.parseDouble(input.nextLine());
                staffMember.setSalary(salary);
                System.out.println("* Salary updated successfully! *");
                updateVolunteer(staffMember);
            }
            case 0 -> displayMenu();
            default -> System.out.println("Invalid option!");
        }
    }

    private void displayVolunteerTable(Volunteer staffMember) {

        System.out.println();

        Table table = new Table(6, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 25);
        table.setColumnWidth(1, 10, 10);
        table.setColumnWidth(2, 20, 20);
        table.setColumnWidth(3, 20, 25);
        table.setColumnWidth(4, 10, 25);
        table.setColumnWidth(5, 10, 25);

        table.addCell("Type", centerStyle);
        table.addCell("ID", centerStyle);
        table.addCell("Name", centerStyle);
        table.addCell("Address", centerStyle);
        table.addCell("Salary", centerStyle);
        table.addCell("Pay", centerStyle);

        table.addCell("Volunteer", centerStyle);
        table.addCell(String.valueOf(staffMember.getId()), centerStyle);
        table.addCell(staffMember.getName(), centerStyle);
        table.addCell(staffMember.getAddress(), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.getSalary()), centerStyle);
        table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);

        System.out.println(table.render());

        System.out.println();
    }

    private void displayEmployee() {

        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        //Type ID Name Address Salary Bonus Hour Rate Pay
        table.setColumnWidth(0, 25, 35);
        table.setColumnWidth(1, 10, 35);
        table.setColumnWidth(2, 20, 35);
        table.setColumnWidth(3, 20, 35);
        table.setColumnWidth(4, 13, 35);
        table.setColumnWidth(5, 13, 35);
        table.setColumnWidth(6, 13, 35);
        table.setColumnWidth(7, 13, 35);
        table.setColumnWidth(8, 13, 35);

        table.addCell("Type", centerStyle);
        table.addCell("ID", centerStyle);
        table.addCell("Name", centerStyle);
        table.addCell("Address", centerStyle);
        table.addCell("Salary", centerStyle);
        table.addCell("Bonus", centerStyle);
        table.addCell("Hours", centerStyle);
        table.addCell("Rate", centerStyle);
        table.addCell("Pay", centerStyle);

        for (StaffMember staffMember : staffMembers) {
            if (staffMember instanceof Volunteer) {
                table.addCell("Volunteer", centerStyle);
                table.addCell(String.valueOf(staffMember.getId()), centerStyle);
                table.addCell(staffMember.getName(), centerStyle);
                table.addCell(staffMember.getAddress(), centerStyle);
                table.addCell("$" + String.format("%.2f", ((Volunteer) staffMember).getSalary()), centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);
            } else if (staffMember instanceof SalariedEmployee) {
                table.addCell("Salaries Employee", centerStyle);
                table.addCell(String.valueOf(staffMember.getId()), centerStyle);
                table.addCell(staffMember.getName(), centerStyle);
                table.addCell(staffMember.getAddress(), centerStyle);
                table.addCell("$" + String.format("%.2f", ((SalariedEmployee) staffMember).getSalary()), centerStyle);
                table.addCell("$" + String.format("%.2f", ((SalariedEmployee) staffMember).getBonus()), centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);
            } else if (staffMember instanceof HourlySalaryEmployee) {
                table.addCell("Hourly Employee", centerStyle);
                table.addCell(String.valueOf(staffMember.getId()), centerStyle);
                table.addCell(staffMember.getName(), centerStyle);
                table.addCell(staffMember.getAddress(), centerStyle);
                table.addCell("---", centerStyle);
                table.addCell("---", centerStyle);
                table.addCell( String.valueOf(((HourlySalaryEmployee) staffMember).getHoursWorked()), centerStyle);
                table.addCell("$" + String.format("%.2f", ((HourlySalaryEmployee) staffMember).getRate()), centerStyle);
                table.addCell("$" + String.format("%.2f", staffMember.pay()), centerStyle);
            }
        }

        System.out.println(table.render());

    }

    private void removeEmployee() {

            System.out.println("======* Remove Employee *======");
            System.out.print("=> Enter ID to remove : ");
            int id = Integer.parseInt(input.nextLine());

            for (StaffMember staffMember : staffMembers) {
                if (staffMember.getId() == id) {
                    staffMembers.remove(staffMember);
                    System.out.println("Employee removed successfully!");
                    break;
                }
            }
    }

    private void displayMenuTable() {
        System.out.println("");
        String padding = " ".repeat(5);

        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        table.setColumnWidth(0, 50, 50);

        table.addCell("Staff Management System", centerStyle);
        table.addCell(padding + "1. Insert Employee", leftStyle);
        table.addCell(padding + "2. Update Employee", leftStyle);
        table.addCell(padding + "3. Display Employee", leftStyle);
        table.addCell(padding + "4. Remove Employee", leftStyle);
        table.addCell(padding + "5. Exit", leftStyle);

        System.out.println(table.render());
    }
}
