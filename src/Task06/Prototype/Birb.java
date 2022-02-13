package Task06.Prototype;

public class Birb extends Animal{
    private String cuteness;

    public Birb(){};
    public Birb(Birb bird) {
        super(bird);
        this.cuteness = bird.cuteness;
    }

    @Override
    public Animal clone() {
        return new Birb(this);
    }
}
