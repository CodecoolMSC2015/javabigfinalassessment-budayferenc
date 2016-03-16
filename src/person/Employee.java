package person;

public class Employee extends Person {
	int salary;
	String jobTitle;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Employee name: " + getName() + "\n Employee email: " + getEmail() + "\n Employee salary: " + salary
				+ "\n Employee jobTitle: " + jobTitle + "\n ";
	}

}
