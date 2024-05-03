package SpriteSheet;

import java.awt.event.KeyEvent;

class Model {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private int width = 458;
    private int height = 571;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void moveUp() {
        height -= 10;
    }

    public void moveLeft() {
        width -= 10;
    }

    public void moveDown() {
        height += 10;
    }

    public void moveRight() {
        width += 10;
    }

    public void moveButton(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_W:
               moveUp();
               controller.startAnimation();

                break;
            case KeyEvent.VK_A:
                moveLeft();
                break;
            case KeyEvent.VK_S:
                moveDown();
                break;
            case KeyEvent.VK_D:
                moveRight();
                break;
        }

    }
}
