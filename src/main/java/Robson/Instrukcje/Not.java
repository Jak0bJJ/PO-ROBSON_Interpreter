package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
public class Not extends Instrukcja {

    Instrukcja argument;

    @JsonCreator
    public Not(@JsonProperty("argument") final Instrukcja argument) {
        this.argument = requireNonNull(argument);
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        return "!(" + argument.ToString(map) + ")";
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        if (argument.Wykonaj(map) == 0.0)
            return 1.0;
        else
            return 0.0;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(" + this.ToString(map) + ");";
    }
}
