package cn.jmu.dao;

import java.util.List;

import cn.jmu.vo.Revert;

public interface IRevertDAO {
	// 根据messageID查询某条留言的所有回复
	public List<Revert> findById(int messageID) throws Exception;

	// 根据messageID增加某条留言的回复
	public boolean doInsert(Revert rev) throws Exception;
}
