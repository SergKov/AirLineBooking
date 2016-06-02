package com.mycompany.travel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.travel.service.EmployeeService;

public class EmployeeAndCustomerTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-config");
		EmployeeService cust = ctx.getBean(EmployeeService.class);

		cust.findAll().forEach(el -> System.out.println(el));

		// System.err.println("=====================CUSTOMER=========================================");
		// System.out.println("====================create()==========================================");

		/*
		 * Customer c = new Customer(); c.setCus_id(5); c.setLogin("Steve");
		 * c.setPassword("123fgh"); duplicate key value in a unique or primary
		 * key constraint or unique index identified by 'SQL151031214102820'
		 * defined on 'CUSTOMER'. c.setEmail("steve@gmail.com");
		 * c.setTelephoneOne("044 505 36 05"); cust.create(c);
		 */

		// Customer c = new Customer();
		// c.setCus_id(20);
		// c.setLogin("Starrr");
		// c.setPassword("opop12");
		// c.setEmail("starrr@gmail.com");
		// c.setTelephoneOne("061 523 33 07");
		// cust.create(c);

		// System.out.println("==================findAll=============================================");
		// List<Customer> listCust = cust.findAll();
		// for (Customer custom : listCust) {
		// System.out.println(custom);
		// }
		//
		// System.out.println("===================findById(3)============================================");
		// System.out.println(cust.findById(3));
		//
		// System.out.println(
		// "==================update(new Cusomer(2, Steve, fbbbs45,
		// steve@gmail.com, 044 505 36 05)) ==================");
		// Customer custom = new Customer();
		// custom.setCustomer_id(2);
		// custom.setLogin("Steve");
		// custom.setPassword("123fgh");
		// custom.setEmail("steve@gmail.com");
		// custom.setTelephoneOne("044 505 36 05");
		// cust.update(custom);
		//
		// System.out.println("===================findById(2)============================================");
		// System.out.println(cust.findById(2));
		//
		// //
		// System.out.println("===================findCustomByCredent===================================");
		// // System.out.println(cust.findCustomerByCredent("Vasil", "val25"));
		//
		// EmployeeService empl = ctx.getBean(EmployeeService.class);
		//
		// System.err.println("===================EMPLOYEE==============================================");
		// System.out.println("=====================findAll=============================================");
		// System.out.println(empl.findAll());
		//
		// System.out.println("======================findById(6)=======================================");
		// System.out.println(empl.findEmployeeById(6));
		//
		// //
		// System.out.println("=====================ByCredential======================================");
		// // System.out.println(empl.findEmployeeByCredent("Dima", "Gruuu"));
		//
		// System.out.println("===========update=======================================================");
		// Employee employee = new Employee();
		// employee.setEmployee_id(6);
		// employee.setLogin("Dima");
		// employee.setPassword("Gruuu");
		// employee.setName("Dima");
		// employee.setSurName("Ganov");
		// employee.setPosition(PositionEmpl.BUSINESS_ANALITIC);
		// employee.setStatus(StatusEmpl.WORK);
		// employee.setMiddleName("Konun");
		// employee.setTelephoneOne("063 650 50 59");
		// employee.setEmail("demon@univ.kiev.ua");
		// empl.update(employee);
		//
		// System.out.println("================create=================================================");
		// // employee.setEmpl_id(7);
		// // employee.setLogin("Dim");
		// // employee.setPassword("Gruuu1");
		// // employee.setName("Dima");
		// // employee.setSurName("Ganov");
		// // employee.setPosition(PositionEmpl.BUSINESS_ANALITIC);
		// // employee.setStatus(StatusEmpl.FIRED);
		// // employee.setMiddleName("Konun");
		// // employee.setTelephoneOne("061 651 50 59");
		// // employee.setEmail("demonGanov@univ.kiev.ua");
		// // empl.create(employee);
		//
		// System.out.println(empl.findEmployeeById(9));

	}

}
