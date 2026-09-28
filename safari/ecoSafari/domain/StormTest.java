package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class StormTest {

    private EcoSafari habitat;
    private Storm storm;

    @Before
    public void setUp(){
        habitat = new EcoSafari();
        storm = new Storm(habitat, 5, 5);
    }

    @Test
    public void testTicDestruyeVecindarioYSeMueveAlNoreste(){
        int fila = 5;
        int columna = 5;
        int nuevaFila = fila - 1;
        int nuevaColumna = columna + 1;

        storm.tic();

        for (int df = -1; df <= 1; df++){
            for (int dc = -1; dc <= 1; dc++){
                if (df == 0 && dc == 0) continue;
                int f = fila + df;
                int c = columna + dc;
                if (f == nuevaFila && c == nuevaColumna) continue;
                Entity e = habitat.get(f, c);
                assertNotNull(e);
                assertEquals(Color.GRAY, e.getColor());
            }
        }

        assertNull(habitat.get(fila, columna));
        assertSame(storm, habitat.get(nuevaFila, nuevaColumna));
        assertEquals(Color.BLACK, storm.getColor());
    }

    @Test
    public void testTicRebotaEnFilaCuandoNoHayFilaNorte(){
        int fila = 0;
        int columna = 4;
        Storm edgeStorm = new Storm(habitat, fila, columna);
        int nuevaFila = habitat.isInside(fila - 1, columna) ? fila - 1 : fila;
        int nuevaColumna = habitat.isInside(fila, columna + 1) ? columna + 1 : columna;

        edgeStorm.tic();

        for (int df = -1; df <= 1; df++){
            for (int dc = -1; dc <= 1; dc++){
                if (df == 0 && dc == 0) continue;
                int f = fila + df;
                int c = columna + dc;
                if (!habitat.isInside(f, c)) continue;
                if (f == nuevaFila && c == nuevaColumna) continue;
                Entity e = habitat.get(f, c);
                assertNotNull(e);
                assertEquals(Color.GRAY, e.getColor());
            }
        }

        assertNull(habitat.get(fila, columna));
        assertSame(edgeStorm, habitat.get(nuevaFila, nuevaColumna));
    }
}