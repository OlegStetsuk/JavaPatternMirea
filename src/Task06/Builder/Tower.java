package Task06.Builder;

public class Tower {
    private int height;
    private String name;
    public void buildTower(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tower{" +
                "height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
