package hello;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class GetData {

    public static  String getTableContent() throws Exception {
        String resultValue=null;

        Connection conn = DriverManager.getConnection( "jdbc:h2:file:./test","sa", "");
        java.sql.ResultSet rs = conn.createStatement().executeQuery(
                " SELECT * FROM TEST where UPDATE_DATE < '2018-03-10 17:15:20.178'");
        while(rs.next())
        {
            resultValue=rs.getString(3);
        }
        return resultValue;
    }

    public void createStoredProc() throws SQLException {
        Connection conn = DriverManager.getConnection( "jdbc:h2:file:./test","sa", "");
        Statement st = conn.createStatement();
        st.execute("DROP ALIAS IF EXISTS getTableContent");
        st.execute("CREATE ALIAS getTableContent FOR \"hello.GetData.getTableContent\"");
        ResultSet resultSet = st.executeQuery("CALL getTableContent()");
        while(resultSet.next()) {
            System.out.println("Update Date: " + resultSet.getString(1));
        }
    }

}
