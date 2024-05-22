
// Game sınıfı ata sınıf olarak alınıcak !

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);


    public void start() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("~~~~~~~~~~~~MACERA OYUNUNA HOŞGELDİNİZ~~~~~~~~~~~~~\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.print("~~~~~~NICKNAME  : ");

        String playerName = scanner.nextLine().toUpperCase();

        Player player = new Player(playerName);
        System.out.println("----------------------------------------------------------------");
        System.out.println("--- > " + player.getName() + " macera dolu adaya hoşgeldin ! Dikkat tehlikeler seni bekliyor <----");
        player.selectChar();


        // on location ne zaman false dönerse while sona erecek !
        // polymorphism
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("--------------------------------------------");
            System.out.println();

            System.out.println("\t~~~~~~~~~~~~LOKASYONLAR~~~~~~~~~~~~~~~~\t" +
                    "\n 1.Güvenli Ev --> Burası sizin için güvenli,düşman görünmüyor !" +
                    "\n 2.Eşya Dükkanı -->  Silah veya Zırh satın alabilirsiniz." +
                    "\n 3.Mağara -->  Mağaraya giriş , Ödül : <Yemek> , dikkatli ol her an zombi çıkabilir ! " +
                    "\n 4.Orman --> Ormana giriş, Ödül <Odun>, dikkatli ol her an vampir çıkabilir ! " +
                    "\n 5.Nehir --> Nehire giriş, Ödül <Su> dikkatli ol her an ayı çıkabilir !" +
                    "\n 6.Maden Ocağı --> Madene giriş, Ödül<Silah || Zırh || Para> dikkatli ol her an yılan çıkabilir !" +
                    "\n 0. Çıkış yap -> Oyunu sonlandır .");


            System.out.println();
            System.out.print("Lütfen lokasyon seçiniz : ");
            int selectLoc = scanner.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2 :
                    location = new ToolStore(player);
                    break;
                case 3 :
                    location = new Cave(player);
                    break;
                case 4 :
                    location = new Forest(player);
                    break;
                case 5 :
                    location = new River(player);
                    break;
                case 6 :
                    location = new Quarry(player);
                    break;

                default:
                    System.out.println("Lütfen geçerli bir bilge seçiniz !");
            }



            if (location==null) {
                System.out.println("Bu karanlık ve zorlu adadan çabuk vazgeçtin !");
                break;
            }
            if ( ! location.onLocation() )
            {
                System.out.println("GAME OVER !");
                break;
            }
        }

        }


    }

