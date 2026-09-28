package domain;

import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Color;

public class ArbustoTest {

    @Test
    public void colorCambiaAAmarilloTrasTresMovimientos() {
        EcoSafari habitat = new EcoSafari();
        Arbusto arbusto = new Arbusto(habitat, 2, 2);

        assertEquals(Color.GREEN, arbusto.getColor());

        arbusto.tic();
        arbusto.tac();
        arbusto.tic();
        arbusto.tac();
        arbusto.tic();

        assertEquals(Color.YELLOW, arbusto.getColor());
    }

    @Test
    public void desapareceCuandoHayElefanteAlLado() {
        EcoSafari habitat = new EcoSafari();
        Arbusto arbusto = new Arbusto(habitat, 2, 2);
        Elephant elefante = new Elephant(habitat, 2, 3);

        arbusto.tic();

        assertNull(habitat.get(2, 2));
    }
}