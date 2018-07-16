package hermes.dev.transasia.ru.sup_28026.model;

public class Header implements DevPoint {

    public Header(String title, long id) {
        this.title = title;
        this.id = id;
    }

    private String title;
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
