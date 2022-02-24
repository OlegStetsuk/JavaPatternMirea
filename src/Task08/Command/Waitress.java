package Task08.Command;

public class Waitress {
    public Command request;
    public ChiefCooker chief;
    public Waitress(ChiefCooker chief) {
        this.chief = chief;
    }
    public void getRequest(Command command){
        request = command;
    }
    public void passRequest(){
        if (request != null) {
            chief.execute(request);
        }
    }
}
