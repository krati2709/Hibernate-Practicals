package com.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class TestSQLCount {

public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		SQLQuery q = session.createSQLQuery("select count(*) from st_user");
		
		List list = q.list();
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			Object dto = (Object) it.next();
			System.out.println(dto);
		}
		
		tx.commit();
		session.close();
		
	}

}
