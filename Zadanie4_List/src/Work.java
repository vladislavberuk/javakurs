import java.io.*;
import java.util.*;






/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 17/11/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.TreeSet;

class Comp implements Comparable {

    String str;
    int number;

    Comp(String str,int number  ) {
        this.str = str;
        this.number = number;
    }

    @Override
    public int compareTo(Object obj) {
        Comp entry = (Comp) obj;



        int  result =  entry.number - number ;
        if(result != 0) {
            return (int) result / Math.abs( result );
        }

        result = str.compareTo(entry.str);
        if(result != 0) {
            return result;
        }


        return 0;
    }

}
