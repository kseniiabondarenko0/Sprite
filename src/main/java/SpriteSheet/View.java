package SpriteSheet;

import javax.swing.*;
import java.io.IOException;

class View extends JFrame {
    private ViewButton button;

    public ViewButton getButton() {
        return button;
    }


    public View(Controller controller) throws IOException {
        setTitle("Move WASD");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new ViewButton();
       // button.setBounds(controller.getModel().getWidth(), controller.getModel().getHeight(), 100, 50);
        button.addKeyListener(controller);

        setLayout(null);
        add(button);

        setVisible(true);


    }

    public void updatePosition(int x, int y) {
  //      button.setBounds(x, y, 100, 50);
    }
}