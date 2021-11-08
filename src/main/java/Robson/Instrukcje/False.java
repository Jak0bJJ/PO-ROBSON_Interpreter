package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

import java.util.HashMap;

@Value
class False extends Instrukcja {

    @JsonCreator
    public False() {
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        return "false";
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        return 0.0;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(false);";
    }
}
