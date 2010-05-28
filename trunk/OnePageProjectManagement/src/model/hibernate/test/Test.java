package model.hibernate.test;

import java.math.BigDecimal;

import model.Puser;

import org.hibernate.Session;

import controller.HibernateUtil;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session ses = HibernateUtil.getSession();
		
		Puser user = (Puser) ses.get(Puser.class, 1);
		System.out.println(user.getNameSurname());

	}

}
