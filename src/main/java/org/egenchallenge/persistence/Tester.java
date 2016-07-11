package org.egenchallenge.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	}

}
