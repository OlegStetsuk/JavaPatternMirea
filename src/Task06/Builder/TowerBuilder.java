package Task06.Builder;

public class TowerBuilder implements Builder{
    Tower tower = new Tower();

    @Override
    public void buildTower(int height) {
        tower.buildTower(height);
    }

    @Override
    public void setName(String name) {
        tower.setName(name);
    }

    @Override
    public Tower getResult() {
        return tower;
    }
}
