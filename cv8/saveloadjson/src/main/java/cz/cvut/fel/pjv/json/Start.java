package cz.cvut.fel.pjv.json;

public class Start {

  public static void main(String[] args) {
    MojeData md1 = new MojeData(
      "Hugo",
      11, 222, 3333,
      "Pepa", 89.444, "Mark", 98.456
    );
    JsonUtil ju = new JsonUtil();
    // jak ulozit vase data
    ju.saveJson(md1, "mojedata.json");
    // a jak je ziskat zpet
    MojeData md2 = ju.loadJson("mojedata.json");
    System.out.println(md2);
  }
}
