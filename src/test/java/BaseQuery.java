
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

* author:spring

* DateTime:09.02.24 10:21

*/

public abstract class BaseQuery {
    /*
     * 
     * * 1/基本查询用到的属性
     * 
     * 
     */
    private int count;// 总页数
    protected String onPage = "1";// 当前页
    protected int pageSize = 5;// 每页显示条数
    protected Connection conn;// 连接对象
    protected PreparedStatement ps;// ps
    protected ResultSet rs;// rs
    protected Map dto;// 传来的数据、条件的判断
    protected StringBuilder sql;// sql语句
    protected List pars;// 设置ps中的参数列表
    protected int fetchSize;// 总条数
    protected Collection colls;
    /*
     * 
     * * 2/构造方法(要一个Connection对象，一个Map dto对象)
     * 
     */

    public BaseQuery(Connection conn, Map dto) {
        this.conn = conn;
        this.dto = dto;
        String page = (String) dto.get("onPage");
        if (page != null && !page.equals("")) {
            this.onPage = page;
        }

        this.initSql();

    }

    /*
     * 
     * * 3/初始sql语句
     * 
     * 
     */

    public abstract void initSql();
    /*
     * 
     * * 4/编译sql语句并招行
     * 
     * 
     */

    public void preparedStatement() throws SQLException {
        // 编译
        ps = conn.prepareStatement(sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // 设置sql语句的参数
        if (this.pars != null) {
            int size = this.pars.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ps.setObject(i + 1, this.pars.get(i));
                }
            }
        }
        // 执行
        this.rs = this.ps.executeQuery();
    }
    /*
     * 
     * * 5/执行返回结果集
     * 
     * 
     */

    public List queryAll() throws SQLException {
//这个方法你可以写上你的分页等一些操作
        ArrayList arRS = null;
        this.preparedStatement();// 1.先调用编译sql的方法
        ResultSetMetaData rsm = null;
        try {
            // 6.定义返回值
            arRS = new ArrayList();
            rsm = rs.getMetaData();
            int size = rsm.getColumnCount();
            Map row = null;
            while (rs.next()) {
                row = new HashMap();
                for (int j = 1; j <= size; j++) {
                    row.put(rsm.getColumnLabel(j).toLowerCase(), rs.getString(j));
                }
                arRS.add(row);
                row = null;
                rs.next();
            }
            return arRS;
        } finally {
            close(rs);
            close(ps);
            if (rsm != null) {
                rsm = null;
            }
        }
    }

    /*
     * 
     * * 关闭ps方法
     * 
     * 
     */

    private void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*
     * 
     * * .清空Collection实现类的方法
     * 
     * 
     */

    private void clear(Collection c) {
        if (c != null) {
            c.clear();
        }
    }
}