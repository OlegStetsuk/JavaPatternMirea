package Task08.Command;

import java.util.ArrayList;
import java.util.List;

public class Client {
    List<Command> listOfOrders = new ArrayList<Command>();
    public Client() {
        listOfOrders.add(new OrderMeatCommand());
        listOfOrders.add(new OrderMostExpensiveDishCommand());
    }
    public void announceOrder(Waitress waitress) {
        for (Command command : listOfOrders) {
            waitress.getRequest(command);
            waitress.passRequest();
        }
    }
}
