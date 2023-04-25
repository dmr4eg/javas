
package pjv.hodina10;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {    
    
    private int xPosition, yPosition, radius = 50;
    public int xVelocity = 3, yVelocity = 8; 
    
    
    public Model() {
    }

    /**
     * @return the xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * @param xPosition the xPosition to set
     */
    public void setxPosition(int xPosition) {
        setChanged();
        this.xPosition = xPosition;
    }

    /**
     * @return the yPosition
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * @param yPosition the yPosition to set
     */
    public void setyPosition(int yPosition) {
        setChanged();
        this.yPosition = yPosition;
    }

    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        setChanged();
        this.radius = radius;
    }
}
