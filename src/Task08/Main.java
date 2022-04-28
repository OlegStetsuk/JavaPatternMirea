package Task08;

public class Main {
    public static void main(String[] args) {
        commandPattern();
        strategyPattern();
    }

    public static void commandPattern(){
        System.out.println("===========Observer pattern===========");
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay = new CurrentConditionsDisplay();
        Observer currentDisplay2 = new CurrentConditionsDisplay();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(currentDisplay2);

        weatherData.setMeasurements(29f, 65f, 745);
        weatherData.setMeasurements(39f, 70f, 760);
        weatherData.setMeasurements(42f, 72f, 763);
    }

    public static void strategyPattern(){
        System.out.println("===========State pattern===========");
        StateContext context = new StateContext();
        context.heat();
        context.heat();
        context.heat();
        context.freeze();
        context.freeze();
        context.freeze();
    }
}
