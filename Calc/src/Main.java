import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 8/11/13
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */


 public class Main {
      public static void main(String[] args) throws IOException {
          ConcreteCommand h = new ConcreteCommand();
          h.getCommand();

          //Command p = new Command();
          Invoker f = new Invoker();
          // p.PUSH(4.0);

          f.metodConvector();
          //System.out.println(f.a);



        }
}


