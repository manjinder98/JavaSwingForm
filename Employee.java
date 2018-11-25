import java.io.Serializable;
public class Employee implements Serializable {
	String name, address, email, occupation, gender;
	int phone;
	float salary;
	boolean isManager;

	public Employee(String name, int phone, String address, String email, String occupation, String gender,
			float salary, boolean isManager) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.occupation = occupation;
		this.gender = gender;
		this.salary = salary;
		this.isManager = isManager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "You've added a new Employee: " + "\n" + " name = " + name + "\n" + " phone = " + phone  + "\n" + " address = " + address  + "\n" + " email = " + email
				 + "\n" + " occupation = " + occupation  + "\n" + " gender = " + gender  + "\n" + " salary = " + salary  + "\n" + " isManager = "
				+ isManager + "\n";
	}		
}
