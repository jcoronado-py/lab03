package domain;
import java.awt.Color;

/**
 * Otro tipo de elefante: se mueve en un radio mayor pero consume
 * menos energía por movimiento, y usa una paleta de color distinta.
 */
public class babyElephant extends Organism implements Entity{
    private final EcoSafari habitat;
    private boolean hasActed;

    public babyElephant(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set((Entity)this, row, column);
        hasActed = false;
    }

    public EcoSafari getHabitat(){
        return habitat;
    }

    public final Color getColor(){
        return (getEnergy() >= 80 ? Color.PINK : Color.WHITE);
    }

    public final int shape(){
        return Entity.ROUND;
    }

    public void tic(){
        if ((! hasActed) && (move(2, 2))) {
            changeEnergy(-5);
            if (getEnergy() == 0){
                disappear();
            }
        }
        hasActed = true;
    }

    public void tac(){
        hasActed = false;
    }
}