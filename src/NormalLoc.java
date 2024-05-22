public abstract class NormalLoc  extends Location{
    public NormalLoc(String idLocation ,Player player, String name) {
        super(idLocation,player,name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
