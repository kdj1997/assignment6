package ccs217_6.ex2;

interface Pizza {
    double getCost();
}

class BasicPizza implements Pizza {
    @Override
    public double getCost() {
        return 5.0;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class PepperoniTopping extends PizzaDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

class MushroomTopping extends PizzaDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza basicPizza = new BasicPizza();
        Pizza pepperoniPizza = new PepperoniTopping(basicPizza);
        Pizza deluxePizza = new MushroomTopping(pepperoniPizza);

        System.out.println("Final cost of the Deluxe Pizza: $" + deluxePizza.getCost());
    }
}
