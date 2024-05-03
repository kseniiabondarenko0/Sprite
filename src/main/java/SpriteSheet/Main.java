package SpriteSheet;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        Controller controller=new Controller(model);
        model.setController(controller);
        View view = new View(controller);
        controller.setView(view);
    }
}