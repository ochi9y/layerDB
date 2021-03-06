package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.KaiinnVo;

public class KaiinnDao extends Dao
{
    public KaiinnDao()
    {

    }

    public KaiinnDao(Connection con)
    {
        super(con);
    }

public List<KaiinnVo> listoutM() throws  SQLException
{


      PreparedStatement stmt = null;
      ResultSet rset = null;

      List<KaiinnVo>  list = new ArrayList<KaiinnVo> ();

      try{

        /* Statementの作成 */
        stmt = con.prepareStatement(
                      "select "
                    + "   *"
                    + " from "
                    + "   KAIINN "
                    );


        /* ｓｑｌ実行 */
        rset = stmt.executeQuery();

        /* 取得したデータを格納します。 */
        while (rset.next())
            {
                KaiinnVo em = new KaiinnVo();
                em.setKaiinnno(rset.getInt(1) );
                em.setName(rset.getString(2));
                em.setRegistdate(rset.getDate(3));
                em.setSex(rset.getString(4));
                list.add(em);

                //System.out.println(rset.getString(1));
            }
      }

      catch (SQLException e) {
            throw e;
        }
        finally{
            /* クローズ処理 */
            if(stmt != null){
              stmt.close();
              stmt = null;
            }
            if(rset != null){
              rset.close();
              rset = null;
            }
        }
        return list;
        }

    public KaiinnVo searchM(Connection c,int key) throws SQLException
    {
        KaiinnVo kaiinnVo = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        con = c;
            /* Statementの作成 */
            stmt = con.prepareStatement
                    (
                            "select "
                                    + "  KAIINNNO"
                                    + "  ,NAME"
                                    + "  ,REGISTDATE"
                                    + "  ,SEIBETU"
                                    + " from "
                                    + "   KAIINN "
                                    + "where"
                                    + "  KAIINNNO =? "
                            );
            /* ｓｑｌ実行 */
            stmt.setInt (1, key);
            rset = stmt.executeQuery();

            /* 取得したデータを表示します。 */
            while (rset.next())
            {
                kaiinnVo = new KaiinnVo();
                kaiinnVo.setKaiinnno(rset.getInt(1));
                kaiinnVo.setName(rset.getString(2));
                kaiinnVo.setRegistdate(rset.getDate(3));
                kaiinnVo.setSex(rset.getString(4));

                //System.out.println(rset.getString(1));
            }
        return kaiinnVo;
    }

    public void registM(Connection c,KaiinnVo kaiinnVo) throws SQLException
    {
         PreparedStatement stmt = null;
            //ResultSet rset = null;
            con = c;
                /* Statementの作成 */
                stmt = con.prepareStatement
                        (
                                "insert into kaiinn ("
                                        + "  KAIINNNO"
                                        + "  ,NAME"
                                        + "  ,REGISTDATE"
                                        + "  ,SEIBETU"
                                        + ")"
                                        + " values( "
                                        + "?,?,?,?)"
                                );
                /* ｓｑｌ実行 */
                stmt.setInt (1, kaiinnVo.getKaiinnno());
                stmt.setString (2, kaiinnVo.getName());
                stmt.setDate(3,kaiinnVo.getRegistdate());
                stmt.setString(4,kaiinnVo.getSex());
                stmt.executeUpdate();


    }

}