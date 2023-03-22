package kodlama.io.rentacar.entities.concretes;

public class Brand {
    //Lombok
    private int id;
    private String name;

    public Brand() { //No args constructor

    }

    public Brand(int id, String name) { //All args constructor
        this.id = id;
        this.name = name;
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
}
