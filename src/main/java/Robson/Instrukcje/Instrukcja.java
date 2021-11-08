package Robson.Instrukcje;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Blok.class, name = "Blok"),
        @JsonSubTypes.Type(value = Dzialanie.class, name = "Dzialanie"),
        @JsonSubTypes.Type(value = False.class, name = "False"),
        @JsonSubTypes.Type(value = True.class, name = "True"),
        @JsonSubTypes.Type(value = Zmienna.class, name = "Zmienna"),
        @JsonSubTypes.Type(value = If.class, name = "If"),
        @JsonSubTypes.Type(value = Not.class, name = "Not"),
        @JsonSubTypes.Type(value = Przypisanie.class, name = "Przypisanie"),
        @JsonSubTypes.Type(value = While.class, name = "While"),
        @JsonSubTypes.Type(value = Liczba.class, name = "Liczba"),
}
)
public abstract class Instrukcja {
    public abstract String ToWynik(HashMap<String, Double> map);

    public abstract String ToString(HashMap<String, Double> map);

    public abstract double Wykonaj(HashMap<String, Double> map);
}
