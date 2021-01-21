package productweb.drinks;

public class DrinkDTO {

    Long id;
    String name;
    String price;
    boolean good;

    public DrinkDTO(Long id, String name, boolean good, String price) {
        this.id = id;
        this.name = name;
        this.good = good;
        this.price = price;
    }

    public DrinkDTO(String name, boolean good) {
        this.name = name;
        this.good = good;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public String getPrice(){return price;}

    public void  setPrice(String price){this.price = price;}

    /*public static int compareByName(DessertDTO a, DessertDTO b) {
        return a.name.compareTo(b.name);
    }*/

    @Override
    public String toString() {
        return "DrinkDTO{" +
                "id = '" + id + "', " +
                "name = '" + name + "', " +
                "good = " + good + "', " +
                "price = " + price +
                "}";
    }

}
