import com.sun.prism.impl.Disposer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vlad
 * Date: 25/11/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
interface ICommand {
    Command getCommand(String name);
}

class Factory implements ICommand{
    @Override
    public Command getCommand(String name){
        if("ADD".equals(name)){
            return new ADD();
        } else if("LIST".equals(name)){
            return new LIST();
        } else if("EXIT".equals(name)){
            return new LIST();
        }
        return null;
    }
}
