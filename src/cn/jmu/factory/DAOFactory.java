package cn.jmu.factory;

import cn.jmu.dao.IMessageDAO;
import cn.jmu.dao.IRevertDAO;
import cn.jmu.dao.impl.MessageDAOImpl;
import cn.jmu.dao.impl.RevertDAOImpl;
import cn.jmu.dao.IPersonDAO;
import cn.jmu.dao.impl.PersonDAOImpl;

public class DAOFactory {
	public static IPersonDAO getPersonDAOInstance() {
		return new PersonDAOImpl();
	}

	public static IMessageDAO getMessageDAOInstance() {
		return new MessageDAOImpl();
	}

	public static IRevertDAO getRevertDAOInstance() {
		return new RevertDAOImpl();
	}
}
