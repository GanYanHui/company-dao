package cn.jmu.dao;

import java.util.List;

import cn.jmu.vo.Person;

public interface IPersonDAO {
	// insert
	public boolean doInsert(Person per) throws Exception;

	// delete
	public boolean doDelete(String id) throws Exception;

	// update
	public boolean doUpdate(Person per) throws Exception;

	// ��ID����
	public Person findById(String id) throws Exception;

	// ��ѯȫ��
	public List<Person> findAll() throws Exception;

	// ģ����ѯ(name)
	public List<Person> findByLike(String cond) throws Exception;

}
