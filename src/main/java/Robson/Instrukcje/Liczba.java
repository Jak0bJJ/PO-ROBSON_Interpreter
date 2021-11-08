package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
public class Liczba extends Instrukcja {

    double wartosc;

    @JsonCreator
    public Liczba(@JsonProperty("wartosc") final double wartosc) {
        this.wartosc = requireNonNull(wartosc);
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        return String.valueOf(wartosc);
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        return wartosc;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(" + wartosc + ");";
    }
}
