package domain;
import java.awt.Color;
 
public class Storm implements Entity{
    private final EcoSafari habitat;
    private boolean hasActed;
 
    public Storm(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set((Entity) this, row, column);
        hasActed = false;
    }
 
    public EcoSafari getHabitat(){
        return habitat;
    }
 
    public final Color getColor(){
        return Color.BLACK;
    }
 
    public final int shape(){
        return Entity.SQUARE;
    }
 
    public void tic(){
        if (!hasActed){
            int[] position = habitat.find(this);
            if (position != null){
                int fila = position[0];
                int columna = position[1];
 
                // destruye el area afectada (diametro 3, vecindario de Moore) y la deja gris
                for (int df = -1; df <= 1; df++){
                    for (int dc = -1; dc <= 1; dc++){
                        int f = fila + df;
                        int c = columna + dc;
                        if (habitat.isInside(f, c) && !(df == 0 && dc == 0)){
                            habitat.set(new StormDebris(habitat), f, c);
                        }
                    }
                }
 
                // el centro se desplaza circularmente en diagonal noreste
                int nuevaFila = fila - 1;
                int nuevaColumna = columna + 1;
                if (!habitat.isInside(nuevaFila, columna)){
                    nuevaFila = fila; // rebota si no hay fila norte
                }
                if (!habitat.isInside(fila, nuevaColumna)){
                    nuevaColumna = columna; // rebota si no hay columna este
                }
                habitat.set(null, fila, columna);
                habitat.set(this, nuevaFila, nuevaColumna);
            }
            hasActed = true;
        }
    }
 
    public void tac(){
        hasActed = false;
    }
 
    // Entidad auxiliar inerte que representa el area gris dejada por la tormenta
    private static class StormDebris implements Entity{
        private final EcoSafari habitat;
 
        StormDebris(EcoSafari habitat){
            this.habitat = habitat;
        }
 
        public void tic(){}
 
        public Color getColor(){
            return Color.GRAY;
        }
 
        public EcoSafari getHabitat(){
            return habitat;
        }
    }
}