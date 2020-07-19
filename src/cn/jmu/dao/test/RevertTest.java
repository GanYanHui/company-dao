package cn.jmu.dao.test;

import java.util.List;

import org.junit.Test;

import cn.jmu.dao.impl.RevertDAOImpl;
import cn.jmu.vo.Revert;

public class RevertTest {

	@Test
	public void testFindById() throws Exception {
		RevertDAOImpl rImpl = new RevertDAOImpl();
		List<Revert> all = rImpl.findById(1);
		Revert rev = null;
		for (int i = 0; i < all.size(); i++) {
			rev = (Revert) all.get(i);
			System.out.println(rev.toString());
		}

	}

	@Test
	public void testDoInsert() throws Exception {
		Revert rev = new Revert();
		rev.setMessageID(1);
		rev.setContent("ÄÚÈÝ");
		rev.setWriter("×÷Õß");
		rev.setWriteDate("2020-5-21 02:55:00");
		RevertDAOImpl rImpl = new RevertDAOImpl();
		Boolean flag = false;
		flag = rImpl.doInsert(rev);

	}
}
