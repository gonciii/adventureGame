import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;
    private Award award;

    // constructor
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        this.award = new Award();

    }

    // solid prensibi ile yapmak: bir metot bir görevi yapsın bu da karakter seçimi !
    public void selectChar() {

        // "polymorphism" sayesinde gamecharacter üst sınıf olduğu için bu sınıftan bir array oluşturupu kullandım.
        GameCharacter[] gameCharactersList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("\n------------OYUN KARAKTERLKERİ-----------\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (GameCharacter gameCharacter : gameCharactersList) {
            System.out.println("ID : "  + gameCharacter.getId() + " Karakter : " + gameCharacter.getName() + "  \t  Hasar : " + gameCharacter.getDamage() + "\t Sağlık : " + gameCharacter.getHealth() + " \t Para : " + gameCharacter.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz : ");
        System.out.println();
        int selectChar = scanner.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
            default:
                initPlayer(new Samurai());
        }

        System.out.println(
                "Seçtiğin Karakter => " + this.getCharName() + " ," +
                        "Hasar : "  + this.getDamage() +  " ," +
                        "Sağlık : " + this.getHealth() + " ," +
                        "Para : " + this.getMoney()
        );
        System.out.println();

    }

    // BU İNİT METOTU ÇOK BİÇİMLİ DAVRANIR ÇÜNKÜ PARAMETRE OLARAK GAMECHARACTER ALIR SAMUSARYSA SAMURAY VE YA OKÇU !
    public void initPlayer(GameCharacter gameCharacter) {

      this.setDamage(gameCharacter.getDamage());
      this.setHealth(gameCharacter.getHealth());
      this.setOrjinalHealth(gameCharacter.getHealth());
      this.setMoney(gameCharacter.getMoney());
      this.setCharName(gameCharacter.getName());

    }
    public void printInfo() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(
                                "Silahınız => " + this.getInventory().getWeapon().getName() + " ," +
                                "Zırh Seçiminiz " + this.getInventory().getArmor().getName() + " ," +
                                "Bloklama : " + this.getInventory().getArmor().getBlock() +  " ," +
                                "Hasar : "  + this.getDamage() +  " ," +
                                "Sağlık : " + this.getHealth() + " ," +
                                "Para : " + this.getMoney()
        );

    }
    // total damage
    public int getTotalDamge() {
        return damage + this.getInventory().getWeapon().getDamage();
    }


    // encapsulation get and set metot
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        if (health <= 0) {
            health =0 ;
        }
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }



    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }
}
