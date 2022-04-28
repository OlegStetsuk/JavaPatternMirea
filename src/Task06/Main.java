package Task06;

import Task06.AbstractFactory.CountryFactory;
import Task06.AbstractFactory.GermanFactory;
import Task06.AbstractFactory.Product;
import Task06.AbstractFactory.RussianFactory;
import Task06.Builder.Builder;
import Task06.Builder.Director;
import Task06.Builder.Tower;
import Task06.Builder.TowerBuilder;
import Task06.Factory.Animal;
import Task06.Factory.CatFactory;
import Task06.Factory.DogeFactory;
import Task06.Factory.Factory;

public class Main {
    public static void main(String[] args) {
        factory();
        abstractFactory();
        builder();
        prototype();
    }

    public static void builder() {
        System.out.println("================= Builder pattern =================");

        Builder builder = new TowerBuilder();
        Director director = new Director(builder);

        director.buildEiffel();
        Tower tower1 = builder.getResult();
        tower1.print();

        director.buildOstankino();
        Tower tower2 = builder.getResult();
        tower2.print();
    }

    public static void factory() {
        System.out.println("================= Factory pattern =================");
        Factory[] enemiesMakers = {new CatFactory(), new DogeFactory()};
        for (Factory factory : enemiesMakers) {
            Animal animal = factory.animalFactory();
            animal.makeSound();
        }
    }

    public static void abstractFactory() {
        System.out.println("================= Abstract factory pattern =================");
        CountryFactory[] carFactories = {new RussianFactory(), new GermanFactory()};
        for (CountryFactory factory : carFactories) {
            Product food = factory.createFood();
            Product clothes = factory.createClothes();
            food.printType();
            clothes.printType();
        }
    }

    public static void prototype() {
        System.out.println("================= Prototype pattern =================");
        Rectangle rect = new Rectangle();
        rect.setX(1);
        rect.setY(1);
        rect.setColor("Stroked Blue");
        rect.setHeight(10);
        rect.setWidth(20);

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(25);
        circle.setColor("Filled Red");
        circle.setRadius(20);
        List<Shape> shapes = Arrays.asList(circle, rect);
        List<Shape> shapesClone = new ArrayList<>();
        for (Shape shape : shapes) {
            shapesClone.add(shape.clone());
        }
        System.out.println("Исходный массив: " + shapes);
        System.out.println("Скопированный массив: " + shapesClone);
    }
}
