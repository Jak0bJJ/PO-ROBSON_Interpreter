package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
public class Przypisanie extends Instrukcja {

    String nazwa;
    Instrukcja wartosc;

    @JsonCreator
    public Przypisanie(@JsonProperty("nazwa") final String nazwa,
                       @JsonProperty("wartosc") final Instrukcja wartosc) {
        this.nazwa = requireNonNull(nazwa);
        this.wartosc = requireNonNull(wartosc);
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        if (map.containsKey(nazwa)) {
            map.put(nazwa, wartosc.Wykonaj(map));
            return nazwa + " = " + wartosc.ToString(map);
        } else {
            map.put(nazwa, wartosc.Wykonaj(map));
            return "double " + nazwa + " = " + wartosc.ToString(map);
        }

    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        double res = wartosc.Wykonaj(map);
        map.put(nazwa, res);
        return res;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return this.ToString(map) + "\nSystem.out.println(" + nazwa + ");";
    }
}
