
public class Employee {
	
	private int empId;
	private String empName;
	private int deptID;
	private String status = "active";
	private int salary;

	public Employee(int empId, String empName, int deptID, String status, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptID = deptID;
		this.status = status;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getDeptID() {
		return deptID;
	}


	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String toString() {
		return "Employee [ empId = " + empId+ ", empName = "+empName+ ", deptID = "+deptID+", status = "+status+ ",salary = "+salary+" ]";	
	}
}
