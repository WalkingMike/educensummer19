import java.lang.Integer;

/**
 * @author WalkingMike
 * @version 1.0
 */
public class Cat implements Comparable<Cat>{
    private int legs;
    private String voice;

    public Cat(){
        setLegs(4);
        setVoice("meow");
    }

    public int getLegs(){
        return legs;
    }

    public void setLegs(int lgs){
        legs = lgs;
    }

    public String getVoice(){
        return voice;
    }

    public void setVoice(String vce){
        voice = vce;
    }

    public int compareTo(Cat other) {
        return Integer.valueOf(this.hashCode()).compareTo(other.hashCode());
    }

    public void walk(){
        String walkytalky = "";
        for (int i = 0; i < legs; i++)
            walkytalky += "tap";
        walkytalky += " " + voice;
        System.out.println(walkytalky);
    }
}
