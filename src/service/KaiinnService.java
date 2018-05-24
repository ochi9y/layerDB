package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Dao;
import dao.KaiinnDao;
import vo.KaiinnVo;

public class KaiinnService {
	public KaiinnVo searchs(int key)
	{
		try
		(
				Connection c=Dao.getConnection();
		)
		{
			KaiinnDao kaiinndao = new KaiinnDao();
			KaiinnVo kaiinnVo = kaiinndao.searchM(c,key);
			return kaiinnVo;
		}
		catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
