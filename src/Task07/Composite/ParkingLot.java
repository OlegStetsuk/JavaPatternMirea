package Task07.Composite;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Car{
    public List<Car> carList = new ArrayList<Car>();

    @Override
    public void honk() {
        for (Car car : carList) {
            car.honk();
        }
    }
    public void add(Car car) {
        carList.add(car);
    }
    public void remove(Car car){
        carList.remove(car);
    }
    public Car getChild(int num) {
        return carList.get(num);
    }
}
