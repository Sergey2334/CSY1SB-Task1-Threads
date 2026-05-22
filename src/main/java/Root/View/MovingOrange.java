package Root.View;

import java.awt.*;

public class MovingOrange {
    private double currentX;
    private double currentY;
    private final double targetX;
    private final double targetY;
    private final double speed; // Pixels per frame update
    private boolean arrived;

    public MovingOrange(int startX, int startY, int targetX, int targetY, double speed) {
        this.currentX = startX;
        this.currentY = startY;
        this.targetX = targetX;
        this.targetY = targetY;
        this.speed = speed;
        this.arrived = false;
    }

    /**
     * Updates the position of the orange, gliding it toward the target.
     */
    public void updatePosition() {
        if (this.arrived) return;

        // Calculate distance to target
        double deltaX = this.targetX - this.currentX;
        double deltaY = this.targetY - this.currentY;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // If close enough, snap to target and mark as arrived
        if (distance <= this.speed) {
            this.currentX = this.targetX;
            this.currentY = this.targetY;
            this.arrived = true;
        } else {
            // Move along the unit vector toward the target
            this.currentX += (deltaX / distance) * this.speed;
            this.currentY += (deltaY / distance) * this.speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(new Color(255, 140, 0)); // Bright Orange
        g2.fillOval((int) this.currentX - 6, (int) this.currentY - 6, 12, 12);
    }

    public boolean hasArrived() {
        return this.arrived;
    }
}