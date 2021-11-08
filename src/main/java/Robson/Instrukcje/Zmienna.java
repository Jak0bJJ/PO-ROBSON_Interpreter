package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
class Zmienna extends Instrukcja {

    String nazwa;

    @JsonCreator
    public Zmienna(@JsonProperty("nazwa") final String nazwa) {
        this.nazwa = requireNonNull(nazwa);
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        return nazwa;
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        return map.get(nazwa);
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(" + nazwa + ");";
    }
}
