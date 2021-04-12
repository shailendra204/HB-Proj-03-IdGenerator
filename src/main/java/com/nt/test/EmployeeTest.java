package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.model.Employee;
import com.nt.utials.HibernateUtials;

public class EmployeeTest {

	public static void main(String[] args) {
		// create model class object
		boolean flag = false;
		int count=0;
		Employee emp = new Employee();
		// set value
		emp.setEmane("namdan");
		emp.setDegination("UI");
		emp.setDeptno("20");
		emp.setSal(20000.0);
		// crate session object
		Session ses = HibernateUtials.getSession();
		// create transaction
		Transaction tx = ses.beginTransaction();
		try {
			count = (int) ses.save(emp);
			if (count != 0)
				flag = true;

		} catch (HibernateException e) {

			flag = false;
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("object are  saved with id : "+count);
			} else {
				tx.rollback();
				System.out.println("object are not save");
			}
		}
	}

}
