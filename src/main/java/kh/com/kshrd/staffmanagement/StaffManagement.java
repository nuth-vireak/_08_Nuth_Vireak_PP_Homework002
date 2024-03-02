package kh.com.kshrd.staffmanagement;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StaffManagement {

    private int pageNumber = 1; // Current page number
    private int pageSize = 5; // Number of items per page

    private static int lastId = 1;
    private final Scanner input = new Scanner(System.in);
    private final List<StaffMember> staffMembers = new ArrayList<>();
    private final CellStyle centerStyle = new CellStyle(CellStyle.HorizontalAlign.center); // Center align style for table
    private final CellStyle leftStyle = new CellStyle(CellStyle.HorizontalAlign.left); // Left align style for table
    private final InputValidator inputValidator = new InputValidator();

    public StaffManagement() {
        initializeStaffMembers();
        displayMenu();
    }

    private void initializeStaffMembers() {
        staffMembers.add(new Volunteer(lastId++, "John Doe", "Phnom Penh", 100));
        staffMembers.add(new SalariedEmployee(lastId++, "Jane Doe", "Siem Reap", 1000, 100));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));
        staffMembers.add(new Volunteer(lastId++, "John Doe", "Phnom Penh", 100));
        staffMembers.add(new SalariedEmployee(lastId++, "Jane Doe", "Siem Reap", 1000, 100));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));
        staffMembers.add(new Volunteer(lastId++, "John Doe", "Phnom Penh", 100));
        staffMembers.add(new SalariedEmployee(lastId++, "Jane Doe", "Siem Reap", 1000, 100));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "John Smith", "Battambang", 40, 10));
        staffMembers.add(new Volunteer(lastId++, "Jane Smith", "Kampong Cham", 200));
        staffMembers.add(new SalariedEmployee(lastId++, "John Doe", "Kampong Thom", 2000, 200));
        staffMembers.add(new HourlySalaryEmployee(lastId++, "Jane Doe", "Kampong Speu", 50, 20));
    }

    private void displayMenu() {
        int option;
        do {
            displayMenuTable();
            System.out.println("-----------------------------");
            option = inputValidator.validateOption();
            handleOption(option);
        } while (true);
    }

    private void handleOption(int option) {
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
    }

    private void insertEmployee() {
        System.out.println();
        System.out.println("======* Insert Employee *======");
        System.out.println("Choose Type : ");

        Table table = createInsertEmployeeTable();
        System.out.println(table.render());

        int type = inputValidator.validateOptionInsertEmployee();

        switch (type) {
            case 1 -> insertVolunteer();
            case 2 -> insertSalariedEmployee();
            case 3 -> insertHourlyEmployee();
            case 4 -> displayMenu();
            default -> System.out.println("Invalid option!");
        }
    }

    private Table createInsertEmployeeTable() {
        Table table = new Table(4, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 25);
        table.setColumnWidth(1, 25, 25);
        table.setColumnWidth(2, 25, 25);
        table.setColumnWidth(3, 20, 25);

        table.addCell("1. Volunteer", centerStyle);
        table.addCell("2. Salaried Employee", centerStyle);
        table.addCell("3. Hourly Employee", centerStyle);
        table.addCell("4. Back", centerStyle);

        return table;
    }

    private void insertVolunteer() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("ID : " + lastId);
        Volunteer volunteer = createVolunteer();
        staffMembers.add(volunteer);
        displayAdditionMessage(volunteer.getName(), volunteer.getClass().getSimpleName());
    }

    private void displayAdditionMessage(String volunteer, String volunteer1) {
        System.out.println("-----------------------------");
        System.out.println("* You added " + volunteer + " of type " + volunteer1 + " successfully! *");
        System.out.println();
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }

    private Volunteer createVolunteer() {
        String name = inputValidator.validateName();
        String address = inputValidator.validateAddress();
        double salary = inputValidator.validateSalary();
        return new Volunteer(lastId++, name, address, salary);
    }

    private void insertSalariedEmployee() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("ID : " + lastId);
        SalariedEmployee salariedEmployee = createSalariedEmployee();
        System.out.println("=> Payment : " + salariedEmployee.pay());
        staffMembers.add(salariedEmployee);
        displayAdditionMessage(salariedEmployee.getName(), salariedEmployee.getClass().getSimpleName());
    }

    private SalariedEmployee createSalariedEmployee() {
        String name = inputValidator.validateName();
        String address = inputValidator.validateAddress();
        double salary = inputValidator.validateSalary();
        double bonus = inputValidator.validateBonus();
        return new SalariedEmployee(lastId++, name, address, salary, bonus);
    }

    private void insertHourlyEmployee() {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("ID : " + lastId);
        HourlySalaryEmployee hourlySalaryEmployee = createHourlyEmployee();
        System.out.println("=> Payment : " + hourlySalaryEmployee.pay());
        staffMembers.add(hourlySalaryEmployee);
        displayAdditionMessage(hourlySalaryEmployee.getName(), hourlySalaryEmployee.getClass().getSimpleName());
    }

    private HourlySalaryEmployee createHourlyEmployee() {
        String name = inputValidator.validateName();
        String address = inputValidator.validateAddress();
        int hoursWorked = inputValidator.validateHoursWorked();
        double rate = inputValidator.validateRate();
        return new HourlySalaryEmployee(lastId++, name, address, hoursWorked, rate);
    }

    private void updateEmployee() {
        System.out.println("\n======* Update Employee *======");
        int id = inputValidator.validateEmployeeIdInRecord(staffMembers);

        Optional<StaffMember> foundEmployee = findEmployeeById(id);
        if (foundEmployee.isPresent()) {
            updateEmployeeDetails(foundEmployee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private Optional<StaffMember> findEmployeeById(int id) {
        return staffMembers.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    private void updateEmployeeDetails(Optional<StaffMember> optionalStaffMember) {
        if (optionalStaffMember.isPresent()) {
            StaffMember staffMember = optionalStaffMember.get();
            switch (staffMember) {
                case Volunteer volunteer -> updateVolunteer(volunteer);
                case SalariedEmployee salariedEmployee -> updateSalariedEmployee(salariedEmployee);
                case HourlySalaryEmployee hourlySalaryEmployee -> updateHourlyEmployee(hourlySalaryEmployee);
                default -> System.out.println("Invalid employee type!");
            }
        }
    }

    private void updateHourlyEmployee(HourlySalaryEmployee staffMember) {

        displayHourlyEmployeeTable(staffMember);

        System.out.println("=> Choose one column to update : ");
        System.out.println("1. Name \t 2. Address \t 3. Hours Worked \t 4. Rate \t 0. Cancel");

        int column = inputValidator.validateOptionColumnUpdateHourlyEmployee();

        switch (column) {
            case 1 -> {
                String name = inputValidator.validateNewName();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateHourlyEmployee(staffMember);
            }
            case 2 -> {
                String address = inputValidator.validateNewAddress();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateHourlyEmployee(staffMember);
            }
            case 3 -> {
                int hoursWorked = inputValidator.validateNewHoursWorked();
                staffMember.setHoursWorked(hoursWorked);
                System.out.println("* Hours Worked updated successfully! *");
                updateHourlyEmployee(staffMember);
            }
            case 4 -> {
                double rate = inputValidator.validateNewRate();
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

        int column = inputValidator.validateOptionColumnUpdateSalariedEmployee();

        switch (column) {
            case 1 -> {
                String name = inputValidator.validateNewName();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 2 -> {
                String address = inputValidator.validateNewAddress();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 3 -> {
                double salary = inputValidator.validateNewSalary();
                staffMember.setSalary(salary);
                System.out.println("* Salary updated successfully! *");
                updateSalariedEmployee(staffMember);
            }
            case 4 -> {
                double bonus = inputValidator.validateNewBonus();
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

        int column = inputValidator.validateOptionColumnUpdateVolunteer();

        switch (column) {
            case 1 -> {
                String name = inputValidator.validateNewName();
                staffMember.setName(name);
                System.out.println("* Name updated successfully! *");
                updateVolunteer(staffMember);
            }
            case 2 -> {
                String address = inputValidator.validateNewAddress();
                staffMember.setAddress(address);
                System.out.println("* Address updated successfully! *");
                updateVolunteer(staffMember);
            }
            case 3 -> {
                double salary = inputValidator.validateNewSalary();
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

    private void addEmployeeRows(Table table, List<StaffMember> staffMembers) {
        staffMembers.forEach(staffMember -> {
            if (staffMember instanceof Volunteer) {
                addVolunteerRow(table, (Volunteer) staffMember);
            } else if (staffMember instanceof SalariedEmployee) {
                addSalariedEmployeeRow(table, (SalariedEmployee) staffMember);
            } else if (staffMember instanceof HourlySalaryEmployee) {
                addHourlyEmployeeRow(table, (HourlySalaryEmployee) staffMember);
            }
        });
    }

    private void addVolunteerRow(Table table, Volunteer volunteer) {
        table.addCell("Volunteer", centerStyle);
        table.addCell(String.valueOf(volunteer.getId()), centerStyle);
        table.addCell(volunteer.getName(), centerStyle);
        table.addCell(volunteer.getAddress(), centerStyle);
        table.addCell("$" + String.format("%.2f", volunteer.getSalary()), centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("$" + String.format("%.2f", volunteer.pay()), centerStyle);
    }

    private void addSalariedEmployeeRow(Table table, SalariedEmployee salariedEmployee) {
        table.addCell("Salaried Employee", centerStyle);
        table.addCell(String.valueOf(salariedEmployee.getId()), centerStyle);
        table.addCell(salariedEmployee.getName(), centerStyle);
        table.addCell(salariedEmployee.getAddress(), centerStyle);
        table.addCell("$" + String.format("%.2f", salariedEmployee.getSalary()), centerStyle);
        table.addCell("$" + String.format("%.2f", salariedEmployee.getBonus()), centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("$" + String.format("%.2f", salariedEmployee.pay()), centerStyle);
    }

    private void addHourlyEmployeeRow(Table table, HourlySalaryEmployee hourlyEmployee) {
        table.addCell("Hourly Employee", centerStyle);
        table.addCell(String.valueOf(hourlyEmployee.getId()), centerStyle);
        table.addCell(hourlyEmployee.getName(), centerStyle);
        table.addCell(hourlyEmployee.getAddress(), centerStyle);
        table.addCell("---", centerStyle);
        table.addCell("---", centerStyle);
        table.addCell(String.valueOf(hourlyEmployee.getHoursWorked()), centerStyle);
        table.addCell("$" + String.format("%.2f", hourlyEmployee.getRate()), centerStyle);
        table.addCell("$" + String.format("%.2f", hourlyEmployee.pay()), centerStyle);
    }

    private void displayEmployee() {

        int totalPages = (int) Math.ceil((double) staffMembers.size() / pageSize);

        pageNumber = Math.max(1, Math.min(pageNumber, totalPages));

        List<StaffMember> paginatedList = staffMembers.stream()
                .skip((long) (pageNumber - 1) * pageSize)
                .limit(pageSize)
                .toList();

        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);

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

        addEmployeeRows(table, paginatedList);

        System.out.println(table.render());

        System.out.println("page " + pageNumber + " of " + totalPages);
        System.out.println("1. First Page \t 2. Next Page \t 3. Previous Page \t 4. Last Page \t 5. Exit");
        int option = inputValidator.validatePaginationOption();

        switch (option) {
            case 1 -> {
                pageNumber = 1;
                displayEmployee();
            }
            case 2 -> {
                if (pageNumber < totalPages) {
                    pageNumber++;
                }
                displayEmployee();
            }
            case 3 -> {
                if (pageNumber > 1) {
                    pageNumber--;
                }
                displayEmployee();
            }
            case 4 -> {
                pageNumber = totalPages;
                displayEmployee();
            }
            case 5 -> {
                pageNumber = 1; // Reset page number
                displayMenu();
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private void removeEmployee() {

        System.out.println("======* Remove Employee *======");
        int id = inputValidator.validateEmployeeIdInRecord(staffMembers);

        staffMembers.removeIf(staffMember -> staffMember.getId() == id);
        System.out.println("Employee removed successfully!");
    }

    private void displayMenuTable() {

        System.out.println();
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
