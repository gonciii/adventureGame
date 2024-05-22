public  class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super("1",player,"Güvenli Ev");
    }


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());  // can yenileme

        // güvenli ev kontrolü
        if(this.getPlayer().getAward().isFinish()) {
            System.out.println("OYUNU KAZANDINIZ !");
            return false;
        }
        return true;
    }

}
