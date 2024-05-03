package SpriteSheet;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller implements KeyListener {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void startAnimation(){
       view.getButton().startAnimation();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        model.moveButton(e.getKeyCode());
        if (view != null) {
            view.updatePosition(model.getWidth(), model.getHeight());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}