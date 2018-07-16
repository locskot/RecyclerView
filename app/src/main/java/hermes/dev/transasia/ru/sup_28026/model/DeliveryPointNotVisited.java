package hermes.dev.transasia.ru.sup_28026.model;

public class DeliveryPointNotVisited implements DevPoint {

    private String name;
    private long id;

    public DeliveryPointNotVisited(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
