import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 21/11/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */



    public class EXP implements Command (Stack<Double> stack,String s) {
        double a = stack.pop();
        Math.exp(a);
        stack.push(a);

    }

    public class LOG implements  Command (Stack<Double> stack,String s){

        double a = stack.pop();
        Math.log(a);
        stack.push(a);

    }

