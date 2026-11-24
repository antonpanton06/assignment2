import javax.swing.*;

void main() {
    // Instance of this class
    CarController cc = new CarController();

    cc.cars.add(new Volvo240(0,0));
    cc.cars.add(new Saab95(200, 0));

    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.frame.drawPanel.addCar("pics/Volvo240.jpg");
    cc.frame.drawPanel.addCar("pics/Saab95.jpg");
    cc.startTimer();
}