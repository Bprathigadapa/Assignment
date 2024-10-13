public class HourlyEmployee extends Employee {
    private double hourlyWage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hourlyWage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        setHourlyWage(hourlyWage);
        setHoursWorked(hoursWorked);
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage >= 0.0)
            this.hourlyWage = hourlyWage;
        else
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0.0 && hoursWorked <= 168.0) // Max 168 hours in a week
            this.hoursWorked = hoursWorked;
        else
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getPaymentAmount() {
        if (hoursWorked <= 40)
            return hourlyWage * hoursWorked;
        else
            return 40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Hourly employee: %s\nHourly wage: $%,.2f; Hours worked: %.2f", super.toString(), getHourlyWage(), getHoursWorked());
    }
}
