package Robson;

import Robson.Blad.*;
import Robson.Instrukcje.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;


public class Robson {

    private Instrukcja robson = null;

    public void fromJSON(String filename) throws NieprawidlowyProgram
    {
        try {
            String tekst = Files.readString(Path.of(filename));
            ObjectMapper objectMapper = new ObjectMapper();
            tekst = tekst.replaceAll("typ", "@type");
            tekst = tekst.replaceAll("\"Plus\"", "\"Dzialanie\",\n\"znak\": \"+\"");
            tekst = tekst.replaceAll("\"Minus\"", "\"Dzialanie\",\n\"znak\": \"-\"");
            tekst = tekst.replaceAll("\"Razy\"", "\"Dzialanie\",\n\"znak\": \"*\"");
            tekst = tekst.replaceAll("\"Dzielenie\"", "\"Dzialanie\",\n\"znak\": \"/\"");
            tekst = tekst.replaceAll("\"And\"", "\"Dzialanie\",\n\"znak\": \"&&\"");
            tekst = tekst.replaceAll("\"Or\"", "\"Dzialanie\",\n\"znak\": \"||\"");
            tekst = tekst.replaceAll("\"==\"", "\"Dzialanie\",\n\"znak\": \"==\"");
            tekst = tekst.replaceAll("\">=\"", "\"Dzialanie\",\n\"znak\": \">=\"");
            tekst = tekst.replaceAll("\"<=\"", "\"Dzialanie\",\n\"znak\": \"<=\"");
            tekst = tekst.replaceAll("\"<\"", "\"Dzialanie\",\n\"znak\": \"<\"");
            tekst = tekst.replaceAll("\">\"", "\"Dzialanie\",\n\"znak\": \">\"");
            robson = objectMapper.readValue(tekst, Instrukcja.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toJSON(String filename)
    {
        try
        {
            File myObj = new File(filename);
            myObj.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            String ToJson = objectMapper.writeValueAsString(robson);
            ToJson = ToJson.replaceAll("@type","typ" );
            ToJson = ToJson.replaceAll( "\"Dzialanie\",\"znak\":\"\\+\"","\"Plus\"");
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"-\"","\"Minus\"" );
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"\\*\"","\"Razy\"");
            ToJson = ToJson.replaceAll( "\"Dzialanie\",\"znak\":\"/\"","\"Dzielenie\"");
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"&&\"","\"And\"") ;
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"\\|\\|\"","\"Or\"");
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"==\"","\"==\"");
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\">=\"","\">=\"" );
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"<=\"","\"<=\"") ;
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\"<\"","\"<\"" );
            ToJson = ToJson.replaceAll("\"Dzialanie\",\"znak\":\">\"","\">\"");
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(ToJson);
            myWriter.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toJava(String filename)
    {
        try
        {
            File myObj = new File(filename);
            myObj.createNewFile();
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap<String, Double> map = new HashMap<>();
            String ToJava = robson.ToWynik(map);
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("public class Main {\n" + "\n" + "public static void main(String[] args) {\n");
            myWriter.write(ToJava);
            myWriter.write("}\n" + "}");
            myWriter.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double wykonaj() throws BladWykonania
    {
        if (robson==null)
            throw new BladWykonania();
        HashMap<String, Double> map = new HashMap<>();
        return robson.Wykonaj(map);
    }

}
