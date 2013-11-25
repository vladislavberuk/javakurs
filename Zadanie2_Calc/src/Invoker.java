import java.util.Stack;

public class Invoker {

    public static int count = 0;
    public static double a = 0;
    public static double b = 0;
    public static double c = 0;





    void  metodConvector(){

        String[] comandList = ConcreteCommand.myFile;
        Stack<Double> stack = new Stack<Double>();



        for (int i = 0;i<count;i++)
        {
            String[] s = comandList[i].split(" ");
            String st = comandList[i];

            FactoryImpl c = new FactoryImpl();
            Command p=c.getCommand(s[0]);
            p.execute(stack, st);



        }

    }

}
