package db;

import Util.DBUtil;
import org.junit.Test;

import java.sql.Connection;

public class TestDB {
    @Test
    public void test01(){
        Connection conn= DBUtil.getConn();
        System.out.println(conn);


    }
}
