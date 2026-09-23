package domain;
import java.awt.Color;
 
public class Pasto extends Organism implements Entity{
    private final EcoSafari habitat;
 
    public Pasto(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set((Entity) this, row, column);
    }
 
    public EcoSafari getHabitat(){
        return habitat;
    }
 
    public final Color getColor(){
        return Color.GREEN;
    }
 
    public void tic(){
        // el pasto no se mueve ni actua; solo es consumido por las cebras
    }
}