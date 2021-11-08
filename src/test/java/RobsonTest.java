
import Robson.Blad.BladWykonania;
import Robson.Blad.NieprawidlowyProgram;
import Robson.Robson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobsonTest
{
    @Test
    public void PrzykladJedenTest ()
    {
        Robson robson = new Robson();
        String filename = "src\\main\\java\\Robson\\Testy\\Przyklad1.json";
        try {
            robson.fromJSON(filename);
            try {
                assertEquals(robson.wykonaj(), 15.0 );
            } catch (BladWykonania bladWykonania) {
                bladWykonania.printStackTrace();
            }
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
    }

    @Test
    public void PrzykladDwaTest ()
    {
        Robson robson = new Robson();
        String filename = "src\\main\\java\\Robson\\Testy\\Przyklad2.json";
        try {
            robson.fromJSON(filename);
            try {
                assertEquals(robson.wykonaj(), 55.0 );
            } catch (BladWykonania bladWykonania) {
                bladWykonania.printStackTrace();
            }
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
    }

    @Test
    public void PrzykladEuklides ()
    {
        Robson robson = new Robson();
        String filename = "src\\main\\java\\Robson\\Testy\\Euklides.json";
        try {
            robson.fromJSON(filename);
            try {
                assertEquals(robson.wykonaj(), 10.0 );
            } catch (BladWykonania bladWykonania) {
                bladWykonania.printStackTrace();
            }
        } catch (NieprawidlowyProgram nieprawidlowyProgram) {
            nieprawidlowyProgram.printStackTrace();
        }
    }
}