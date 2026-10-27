
package demo.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void validEmployeeIsAdded() {
        EmployeeService service = new EmployeeService();

        Employee employee = service.addEmployee("Arun", "CSE");

        assertEquals("Arun", employee.getName());
        assertEquals("CSE", employee.getDepartment());
        assertEquals(1, service.getEmployees().size());
    }

    @Test
    void shouldReturnAllEmployees() {
        EmployeeService service = new EmployeeService();

        service.addEmployee("Arun", "CSE");
        service.addEmployee("Rahul", "IT");
        service.addEmployee("Priya", "ECE");

        assertEquals(3, service.getEmployees().size());
    }

    @Test
    void blankNameIsRejected() {
        EmployeeService service = new EmployeeService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.addEmployee(" ", "CSE")
        );
    }

    @Test
    void blankDepartmentIsRejected() {
        EmployeeService service = new EmployeeService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.addEmployee("Arun", " ")
        );
    }
}
