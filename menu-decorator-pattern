package ssad.ass5;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String args[]) {
        CompositeMenu mainMenu = new CompositeMenu("Main Menu");
        CompositeMenu appetizerMenu = new CompositeMenu("Appetizer Menu");
        CompositeMenu dessertMenu = new CompositeMenu("Dessert Menu");

        appetizerMenu.add(new VegetarianDecorator(new Menu("Garlic bread", 5.5)));
        appetizerMenu.add(new SpicyDecorator(new Menu("Chicken wings", 12.5)));
        appetizerMenu.add(new VegetarianDecorator(new SpicyDecorator(new Menu("Tomato soup", 10.5))));

        dessertMenu.add(new Menu("Pie", 4.5));
        dessertMenu.add(new SpicyDecorator(new Menu("Pie", 4.5)));
        dessertMenu.add(new Menu("Ice cream", 3.0));

        mainMenu.print();
        appetizerMenu.print();
        dessertMenu.print();
    }
}

interface IMenu {
    public void print();
    public String getName();
    public double getPrice();
    public void setSpicy();
    public void setVegetarian();
    public void setPrice(int num);
}

abstract class MenuDecorator implements IMenu {
    protected IMenu menu;

    public MenuDecorator(IMenu menu) {
        this.menu = menu;
    }

    public void print(){
        
    }
    public String getName() {
        return menu.getName();
    }

    public double getPrice() {
        return menu.getPrice();
    }

    public void setSpicy() {
        
    }

    public void setVegetarian() {

    }
    public void setPrice(int num) {

    }
}

class Menu implements IMenu {
    protected String name;
    protected double price;
    protected boolean isSpicy;
    protected boolean isVegetarian;

    public Menu (String name, double price) {
        this.name = name;
        this.price = price;
        this.isSpicy = false;
        this.isVegetarian = false;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setSpicy() {
        isSpicy = true;
    }
    public void setVegetarian() {
        isVegetarian = true;
    }
    public void print() {
        String output = name + ", $" + price + (isSpicy ? "\n  -- This item is spicy (+ $2)" : "") + (isVegetarian ? "\n  -- This item is vegetarian (+ $4)" : "");
        System.out.println(output);
    }
    public void setPrice(int num) {
        price += num;
    }
}

class SpicyDecorator extends MenuDecorator {
    public SpicyDecorator(IMenu menu) {
        super(menu);
        menu.setSpicy();
        menu.setPrice(2);
    }
    public void print() {
        menu.print();
    }
}

class VegetarianDecorator extends MenuDecorator {
    public VegetarianDecorator(IMenu menu) {
        super(menu);
        menu.setVegetarian();
        menu.setPrice(4);
    }
    public void print() {
        menu.print();
    }
}

class CompositeMenu implements IMenu {
    private String name;
    private double totalPrice;
    List<IMenu> menuItems = new ArrayList<>();

    public CompositeMenu(String name) {
        this.name = name;
        this.totalPrice = 0;
    }
    public void print() {
        for (int i = 0; i < menuItems.size(); i++) {
            totalPrice += menuItems.get(i).getPrice();
        }
        String output = name + " [ " + totalPrice + " ]" + "\n--------------------------------------";
        System.out.println(output);
        for (int i = 0; i < menuItems.size(); i++) {
            menuItems.get(i).print();
        }
        System.out.println();
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return totalPrice;
    }
    public void add(IMenu menu) {
        menuItems.add(menu);
    }
    public void remove(IMenu menu) {
        menuItems.remove(menu);
    }
    public void setPrice(int num) {};
    public void setVegetarian() {};
    public void setSpicy() {};
}
