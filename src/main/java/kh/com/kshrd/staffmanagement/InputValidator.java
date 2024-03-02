package kh.com.kshrd.staffmanagement;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {

    private final Scanner scanner = new Scanner(System.in);

    public int validateOption() {
        String input;
        Pattern pattern = Pattern.compile("[1-5]");
        while (true) {
            System.out.print("-> Choose an option() : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }
        return Integer.parseInt(input);
    }

    public int validateOptionInsertEmployee() {
        String input;
        Pattern pattern = Pattern.compile("[1-4]");
        while (true) {
            System.out.print("-> Choose an option() : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 1 and 4.");
            }
        }
        return Integer.parseInt(input);
    }

    public String validateName() {
        String input;
        Pattern pattern = Pattern.compile("[a-zA-Z ]{1,50}");
        while (true) {
            System.out.print("-> Enter name : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name between 1 and 50 characters.");
            }
        }
        return input;
    }

    public String validateAddress() {
        String input;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9 ]{1,50}");
        while (true) {
            System.out.print("-> Enter address : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid address. Please enter an address between 1 and 50 characters.");
            }
        }
        return input;
    }

    public double validateSalary() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("-> Enter salary : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid salary. Please enter a valid salary.");
            }
        }
        return Double.parseDouble(input);
    }

    public double validateBonus() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("-> Enter bonus : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid bonus. Please enter a valid bonus.");
            }
        }
        return Double.parseDouble(input);
    }

    public int validateHoursWorked() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+");
        while (true) {
            System.out.print("-> Enter hours worked : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid hours worked. Please enter a valid number of hours worked.");
            }
        }
        return Integer.parseInt(input);
    }

    public double validateRate() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("-> Enter rate : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid rate. Please enter a valid rate.");
            }
        }
        return Double.parseDouble(input);
    }

    public int validateEmployeeIdInRecord(List<StaffMember> staffMembers) {
        int id = 0;
        Pattern pattern = Pattern.compile("\\d+"); // regex for digits only
        while (true) {
            System.out.print("=> Enter ID to search for employee: ");
            String input = scanner.nextLine();
            if (!input.isEmpty() && pattern.matcher(input).matches()) {
                id = Integer.parseInt(input);
                int finalId = id;
                boolean idExists = staffMembers.stream().anyMatch(staffMember -> staffMember.getId() == finalId);
                if (idExists) {
                    break;
                } else {
                    System.out.println("Invalid ID. Please enter a valid employee ID.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return id;
    }

    public int validateOptionColumnUpdateHourlyEmployee() {
        String input;
        Pattern pattern = Pattern.compile("[0-4]");
        while (true) {
            System.out.print("=> Enter column number : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 0 and 4.");
            }
        }
        return Integer.parseInt(input);
    }

    public String validateNewName() {
        String input;
        Pattern pattern = Pattern.compile("[a-zA-Z ]{1,50}");
        while (true) {
            System.out.print("=> Enter new name : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name between 1 and 50 characters.");
            }
        }
        return input;
    }

    public String validateNewAddress() {
        String input;
        Pattern pattern = Pattern.compile("[a-zA-Z0-9 ]{1,50}");
        while (true) {
            System.out.print("=> Enter new address : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid address. Please enter an address between 1 and 50 characters.");
            }
        }
        return input;
    }

    public double validateNewSalary() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("=> Enter new salary : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid salary. Please enter a valid salary.");
            }
        }
        return Double.parseDouble(input);
    }

    public int validateNewHoursWorked() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+");
        while (true) {
            System.out.print("=> Enter new hours worked : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid hours worked. Please enter a valid number of hours worked.");
            }
        }
        return Integer.parseInt(input);
    }

    public double validateNewRate() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("=> Enter new rate : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid rate. Please enter a valid rate.");
            }
        }
        return Double.parseDouble(input);
    }

    public int validateOptionColumnUpdateSalariedEmployee() {
        String input;
        Pattern pattern = Pattern.compile("[0-4]");
        while (true) {
            System.out.print("=> Enter column number : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 0 and 4.");
            }
        }
        return Integer.parseInt(input);
    }

    public double validateNewBonus() {
        String input;
        Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]{1,2})?");
        while (true) {
            System.out.print("=> Enter new bonus : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid bonus. Please enter a valid bonus.");
            }
        }
        return Double.parseDouble(input);
    }

    public int validateOptionColumnUpdateVolunteer() {
        String input;
        Pattern pattern = Pattern.compile("[0-3]");
        while (true) {
            System.out.print("=> Enter column number : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 0 and 3.");
            }
        }
        return Integer.parseInt(input);
    }

    public int validatePaginationOption() {
        String input;
        Pattern pattern = Pattern.compile("[1-5]");
        while (true) {
            System.out.print("-> Choose an option() : ");
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) {
                break;
            } else {
                System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }
        return Integer.parseInt(input);
    }
}
