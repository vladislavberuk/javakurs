/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 8/11/13
 * Time: 12:38 PM
 * To change this template use File | Settings | File Templates.
 */



import   java.util.*;
import   java.lang.*;


interface ICommand {
    Command getCommand(String name);
}

class FactoryImpl implements ICommand{

    public Command getCommand(String name){

        if("PUSH".equals(name)){
            return new PUSH();
        } else if("PLUS".equals(name)){
            return new PLUS();
        } else if("MINUS".equals(name)){
            return new MINUS();
        }else if("POP".equals(name)){
            return new POP();
        } else if("PRINT".equals(name)){
            return new PRINT();
        } else if("SQRT".equals(name)){
            return new SQRT();
        } else if("MULTIPLAY".equals(name)){
            return new MULTIPLAY();
        } else if("SHARE".equals(name)){
            return new SHARE();
        }else if("DEFINE".equals(name)){
            return new DEFINE();
        }
        return null;
    }



}



interface Command{
    void execute(Stack<Double> stack, String s);

}

@interface In{
     Stack<Double> stack =new Stack<Double>();
     String context();
        }

class PRINT implements Command{

    @Override
    public void execute(Stack<Double> stack, String s )  {
            if(stack.empty()) {
            System.out.println("Неверная команда стек пуст");
        } else {
            System.out.println(stack.pop());

        }
    }
}

class POP  implements Command {
    @Override
    public void execute(Stack<Double> stack, String s ) {
        if(stack.empty()) {
            System.out.println("Неверная команда стек пуст");
        } else {
            stack.pop();
        }
    }
}

class DEFINE  implements Command{
    @Override
    public void execute(Stack<Double> stack, String s) {
        String[] s1 = s.split(" ");
        if (s1[1].equals("a")) {
            Invoker.a = Double.parseDouble(s1[2].substring(0));

        }

        if ( s1[1].equals("b")) {
            Invoker.b = Double.parseDouble(s1[2].substring(0));

        }

        if ( s1[1].equals("c")) {
            Invoker.c = Double.parseDouble(s1[2].substring(0));

        }
    }
}

class PUSH  implements Command {
    @Override
    public void execute(Stack<Double> stack, String s ) {
        String[] s1 = s.split(" ");
        // System.out.println(s1[1]);
        // Double a=Double.parseDouble(s);
        if ( s1[1].equals("a")) {
            stack.push(Invoker.a);
        } else if (s1[1].equals("b")) {
            stack.push(Invoker.b);
        } else if ( s1[1].equals("c")) {
            stack.push(Invoker.c);
        } else {
            Double t = Double.parseDouble(s1[1].substring(0));
            stack.push(t);
        }

    }
}

class SQRT implements Command{

    @Override
    public void execute(Stack<Double> stack, String s ) {

        double a = stack.pop();
        a = Math.sqrt(a);
        stack.push(a);


    }
}

class PLUS implements Command{
    @Override
    public void execute(Stack<Double> stack, String s ) {
        double b= stack.pop();
        double a = stack.pop();
        a+=b;
        stack.push(a);
    }
}

class MINUS implements Command{
    @Override
    public void execute(Stack<Double> stack, String s ) {
        double b= stack.pop();
        double a = stack.pop();
        a-=b;
        stack.push(a);


    }
}



class MULTIPLAY implements Command {
    @Override
    public void execute(Stack<Double> stack, String s) {
        double b= stack.pop();
        double a = stack.pop();
        a*=b;
        stack.push(a);

    }
}


class SHARE implements Command{
    @Override
    public void execute(Stack<Double> stack, String s) {
        double b= stack.pop();
        double a = stack.pop();
        a/=b;
        stack.push(a);

    }
}










