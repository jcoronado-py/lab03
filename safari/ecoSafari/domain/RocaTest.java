package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class RocaTest {
    private EcoSafari habitat;
    private Roca roca;

    @Before
    public void setUp(){
        habitat = new EcoSafari();
        roca = new Roca(habitat, 4, 4);
    }

    @Test
    public void testUbicacionInicial(){
        assertEquals(roca, habitat.get(4, 4));
        assertEquals(habitat, roca.getHabitat());
    }

    @Test
    public void testFormaYColor(){
        assertEquals(Entity.SQUARE, roca.shape());
        assertEquals(Color.GRAY, roca.getColor());
    }

    @Test
    public void testTicNoMueveLaRoca(){
        roca.tic();

        assertEquals(roca, habitat.get(4, 4));
        assertFalse(roca.move(1, 1));
    }
}