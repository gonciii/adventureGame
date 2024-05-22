
// Canavar sınıfı

public class Obstacle {

    private int id;
    private String name;
    private int damage;
    private int health;
    private int awardMoney;
    private int orjinalHealth;

    public Obstacle(int id, String name, int damage, int health,int awardMoney) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orjinalHealth = health;    // 2.roundda canavarın canı 0 olmaması için !
        this.awardMoney = awardMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }
    // encaspsulkation : ansamsızlığa engel olduk can eksiye düşmedi
    public void setHealth(int health) {
        if (health < 0 ) {
            health = 0;
        }
        this.health = health;
    }

    public int getAwardMoney() {
        return awardMoney;
    }

    public void setAwardMoney(int awardMoney) {
        this.awardMoney = awardMoney;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
