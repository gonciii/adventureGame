import java.util.Random;

// snake class

public class Snake  extends Obstacle {


    public Snake() {
        super(4,"Yılan",randomDamage(),12,randomAwards());
    }


    // random damage
    public static int randomDamage() {
        Random random = new Random();
        return random.nextInt(3, 7);
    }

    // random awards
    public static int randomAwards() {
        Random random = new Random();
        int awardProbale = random.nextInt(100) + 1;
        int awardId;

        if(awardProbale <= 15) {
            // silah
            int weaponProbable = random.nextInt(100) +1 ;
            // tüfek
            if(weaponProbable <= 20) {
                return  awardId =21;
                // kılıç
            } else if (weaponProbable <= 50) {
                return awardId=22;
                // tabanca
            } else {
                return awardId =23;
            }

        } else if (awardProbale <= 30) {

            int armorProbable = random.nextInt(100) + 1 ;
            if(armorProbable <=20) {
                return awardId =24;
            } else if (armorProbable<= 50) {
                return  awardId = 25;
            } else {
                return awardId= 26;
            }
        } else if (30 < awardProbale && awardProbale <= 55) {

            int moneyProbable = random.nextInt(100) +1 ;
            if(moneyProbable <= 20) {
                return awardId = 27;
            } else if (moneyProbable <= 50) {
                return awardId = 28;
            } else {
                return awardId = 29;
            }

        } else {
            return 30 ; // hiçbir şey kazanamama
        }
    }



}
