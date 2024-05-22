import java.util.ArrayList;
import java.util.Arrays;

public class Award {
    private final ArrayList<String> awardArrayList;


    // constructor
    public Award() {
        this.awardArrayList = new ArrayList<>(3);
    }

    public void addAward(String string) {
        awardArrayList.add(string);
        System.out.println(string + " ödülü eklendi !");
    }
    public void printAward() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~KAZANILAN ÖDÜLLER~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(Object object : awardArrayList) {
            System.out.println(object);
        }
    }
    public boolean isAward(String string) {

        if(string.equals("Eşya<Silah||Zırh||Para>")) {
            return false;
        } else {
            return awardArrayList.contains(string);
        }
    }
    // tüm ödülleri toplama metotu --- > isFinish ?
    public boolean isFinish() {
        return awardArrayList.contains("Food") && awardArrayList.contains("Firewood") && awardArrayList.contains("Su");
    }
}
