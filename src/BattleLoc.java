
// Savaş alanı --> abstracth tanımlandı.

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;   // -- canavar
    private String award;        // -- ödül
    private int maxObstacle;     // lokasyonhda max kaç tane canavar değişkeni



    public BattleLoc(String idLocation, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(idLocation, player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    public boolean onLocation() {
        //giriş kontrolü
        if(this.getPlayer().getAward().isAward(this.award)) {
            System.out.println("-----> GÖREV BAŞARILI ! BU BÖLGEDEKİ CANAVARLAR TEMİZLENDİ,BAŞKA BİR LOKASYON SEÇMELİSİN <<<<-----");
            System.out.println();
            return true;
        }

        int obsNumber = this.randomObstacleNumber();
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Şuan ki lokasyonunuz --->  " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " çıkabilir.");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.print("------------------<S>avaş veya <K>aç : ");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();

        if(selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " bölgesindeki  tüm düşmanları yendiniz !");
            this.getPlayer().getAward().addAward(this.getAward());
            this.getPlayer().getAward().printAward();
            return true;
        }


        if (this.getPlayer().getHealth() <= 0) {
            System.out.println(".... Öldünüz......");
            return false;
        }

        return true;

    }


    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());     // 2.canavar canı --- > orjinal can tazeleme

            playerStarts();     // oyuncu değerleri
            obstacleStarts(i);  // canavar değerleri

            // %50 ilk vuran oyuncu mu canavar mı ?
            Random random = new Random();
            boolean isFirstMove = random.nextBoolean();

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println();                       //   savaş başlama alanı
                System.out.print("------------------><V>ur veya <K>aç : ");


                String selectCombat = scanner.nextLine();
                selectCombat = selectCombat.toUpperCase();

                if (selectCombat.equals("V")) {
                    if(isFirstMove) {
                        System.out.println("------ > Siz vurdunuz !");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamge());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("------> Canavar size vurdu !");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        System.out.println("------> Canavar size vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("------> Siz vurdunuz !");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamge());
                            System.out.println();
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
                //break;
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println();
                System.out.println("Düşmanı yendiniz !");
                if(20 < this.getObstacle().getAwardMoney() && this.getObstacle().getAwardMoney() <=23) {
                    if(this.getObstacle().getAwardMoney() == 21) {
                        System.out.println("Tüfek kazandınız !");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
                    } else if(this.getObstacle().getAwardMoney() == 22) {
                        System.out.println("Kılıç kazandınız !");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
                    } else if (this.getObstacle().getAwardMoney() == 23) {
                        System.out.println("Tabanca kazandınız !");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1));
                    }
                    
                    
                } else if (23 < this.getObstacle().getAwardMoney() && this.getObstacle().getAwardMoney() <=26) {
                    if(this.getObstacle().getAwardMoney() == 24) {
                        System.out.println("Ağır zırh kazandınız !");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
                    } else if (this.getObstacle().getAwardMoney() == 25)  {
                        System.out.println("Orta zırh kazandınız !");
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(2));
                    } else if (this.getObstacle().getAwardMoney() == 26) {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1));
                    }
                    
                    
                } else if (26 < this.getObstacle().getAwardMoney() && this.getObstacle().getAwardMoney() <= 29) {
                    {
                        if (this.getObstacle().getAwardMoney() == 27) {
                            System.out.println("10 para kazandınız !");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                            System.out.println("Güncel bakiyeniz  : " + this.getPlayer().getMoney());
                        } else if (this.getObstacle().getAwardMoney() == 28) {
                            System.out.println("5 para kazandınız !");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                            System.out.println("Güncel bakiyeniz :" + this.getPlayer().getMoney());
                        } else if (this.getObstacle().getAwardMoney() == 29) {
                            System.out.println("1 para kazandınız !");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                            System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                        }
                    }



                } else if (this.getObstacle().getAwardMoney() == 30) {
                    System.out.println("Hiç bir şey kazanamadınız !");
                } else {
                    System.out.println(this.getObstacle().getAwardMoney() + " para kazandınız :) ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAwardMoney());
                    System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());

                }


            } else {
                return false;
            }



        }

        return true;
    }




    public int randomObstacleNumber() {
        Random input = new Random();
        return input.nextInt(this.getMaxObstacle()) + 1 ;
    }



    public void playerStarts() {
        System.out.println("--------------------------------------");
        System.out.println("-------OYUNCU DEĞERLERİ------- ");
        System.out.println("Sağlık : " +this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName() );
        System.out.println("Zırh : " +this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamge());
        System.out.println("Para : " + this.getPlayer().getMoney());


    }
    public void obstacleStarts(int i) {
        System.out.println("------CANAVAR DEĞERLERİ------- ");
        System.out.println(i + "." +this.getObstacle().getName() + " değerİ.");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül :" + this.getObstacle().getAwardMoney());
    }
    public void afterHit() {
        System.out.println("Oyuncunun kalan canı : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " kalan  canı : " + this.getObstacle().getHealth());
    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
