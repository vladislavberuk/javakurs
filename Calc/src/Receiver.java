import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 8/11/13
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Receiver {

    public String[] getArgString(String s ) throws IOException {

        Scanner sc;
        sc = new Scanner(new File(s));

        String command[] = new String[100];
         int i = 0;

        while (sc.hasNext()) {
            command[i] = sc.nextLine();
            // System.out.println( command[i]);
            ++i;
        }
        Invoker.count=i;
        return command;

    }



}





