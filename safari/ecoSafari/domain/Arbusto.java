package domain;
import java.awt.Color;


//Include the documentation
public class Arbusto extends Organism implements Entity{
    private final EcoSafari habitat;
    private boolean hasActed;
    private int nmovimientos = 0;
    
    public Arbusto(EcoSafari habitat,int row, int column){
        this.habitat=habitat;
        habitat.set((Entity)this, row, column);  
        hasActed=false;
    }

    public EcoSafari getHabitat(){
        return habitat;
    }
    
    public final Color getColor(){
        if (nmovimientos < 3) {
            return Color.GREEN;
        } else {
            return Color.YELLOW;
        }
    }

    public final int shape(){
        return Entity.ROUND;
    }

    public void tic(){
        if ((! hasActed)) {
            nmovimientos += 1;
        }
        
        EcoSafari habitat = getHabitat();
    
        int[] position = habitat.find(this);
    
        int fila = position[0];
        int columna = position[1];
    
        for (int df = -1; df <= 1; df++) {
            for (int dc = -1; dc <= 1; dc++) {
    
                if (df != 0 || dc != 0) {
                    Entity e = habitat.get(fila + df, columna + dc);
    
                    if (e instanceof Elephant) {
                        disappear();
                    }
                }
            }
        }
        hasActed=true;
    }
    
    public void tac(){
        hasActed=false;
    }    
}
