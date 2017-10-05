import sbt.lessos10.Streams;

import java.util.ArrayList;
import java.util.List;



public class MainClass {
    public static void main(String[] args) {


        List <String> states = new ArrayList<String>();
        states.add("Германия");
        states.add("Франция");
        states.add("Великобритания");
        states.add("Испания");


        Streams <String> r = Streams.of(states);
        Streams <String> e = r.filter(s->s != "Германия");




    }
}
