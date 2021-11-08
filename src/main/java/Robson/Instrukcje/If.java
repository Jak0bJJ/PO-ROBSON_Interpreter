package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class If extends Instrukcja {

    Instrukcja warunek;
    Blok blok_prawda;
    Blok blok_falsz;

    @JsonCreator
    public If(@JsonProperty("warunek") final Instrukcja warunek,
              @JsonProperty("blok_prawda") final Blok blok_prawda,
              @JsonProperty("blok_falsz") final Blok blok_falsz) {
        this.warunek = requireNonNull(warunek);
        this.blok_prawda = requireNonNull(blok_prawda);
        if (blok_falsz == null) {
            List<Instrukcja> list = new ArrayList<>();
            Liczba zero = new Liczba(0);
            list.add(zero);
            this.blok_falsz = new Blok(list);
        } else
            this.blok_falsz = requireNonNull(blok_falsz);
    }


    @Override
    public String ToString(HashMap<String, Double> map) {
        String res = "if(";
        res += warunek.ToString(map) + ")\n{\n";
        res += blok_prawda.ToString(map) + "}\nelse\n{\n";
        res += blok_falsz.ToString(map) + "}\n";
        return res;
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        if (warunek.Wykonaj(map) == 1.0)
            return blok_prawda.Wykonaj(map);
        else
            return blok_falsz.Wykonaj(map);
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        String res = "if(";
        res += warunek.ToString(map) + ")\n{\n";
        res += blok_prawda.ToWynik(map) + "}\nelse\n{\n";
        res += blok_falsz.ToWynik(map) + "}\n";
        return res;
    }
}
