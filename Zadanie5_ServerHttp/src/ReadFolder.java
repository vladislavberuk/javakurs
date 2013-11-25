import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 22/11/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReadFolder  {

     void readFolder(String s) {
        System.out.println(s);
        File myFolder =new File(s);

        try{
            FileWriter os = new FileWriter("/home/vlad/index.html");
            File[] files = myFolder.listFiles();
            int i = files.length;

            System.out.println(myFolder.getName());
            os.write( "<html><body><h1>" + '\n');
            os.write( "<p><a href=>"+ "..." +"</a></p> " + '\n');
            for(File file: files){
                Date myDate = new Date(file.lastModified());
                os.write( "<h2> <a href=>"+ file.getName() +"</a>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ myDate +"</h2>" +"\r\n");
            }


            os.write( "<html><body><h1>" + '\n');
            os.close();

        }catch ( IOException e) {

        }

    }
}