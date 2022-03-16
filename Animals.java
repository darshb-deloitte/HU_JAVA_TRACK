public class Animals {
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}


class Main {
    public static void main(String[] args) {
        Animals tiger = new Animals();
        Animals dogs = new Animals();
        Animals cat = new Animals();
        tiger.setName("Roars");
        dogs.setName("Barks");
        cat.setName("MeowMeow");
        System.out.println(tiger.getName());
        System.out.println(dogs.getName());
        System.out.println(cat.getName());
    }
}
