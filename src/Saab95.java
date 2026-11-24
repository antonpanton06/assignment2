import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
        this.turboOn = false;
    }

    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95", 200, 0);
        this.turboOn = false;
    }

    public Saab95(double x, double y) {
        super(2,125,0, Color.red,"Saab95", x, y);
        this.turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
