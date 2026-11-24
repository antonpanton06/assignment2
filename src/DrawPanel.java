import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

        public static class CarImage {
            BufferedImage image;
            Point position = new Point();

            //TODO: Constructor that takes the image

            public CarImage(BufferedImage image, Point position) {
                this.image = image;
                this.position = position;
            }
        }

        // Creates array of the car images that contains info about positioning and images
        private final ArrayList<CarImage> carImages = new ArrayList<>();

        // Initializes the panel and reads the images
        // Constructor: runs once, when CarView does "new DrawPanel(X, Y-240)"
        public DrawPanel(int x, int y) {
            this.setDoubleBuffered(true);
            this.setPreferredSize(new Dimension(x, y));
            this.setBackground(Color.blue);
        }

        void addCar(String imagePath) {
            try {
                BufferedImage img = ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath));
                // TODO: create a CarImage from img and add it to carImages
                carImages.add(new CarImage(img, new Point(0,0)));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        void moveit ( int index, int x, int y){
            // TODO: get the image at 'index' and set its position
            CarImage car = carImages.get(index);
            car.position.x = x;
            car.position.y = getHeight() - car.image.getHeight() - y;
        }

        int getCarHeight(int index) {
            CarImage car = carImages.get(index);
            return car.image.getHeight();
        }

        int getCarWidth(int index) {
            CarImage car = carImages.get(index);
            return car.image.getWidth();
        }

        // This method is called each time the panel updates/refreshes/repaints itself
             // see javadoc for more info on the parameters
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            // TODO: loop over 'sprites' and drawImage each one
            for (CarImage car : carImages) {
                g.drawImage(car.image, car.position.x, car.position.y, null);
            }
        }
}
