package Task07;

import Task07.Composite.Car;
import Task07.Composite.Mercedes;
import Task07.Composite.Mitsubishi;
import Task07.Composite.ParkingLot;
import Task07.Facade.VideoEditor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        compositeTestPattern();
        facadePatternTest();
    }

    public static void compositeTestPattern() {
        System.out.println("=====================Lightweight pattern=====================");
        ParkingLot lot = new ParkingLot();
        List<Car> cars = new ArrayList<>();
        cars.add(new Mercedes());
        cars.add(new Mitsubishi());
        System.out.println(lot);
    }
    public static void facadePatternTest(){
        System.out.println("=====================Facade pattern=====================");
        VideoEditor.MP4toAVI();
        VideoEditor.lowerVolume();
    }
}
