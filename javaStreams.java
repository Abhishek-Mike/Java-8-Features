import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;


public class javaStreams {
	
	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee(101, "Ronaldo", 101, "inactive", 2000));
		empList.add(new Employee(102, "Messi", 102, "active", 2600));
		empList.add(new Employee(103, "Suarez", 103, "inactive", 1700));
		empList.add(new Employee(104, "Ramos", 104, "inactive", 1600));
		empList.add(new Employee(105, "KDBruyne", 105, "inactive", 9000));
		empList.add(new Employee(106, "Neuer", 106, "active", 7000));
		empList.add(new Employee(107, "Lewandoski", 107, "active", 8000));
		empList.add(new Employee(108, "Henderson", 101, "active", 8700));
		empList.add(new Employee(109, "Robertston", 102, "active", 34000));

		// 1.Write a program to print employee details working in each department

		Map<Integer, List<Employee>> empListBasedonDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptID, Collectors.toList()));

		empListBasedonDept.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + "-------------------" + entry.getValue());
		});
		System.out.println("*******************************************************************");

		// 2.Write a program to print employees count working in each department
		Map<Integer, Long> empCountDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptID, Collectors.counting()));

		empCountDept.entrySet().forEach(entry -> {
			System.out.println("dept " + entry.getKey() + "---" + entry.getValue());
		});

		System.out.println("*******************************************************************");

		// 3.Write a program to print active and inactive employees in the given
		// collection
		long activeEmpCount = empList.stream().filter(e -> "active".equals(e.getStatus())).count();
		long inactiveEmpCount = empList.stream().filter(e -> "inactive".equals(e.getStatus())).count();

		System.out.println("active emp count = " + activeEmpCount);
		System.out.println("inactive emp count = " + inactiveEmpCount);

		System.out.println("*******************************************************************");

		// 4.Write a program to print Max/Min employee salary from the given collection
		// whether you comparable or comparator
		Optional<Employee> empMaxSalary = empList.stream().max(Comparator.comparing(Employee::getSalary));
		Optional<Employee> empMinSalary = empList.stream().min(Comparator.comparing(Employee::getSalary));

		System.out.println(empMaxSalary);
		System.out.println(empMinSalary);

		System.out.println("*******************************************************************");
		// 5.Write a program to print the max salary of an employee from each department
		Map<Integer, Optional<Employee>> topSalaryEmpDeptWise = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptID,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		topSalaryEmpDeptWise.entrySet().forEach(entry -> {
			System.out.println("dept " + entry.getKey() + " top emp " + entry.getValue());
		});
		
	}
}
