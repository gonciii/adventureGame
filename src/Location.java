
 import java.util.Scanner;

public abstract class Location {
    private String idLocaation;
    private Player player;
    private String name;
    public static Scanner scanner = new Scanner(System.in);

    // constructor
    public Location(String idLocaation,Player player,String name) {
        this.idLocaation = idLocaation;
        this.player = player;
        this.name = name;


    }

    // abstract metot --- > bu metotu diğer yavru classlarda override edeceğiz.
    public abstract boolean onLocation();

    // encapsulation get and set method
    public Player getPlayer(){
        return player;
    }

    public  void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdLocaation() {
        return idLocaation;
    }

    public void setIdLocaation(String idLocaation) {
        this.idLocaation = idLocaation;
    }
}
