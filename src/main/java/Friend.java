public class Friend {
    private final String name;
    public Friend(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public synchronized void bow(Friend bower){
        System.out.format("%s: %s has bowed me! %n", name, bower.getName());
        bower.bowBack(this);
    }
    public synchronized void bowBack(Friend bower){
        System.out.format("%s: %s has bowed back me! %n", name, bower.getName());
    }
    public static void main(String... args){
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");
        (new Thread(() -> alphonse.bow(gaston))).start();
        (new Thread(() -> gaston.bow(alphonse))).start();
    }
}
