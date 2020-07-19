package cn.jmu.dao;

import java.util.List;

import cn.jmu.vo.Revert;

public interface IRevertDAO {
	// ����messageID��ѯĳ�����Ե����лظ�
	public List<Revert> findById(int messageID) throws Exception;

	// ����messageID����ĳ�����ԵĻظ�
	public boolean doInsert(Revert rev) throws Exception;
}
