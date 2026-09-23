package domain;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
public class Leon extends Organism implements Entity{
    private static final Random random = new Random();
 
    private final EcoSafari habitat;
    private boolean hasActed;
 
    public Leon(EcoSafari habitat, int row, int column){
        this.habitat = habitat;
        habitat.set((Entity) this, row, column);
        hasActed = false;
    }
 
    public EcoSafari getHabitat(){
        return habitat;
    }
 
    public final Color getColor(){
        return new Color(218, 165, 32); // dorado/leon
    }
 
    public final int shape(){
        return Entity.ROUND;
    }
 
    public void tic(){
        if (!hasActed){
            moverUnaCelda();
            comer();
            reproducir();
            if (getEnergy() == 0){
                disappear();
            }
            hasActed = true;
        }
    }
 
    public void tac(){
        hasActed = false;
    }
 
    private void moverUnaCelda(){
        int[] posicion = habitat.find(this);
        if (posicion == null) return;
        List<int[]> tierras = vecinosTierra(posicion[0], posicion[1]);
        if (!tierras.isEmpty()){
            int[] destino = tierras.get(random.nextInt(tierras.size()));
            Entity tierra = habitat.get(destino[0], destino[1]);
            habitat.set(tierra, posicion[0], posicion[1]);
            habitat.set(this, destino[0], destino[1]);
            changeEnergy(-10);
        }
    }
 
    private void comer(){
        int[] posicion = habitat.find(this);
        if (posicion == null) return;
        for (int df = -1; df <= 1; df++){
            for (int dc = -1; dc <= 1; dc++){
                if (df == 0 && dc == 0) continue;
                int f = posicion[0] + df;
                int c = posicion[1] + dc;
                if (habitat.isInside(f, c) && habitat.get(f, c) instanceof Cebra){
                    ((Cebra) habitat.get(f, c)).disappear();
                    changeEnergy(0.50f);
                    return;
                }
            }
        }
    }
 
    private void reproducir(){
        int[] posicion = habitat.find(this);
        if (posicion == null) return;
        for (int[] tierra : vecinosTierra(posicion[0], posicion[1])){
            for (int df = -1; df <= 1; df++){
                for (int dc = -1; dc <= 1; dc++){
                    if (df == 0 && dc == 0) continue;
                    int f = tierra[0] + df;
                    int c = tierra[1] + dc;
                    if (habitat.isInside(f, c) && habitat.get(f, c) instanceof Leon
                            && !(f == posicion[0] && c == posicion[1])){
                        new Leon(habitat, tierra[0], tierra[1]);
                        return;
                    }
                }
            }
        }
    }
 
    private List<int[]> vecinosTierra(int fila, int columna){
        List<int[]> resultado = new ArrayList<>();
        for (int df = -1; df <= 1; df++){
            for (int dc = -1; dc <= 1; dc++){
                if (df == 0 && dc == 0) continue;
                int f = fila + df;
                int c = columna + dc;
                if (habitat.isInside(f, c) && habitat.get(f, c) instanceof Tierra){
                    resultado.add(new int[]{f, c});
                }
            }
        }
        return resultado;
    }
}