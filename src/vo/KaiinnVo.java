package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed May 16 16:44:09 JST 2018
 */
import java.io.Serializable;
import java.util.Date;

/**
 * KaiinnVo.
 * @author yosuke.ochi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/16	yosuke.ochi		Generated.
 */
public class KaiinnVo implements Serializable{

    public static final String TABLE = "KAIINN";

    /**
     * kaiinnNo:int(10) <Primary Key>
     */
    private int kaiinnno;

    /**
     * name:varchar(200)
     */
    private String name;

    /**
     * registDate:date(0)
     */
    private java.sql.Date registdate;

    private String sex;
    /**
    * Constractor
    */
    public KaiinnVo(){}

    /**
    * Constractor
    * @param <code>kaiinnno</code>
    */
    public KaiinnVo(int kaiinnno,String name,String sex){
        this.kaiinnno = kaiinnno;
        this.name = name;
        this.sex = sex;
        this.registdate = new java.sql.Date((new Date()).getTime());
    }

    public int getKaiinnno(){ return this.kaiinnno; }

    public void setKaiinnno(int kaiinnno){ this.kaiinnno = kaiinnno; }

    public String getName(){ return this.name; }

    public void setName(String name){ this.name = name; }

    public java.sql.Date getRegistdate(){ return this.registdate; }

    public void setRegistdate(java.sql.Date registdate){ this.registdate = registdate; }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[KaiinnVo:");
        buffer.append(" kaiinnno: ");
        buffer.append(kaiinnno);
        buffer.append(" name: ");
        buffer.append(name);
        buffer.append(" registdate: ");
        buffer.append(registdate);
        buffer.append("]");
        return buffer.toString();
    }

}
