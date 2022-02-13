package Task06.Builder;

public class Director {
    Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public void buildEiffel() {
        builder.buildTower(500);
        builder.setName("Eiffel Tower");
    }

    public void buildOstankino() {
        builder.buildTower(1000000);
        builder.setName("Ostankino TV Tower");
    }
}
