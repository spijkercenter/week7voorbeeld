package nl.avans.week7demo.view;

import nl.avans.week7demo.Controller;
import nl.avans.week7demo.UpdatableView;

import javax.swing.*;
import java.awt.*;

public class ShoppingCart extends JTextArea implements UpdatableView {

    private Controller controller;

    ShoppingCart(Controller controller) {
        setEnabled(false);
        controller.subscribe(this);
        this.controller = controller;

        Font f = getFont();

        // create a new, smaller font from the current font
        Font f2 = new Font(f.getFontName(), f.getStyle(), f.getSize() + 30);

        // set the new font in the editing area
        setFont(f2);
    }

    @Override
    public void updateView() {
        setText(controller.getShoppingCartAsString());
    }
}
