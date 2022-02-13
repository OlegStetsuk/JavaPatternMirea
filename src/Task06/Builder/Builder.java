package Task06.Builder;

public interface Builder {
    void buildTower(int height);
    void setName(String name);
    Tower getResult();
}
