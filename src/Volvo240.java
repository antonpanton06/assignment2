import java.awt.*;

public class Volvo240 extends Car {

    private final double trimFactor;

    public Volvo240(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double x, double y) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, x, y);
        this.trimFactor = 1.25;
    }

    public Volvo240() {
        super(4, 100, 0, Color.black, "Volvo240", 0, 0);
        this.trimFactor = 1.25;
    }

    public Volvo240(double x, double y) {
        super(4, 100, 0, Color.black, "Volvo240", x, y);
        this.trimFactor = 1.25;
    }

    private double getTrimFactor() {
        return trimFactor;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01 * getTrimFactor();
    }
}
