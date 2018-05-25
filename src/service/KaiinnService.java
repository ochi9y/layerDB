package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.SearchBean;
import dao.Dao;
import dao.KaiinnDao;
import vo.KaiinnVo;

public class KaiinnService {
	public SearchBean searchs(int key)
	{
		try
		(
				Connection c=Dao.getConnection();
		)
		{
			KaiinnDao kaiinndao = new KaiinnDao();
			KaiinnVo kaiinnVo = kaiinndao.searchM(c,key);
			SearchBean searchBean = new SearchBean();
			if(kaiinnVo == null)
			{
				searchBean.setExist(false);
				return searchBean;
			}
			searchBean.setId(kaiinnVo.getKaiinnno());
			searchBean.setName(kaiinnVo.getName());
			searchBean.setDate(kaiinnVo.getRegistdate());
			searchBean.setSex(kaiinnVo.getSex());
			searchBean.setExist(true);
			return searchBean;
		}
		catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
