


import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 19/11/13
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static  void main(String[] args)  {
        AskCommands com= new AskCommands();


       // System.out.println(p);


        try{

            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");

            String sql = "create table post(id int(11) ,postDate DATE, postMessage varchar (256) ); ";

            Statement stmn =conn.createStatement();
            stmn.execute(sql);

            String[] st= null;

            do{

            st = com.work();

            Factory c = new Factory();

            Command p=c.getCommand(st[0]);
            p.execute (conn,st);
            if (st[0].equals("EXIT")){
                 break;
            }
            }while (true);


//
////            sql = "insert into post (id,postDate,postMessage) values(1,'2013-11-11','гость' ); ";
////
////            stmn.execute(sql);
////
//            sql = "select * from post ";
//
//            ResultSet rs = stmn.executeQuery(sql);
//
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String postMessage =rs.getString("PostMessage");
//                String postDate =rs.getString("PostDate");
//
//
//                System.out.println(id);
//                System.out.println(postMessage);
//                System.out.println(postDate);
//            }






        }catch (ClassNotFoundException e)   {
            e.printStackTrace();
        }     catch (SQLException e){
            e.printStackTrace();
        }

    }
}


