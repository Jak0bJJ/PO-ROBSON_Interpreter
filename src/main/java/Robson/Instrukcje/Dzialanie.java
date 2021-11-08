package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Value
public class Dzialanie extends Instrukcja {
    String znak;
    Instrukcja argument1;
    Instrukcja argument2;

    @JsonCreator
    public Dzialanie(@JsonProperty("znak") final String znak,
                     @JsonProperty("argument1") final Instrukcja argument1,
                     @JsonProperty("argument2") final Instrukcja argument2) {
        this.argument1 = requireNonNull(argument1);
        this.argument2 = requireNonNull(argument2);
        this.znak = requireNonNull(znak);
    }


    @Override
    public String ToString(HashMap<String, Double> map) {
        return argument1.ToString(map) + " " + znak + " " + argument2.ToString(map);
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        if (znak.equals("+"))
            return argument1.Wykonaj(map) + argument2.Wykonaj(map);
        else if (znak.equals("-"))
            return argument1.Wykonaj(map) - argument2.Wykonaj(map);
        else if (znak.equals("*"))
            return argument1.Wykonaj(map) * argument2.Wykonaj(map);
        else if (znak.equals("/"))
            return argument1.Wykonaj(map) / argument2.Wykonaj(map);
        else if (znak.equals("||")) {
            if (argument1.Wykonaj(map) != 0.0 || argument2.Wykonaj(map) != 0.0)
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals("&&")) {
            if (argument1.Wykonaj(map) != 0.0 && argument2.Wykonaj(map) != 0.0)
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals("==")) {
            if (argument1.Wykonaj(map) == argument2.Wykonaj(map))
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals("<=")) {
            if (argument1.Wykonaj(map) <= argument2.Wykonaj(map))
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals(">=")) {
            if (argument1.Wykonaj(map) >= argument2.Wykonaj(map))
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals("<")) {
            if (argument1.Wykonaj(map) < argument2.Wykonaj(map))
                return 1.0;
            else
                return 0.0;
        } else if (znak.equals(">")) {
            if (argument1.Wykonaj(map) > argument2.Wykonaj(map))
                return 1.0;
            else
                return 0.0;
        }
        return 1.0;
    }

    @Override
    public String ToWynik(HashMap<String, Double> map) {
        return "\nSystem.out.println(" + this.ToString(map) + ");";
    }
}
