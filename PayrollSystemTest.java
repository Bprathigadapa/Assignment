public class PayrollSystemTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        employees[1] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
        employees[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06);
        employees[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300);

        System.out.println("Employees processed individually:");
        for (Employee currentEmployee : employees) {
            System.out.println(currentEmployee);
            System.out.printf("Earned $%,.2f\n\n", currentEmployee.getPaymentAmount());
        }

        System.out.println("Employees processed polymorphically:");
        for (Employee currentEmployee : employees) {
            if (currentEmployee instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());
                System.out.printf("New base salary with 10%% increase is: $%,.2f\n", employee.getBaseSalary());
            }
            System.out.printf("%s\nEarned $%,.2f\n\n", currentEmployee, currentEmployee.getPaymentAmount());
        }
    }
}
