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

	// 据ID查找
	public Person findById(String id) throws Exception;

	// 查询全部
	public List<Person> findAll() throws Exception;

	// 模糊查询(name)
	public List<Person> findByLike(String cond) throws Exception;

}
