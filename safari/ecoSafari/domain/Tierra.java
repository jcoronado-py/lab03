package domain;
import java.awt.Color;
import java.util.Random;
 
public class Tierra implements Entity{
    private static final Random random = new Random();
    private static final double PROBABILIDAD_PASTO = 0.10;
 
    private final EcoSafari habitat;
 
    public Tierra(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set((Entity) this, row, column);
    }
 
    public EcoSafari getHabitat(){
        return habitat;
    }
 
    public final Color getColor(){
        return new Color(139, 69, 19); // marron
    }
 
    public void tic(){
        if (random.nextDouble() < PROBABILIDAD_PASTO){
            int[] position = habitat.find(this);
            if (position != null){
                new Pasto(habitat, position[0], position[1]);
            }
        }
    }
}
 