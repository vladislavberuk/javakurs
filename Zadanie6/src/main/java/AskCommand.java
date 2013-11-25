import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 25/11/13
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
class AskCommands {

    String askForCommand() {
        String s;

            System.out.println("Введите Команду");
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();



        return s;
    }

    String[] work() {
        do {
            String[] s = askForCommand().split(" ");

            if( s[0].equals("ADD")||s[0].equals("LIST") || s[0].equals("add")||s[0].equals("list")){
                if ( s[0].equals("add")) {s[0]="ADD";} else s[0]="LIST";
                return s;
            } else if (s[0].equals("exit")||s[0].equals("EXIT")){
                s[0]="EXIT";
                return s;
            }


        }while (true);


}
}

