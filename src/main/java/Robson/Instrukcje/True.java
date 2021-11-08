package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

import java.util.HashMap;

@Value
class True extends Instrukcja {

    @JsonCreator
    public True() {
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        return "true";
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        return 1.0;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(true);";
    }
}
