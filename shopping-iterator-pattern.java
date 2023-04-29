package ssad.ass5;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class Run {
    public static void main(String args[]) throws Exception {
        File file = new File("~/Desktop/tasks/cf/ssad/ass5/shop.txt");
        Scanner sc = new Scanner(file);
        Map<String, Integer> list = new HashMap<String, Integer>();

        while (sc.hasNextLine()) {
            String item = sc.next();
            int amount = sc.nextInt();

            list.put(item, amount);
        }

        for (Map.Entry<String, Integer> e: list.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

interface Iterator {
    public boolean hasNext();
    public Object next();
}

interface Container {
    public Iterator getIterator();
}

class ShoppingList implements Container {
    Map<String, Integer> shoppingList = new HashMap<String, Integer>();

    @Override
    public Iterator getIterator() {
        return new ShoppingListIterator();
    }

    private class ShoppingListIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < shoppingList.size()) {
                return true;
            }

            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return shoppingList.get(index++);
            }

            return null;
        }
    }
}
