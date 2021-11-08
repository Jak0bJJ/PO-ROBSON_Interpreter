package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.HashMap;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Value
public class Blok extends Instrukcja {

    List<Instrukcja> instrukcje;

    @JsonCreator
    public Blok(@JsonProperty("instrukcje") final List<Instrukcja> vehicles) {
        this.instrukcje = requireNonNull(vehicles);
    }


    @Override
    public String ToWynik(HashMap<String, Double> map) {
        if (instrukcje.isEmpty()) {
            return "System.out.println(0);";
        }
        String res = "";
        for (int i = 0; i < instrukcje.size(); ++i) {
            if (i != instrukcje.size() - 1)
                res += instrukcje.get(i).ToString(map) + ";\n";
            else
                res += instrukcje.get(i).ToWynik(map) + "\n";
        }
        return res;
    }

    @Override
    public String ToString(HashMap<String, Double> map) {
        String res = "";
        for (int i = 0; i < instrukcje.size(); ++i) {
            res += instrukcje.get(i).ToString(map) + ";\n";
        }
        return res;
    }

    @Override
    public double Wykonaj(HashMap<String, Double> map) {
        if (instrukcje.isEmpty()) {
            return 0.0;
        }
        for (int i = 0; i < instrukcje.size() - 1; ++i) {
            instrukcje.get(i).Wykonaj(map);
        }
        return instrukcje.get(instrukcje.size() - 1).Wykonaj(map);
    }
}
