package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.RegistBean;
import bean.SearchBean;
import dao.Dao;
import dao.KaiinnDao;
import domain.SexEnum;
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
            searchBean.setSex(SexEnum.valueOf(kaiinnVo.getSex()));
            searchBean.setExist(true);
            return searchBean;
        }
        catch(ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RegistBean regists(int key, String name, String seibetu)
        {
            try
            (
                    Connection c=Dao.getConnection();
            )
            {
                KaiinnVo kaiinnVo = new KaiinnVo(key,name,seibetu);
                KaiinnDao kaiinndao = new KaiinnDao();
                kaiinndao.registM(c,kaiinnVo);

                RegistBean registBean = new RegistBean();

                registBean.setId(kaiinnVo.getKaiinnno());
                registBean.setName(kaiinnVo.getName());
                registBean.setDate(kaiinnVo.getRegistdate());
                registBean.setSex(SexEnum.valueOf(kaiinnVo.getSex()));
                return registBean;
            }
            catch(ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }

    }
}
