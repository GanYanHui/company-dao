package cn.jmu.dao.test;

import java.util.List;

import org.junit.Test;

import cn.jmu.dao.impl.PersonDAOImpl;
import cn.jmu.vo.Person;

public class PersonTest {

	@Test
	public void testDoInsert() throws Exception {
		Person per = new Person();
		per.setId("201821122020");
		per.setName("¸ÊÑÓ»Ô");
		per.setPassword("123");
		PersonDAOImpl pImpl = new PersonDAOImpl();
		Boolean flag = false;
		flag = pImpl.doInsert(per);
	}

	@Test
	public void testDoDelete() throws Exception {
		String id = "201821122020";
		PersonDAOImpl pImpl = new PersonDAOImpl();
		Boolean flag = false;
		flag = pImpl.doDelete(id);
	}

	@Test
	public void testDoUpdate() throws Exception {
		Person per = new Person();
		per.setId("201821122020");
		per.setName("¸ÊÑÓ»Ô2");
		per.setPassword("123");
		PersonDAOImpl pImpl = new PersonDAOImpl();
		Boolean flag = false;
		flag = pImpl.doUpdate(per);
	}

	@Test
	public void testFindById() throws Exception {
		String id = "201821122020";
		PersonDAOImpl pImpl = new PersonDAOImpl();
		Person per = null;
		per = (Person) pImpl.findById(id);
		System.out.println(per.toString());
	}

	@Test
	public void testFindAll() throws Exception {
		PersonDAOImpl pImpl = new PersonDAOImpl();
		List<Person> all = pImpl.findAll();
		Person per = null;
		for (int i = 0; i < all.size(); i++) {
			per = (Person) all.get(i);
			System.out.println(per.toString());
		}
	}

	@Test
	public void testFindByLike() throws Exception {
		String cond = "»Ô";
		PersonDAOImpl pImpl = new PersonDAOImpl();
		List<Person> all = pImpl.findByLike(cond);
		Person per = null;
		for (int i = 0; i < all.size(); i++) {
			per = (Person) all.get(i);
			System.out.println(per.toString());
		}
	}
}
