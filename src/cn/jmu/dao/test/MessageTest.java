package cn.jmu.dao.test;

import java.util.List;

import org.junit.Test;

import cn.jmu.dao.impl.MessageDAOImpl;
import cn.jmu.factory.DAOFactory;
import cn.jmu.vo.Message;

public class MessageTest {

	@Test
	public void testFindAll() throws Exception {
		List<Message> all = DAOFactory.getMessageDAOInstance().findAll();
		Message mes = null;
		for (int i = 0; i < all.size(); i++) {
			mes = (Message) all.get(i);
			System.out.println(mes.toString());
		}
	}

	@Test
	public void testFindById() throws Exception {
		Message mes = null;
		mes = DAOFactory.getMessageDAOInstance().findById(1);
		System.out.println(mes.toString());
	}

	@Test
	public void testDoInsert() throws Exception {
		Message mes = new Message();
		mes.setTitle("标题");
		mes.setContent("内容");
		mes.setWriter("作者");
		mes.setWriteDate("2020-5-21 02:48:00");
		Boolean flag = false;
		flag = DAOFactory.getMessageDAOInstance().doInsert(mes);

	}
}
