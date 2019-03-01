package entities;


public class Show {
    private Date startTime;
    private String title;
    private List<Act> acts;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(List<Act> acts) {
        this.acts = acts;
    }

    public Show() {
    }

    public Show(Date startTime, String title, List<Act> acts) {
        this.startTime = startTime;
        this.title = title;
        this.acts = acts;
    }
}
