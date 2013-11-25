import java.io.*;
import java.util.*;



/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 17/11/13
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public  static void main(String[] s) throws IOException {

        boolean b1;
        int i=0;
        int j=0;
        int v=0;

        String t = null;
        String slovo =null ;
        String[] st =new String[10000];
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<String, String>();
        TreeSet<Comp> ex = new TreeSet<Comp>();

        Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream("/home/vlad/IdeaProjects/List/src/test1")));




        int data = reader.read();


        while(data != -1){
            char dataChar = (char) data;
            data = reader.read();
            b1 = Character.isLetterOrDigit (dataChar);

            if(b1){
                j++;
                sb.append(dataChar);

            }
            else {
                i++;

                slovo = String.valueOf(sb);
                st[i]=slovo;
                sb.delete(0,j);
                j=0;
            }

            // сразу складывать значение в мап

        }

        for(int c=1;c<=i;c++ ){

            int ch=0;
            v++;
            for(int p=1;p<=i;p++){

                if(st[c].equals(st[p])){
                ch++;

                }

            }

            t= String.valueOf(ch);

            map.put( st[c],t);

        }


        int keys;

        ex.clear();
        for( Map.Entry<String, String> entry : map.entrySet() ){


            keys = Integer.parseInt(entry.getValue());

            ex.add(new Comp(entry.getKey(), keys));



           }

        FileWriter os = new FileWriter("/home/vlad/IdeaProjects/List/src/data.cvs");
        for(Comp e : ex) {

            ArrayList<String> list = new ArrayList <String>();
            //b1 = Character.isLetterOrDigit (dataChar);

           // if(b1 == true){
            // избавиться от списка
            list.add(e.str + ";" + e.number+";" + e.number*100/v );
            for(String str: list){
                System.out.print(" "+str + '\n' );
                os.write(str + '\n');
            }


        }
        os.close();

        }


    }




