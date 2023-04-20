package cz.cvut.fel.pjv.json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MojeData {
  // sem doplnte Vase data
  private String jmeno;
  private List<Integer> cisla = new ArrayList<>();
  private Map<String, Double> vysledky = new LinkedHashMap<>();

  // MUSI byt i prazdny konstruktor
  public MojeData() {
  }

  public MojeData(
    String jmeno,
    int cislo1, int cislo2, int cislo3,
    String v1str, double v1double, String v2str, double v2double
  ) {
    this.jmeno = jmeno;
    cisla.add(cislo1);
    cisla.add(cislo2);
    cisla.add(cislo3);
    vysledky.put(v1str, v1double);
    vysledky.put(v2str, v2double);
  }

  // MUSI byt na vse getter a setter, nebo je dat public
  public String getJmeno() {
    return jmeno;
  }

  public List<Integer> getCisla() {
    return cisla;
  }

  public Map<String, Double> getVysledky() {
    return vysledky;
  }

  // tohle tady byt nemusi, je zde jenom kvuli testovani
  @Override
  public String toString() {
    return "MojeData{" +
      "jmeno='" + jmeno + '\'' +
      ", cisla=" + cisla +
      ", vysledky=" + vysledky +
      '}';
  }
}
