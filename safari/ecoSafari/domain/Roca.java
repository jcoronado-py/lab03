package domain;
import java.awt.Color;

public class Roca implements Entity{
    private final EcoSafari habitat;

    public Roca(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set(this, row, column);
    }

    public EcoSafari getHabitat(){
        return habitat;
    }

    public Color getColor(){
        return Color.GRAY;
    }

    public int shape(){
        return Entity.SQUARE;
    }

    public boolean move(int deltaRows, int deltaColumns){
        return false;
    }

    public void tic(){
    }
}