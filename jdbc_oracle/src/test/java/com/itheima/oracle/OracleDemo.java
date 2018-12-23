package com.itheima.oracle;

import oracle.jdbc.OracleTypes;

import org.junit.Test;

import java.sql.*;

public class OracleDemo {

    @Test
    public void javaCallOracle() throws Exception {
        /*String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.23.128:1521:orcl";
        String username = "itheima";
        String password = "itheima";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pst = con.prepareStatement("select * from emp where empno = ?");
        pst.setObject(1,7788);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }

        rs.close();
        pst.close();
        con.close();*/

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.23.128:1521:orcl";
        String username = "itheima";
        String password = "itheima";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pst = con.prepareStatement("select * from emp where empno = ?");
        ResultSet rs = pst.executeQuery();
        pst.setObject(1,7788);
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }

        rs.close();
        pst.close();
        con.close();

    }

    /**
     * java调用存储过程
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void javaCallProcedure() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.23.128:1521:orcl", "itheima", "itheima");
        CallableStatement pst = con.prepareCall("{call p_yearsal(?,?)}");
        pst.setObject(1,7788);
        pst.registerOutParameter(2, OracleTypes.NUMBER);
        pst.execute();
        System.out.println(pst.getObject(2));
        pst.close();
        con.close();

    }

    @Test
    public void javaCallFunction() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.23.128:1521:orcl", "itheima", "itheima");
        CallableStatement pst = con.prepareCall("{?=call f_yearsal(?)}");
        pst.setObject(2,7788);
        pst.registerOutParameter(1, OracleTypes.NUMBER);
        pst.execute();
        System.out.println(pst.getObject(1));
        pst.close();
        con.close();

    }
}
