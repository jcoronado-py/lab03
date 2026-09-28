package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class BabyElephantTest {
    private EcoSafari habitat;
    private babyElephant baby;

    @Before
    public void setUp(){
        habitat = new EcoSafari();
        baby = new babyElephant(habitat, 3, 3);
    }

    @Test
    public void testUbicacionInicial(){
        assertEquals(baby, habitat.get(3, 3));
        assertEquals(habitat, baby.getHabitat());
    }

    @Test
    public void testFormaYColorInicial(){
        assertEquals(Entity.ROUND, baby.shape());
        assertEquals(Color.PINK, baby.getColor());
    }
    @Test
    public void testTicMueveYConsumeEnergia(){
        int energiaInicial = baby.getEnergy();

        baby.tic();

        assertEquals(baby, habitat.get(5, 5));
        assertNull(habitat.get(3, 3));
        assertEquals(energiaInicial - 5, baby.getEnergy());
}
}