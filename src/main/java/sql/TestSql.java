package sql;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TestSql {
    public static void main(String[] args) throws Exception {
        List<String> fileList = new ArrayList<String>();
        fileList.add("file1");
        fileList.add("file2");
        saveinfo(fileList);
    }
    //插入数据
    public static void saveinfo(List<String> fileList) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn= DB.getConn();
            String sql = "insert into s3file value (?) ";
            pstmt = DB.getPStmt(conn, sql);
            Long startTime = System.currentTimeMillis();
            conn.setAutoCommit(false);
            for (String file : fileList){
                pstmt.setString(1, file);
                pstmt.executeUpdate();
            }
            conn.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            DB.closeStmt(pstmt);
            DB.closeConn(conn);
        }
    }
}
