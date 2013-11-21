import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 8/11/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */


public class ConcreteCommand {
    public static  String[] myFile;
    public void getCommand() throws IOException {

        Receiver getFile = new Receiver();


        myFile = getFile.getArgString("/home/vlad/IdeaProjects/Calc/src/command");
        //System.out.println(myFile[1]);

    }

}
