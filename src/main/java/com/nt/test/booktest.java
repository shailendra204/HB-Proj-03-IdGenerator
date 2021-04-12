package com.nt.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.model.BookEdition;
import com.nt.model.BookTable;
import com.nt.model.Employee;
import com.nt.utials.HibernateUtials;

public class booktest {

	public static void main(String[] args) {
		// create model class object
		boolean flag = false;
		int count=0;
		BookTable n=new BookTable();
		n.setBookName("abd");
		n.setQty(100);
		n.setBookAurthore("sk");
		n.setBookId(1221);
		BookEdition edition=new BookEdition();
		edition.setBook_Edition("sss");
		edition.setQuantity(12);
		n.setEditions(edition);
		// crate session object
		Session ses = HibernateUtials.getSession();
		// create transaction
		Transaction tx = ses.beginTransaction();
		try {
			count = (int) ses.save(n);
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
