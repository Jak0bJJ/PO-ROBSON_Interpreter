package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
public class While extends Instrukcja {

    Instrukcja warunek;
    Blok blok;

    @JsonCreator
    public While(@JsonProperty("warunek") final Instrukcja warunek,
                 @JsonProperty("blok") final Blok blok) {
        this.warunek = requireNonNull(warunek);
        this.blok = requireNonNull(blok);
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        String res = "while(";
        res += warunek.ToString(map) + ")\n{\n";
        res += blok.ToString(map) + "}\n";
        return res;
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        while (warunek.Wykonaj(map) == 1)
            blok.Wykonaj(map);
        return 0.0;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return this.ToString(map) + "System.out.println(0);";
    }
}
