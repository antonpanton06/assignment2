import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // The delay (ms) corresponds to 20 updates/second (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // List of the cars
    ArrayList<Car> cars = new ArrayList<>();

    public void startTimer() {
        this.timer.start();
    }

    /* Each step, the TimerListener moves all cars in the list and tells the
     * view to update its images.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int index = 0; index < cars.size(); index++) {
                Car car = cars.get(index);
                car.move();
                handleWalls(index, car);
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(index, x, y);
                frame.drawPanel.revalidate();
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }

    void gas(int amount) {
        // TODO adapt to your needs
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }

    void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab95) {
                saab95.setTurboOff();
            }
        }
    }

    private void handleWalls(int index, Car car) {
        int maxX = frame.drawPanel.getWidth() - frame.drawPanel.getCarWidth(index);
        int maxY = frame.drawPanel.getHeight() - frame.drawPanel.getCarHeight(index);

        // TODO: one boolean per wall, as in the table above
        // (use car.getX(), car.getY() and car.getDirection() == Car.Direction.EAST etc.)
        boolean pastTop = car.getY() > maxY;
        boolean goingUp = car.getDirection() == Car.Direction.NORTH;
        if (pastTop && goingUp) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine(); // turn around and go the other way
        }

        boolean pastBottom = car.getY() < 0;
        boolean goingDown = car.getDirection() == Car.Direction.SOUTH;
        if (pastBottom && goingDown) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine(); // turn around and go the other way
        }

        boolean pastLeft = car.getX() < 0;
        boolean goingLeft = car.getDirection() == Car.Direction.WEST;
        if (pastLeft && goingLeft) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine(); // turn around and go the other way
        }

        boolean pastRight = car.getX() > maxX;
        boolean goingRight = car.getDirection() == Car.Direction.EAST;
        if (pastRight && goingRight) {
            car.stopEngine();
            car.turnRight();
            car.turnRight();
            car.startEngine(); // turn around and go the other way
        }
    }
}
