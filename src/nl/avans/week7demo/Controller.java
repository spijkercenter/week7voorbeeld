package nl.avans.week7demo;

import nl.avans.week7demo.model.Item;
import nl.avans.week7demo.view.KassaFrame;

import javax.swing.*;
import java.util.*;

public class Controller {

    private Collection<UpdatableView> subscriptions = new ArrayList<>();

    private HashMap<Item, Integer> cart = new HashMap<>();

    private Controller() {
        subscribe(() -> System.out.println("Button Pressed"));
    }

    public int getTotal() {
        int result = 0;
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            int eachPrice = entry.getKey().getPriceInCents();
            int count = entry.getValue();
            int rowPrice = eachPrice * count;
            result += rowPrice;
        }
        return result;
    }

    @SuppressWarnings("unused")
    private enum Stock implements Item {
        COLA(150),
        MARS(150),
        KOFFIE(100);


        private int priceInCents;

        Stock(int priceInCents) {
            this.priceInCents = priceInCents;
        }

        @Override
        public String getName() {
            // TODO make pretty
            return name();
        }

        @Override
        public int getPriceInCents() {
            return priceInCents;
        }
    }

    public static void main(String[] args) {
        // Zorg ervoor dat de knoppen hun bijbehorende product
        // in het tekstvak zetten. Meerdere keren op de knop drukken
        // verhoogt het aantal en het bedrag dat in het tekstvak staat.
        // Nieuwe producten worden onderaan toegevoegd.
        SwingUtilities.invokeLater(new KassaFrame(new Controller()));
    }


    public List<Item> getAllItems() {
        return Arrays.asList(Stock.values());
    }

    public void handleItem(Item item) {
        if (item == null) {
            cart = new HashMap<>();

        } else if (cart.containsKey(item)) {
            int newCount = cart.get(item) + 1;
            cart.put(item, newCount);
        } else {
            cart.put(item, 1);
        }

        for (UpdatableView updatableView : subscriptions) {
            updatableView.updateView();
        }
    }

    public void subscribe(UpdatableView updatableView) {
        this.subscriptions.add(updatableView);
    }

    // TODO make shoppingCart klasse
    public String getShoppingCartAsString() {
        String result = "";
        for (Item item : cart.keySet()) {
            int count = cart.get(item);
            int price = count * item.getPriceInCents();
            result += count + "x " + item.getName() + " = " + price + " cents\n";
        }
        return result;
    }
}
