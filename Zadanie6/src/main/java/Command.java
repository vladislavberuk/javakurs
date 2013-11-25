

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 25/11/13
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */


interface Command{
    void execute(Connection conn, String[] s) throws SQLException;

}

class ADD implements Command{


    @Override
        public void execute(Connection conn, String[] s) throws SQLException {

        String sql="insert into post (id,postDate,postMessage) values("+s[1]+",'"+ s[2] + " ',' "+ s[3] +"' ); ";


        Statement stmn =conn.createStatement();
        stmn.execute(sql);

        }

}


class LIST implements Command{

    @Override
    public void execute(Connection conn, String[] s) throws SQLException {
        String sql = "select * from post ";
        Statement stmn =conn.createStatement();
        stmn.execute(sql);
        ResultSet rs = stmn.executeQuery(sql);


        while (rs.next()) {
            int id = rs.getInt("id");
            String postMessage =rs.getString("PostMessage");
            String postDate =rs.getString("PostDate");

            System.out.println(id +" "+ postDate +" "+postMessage);



    }

}
}


