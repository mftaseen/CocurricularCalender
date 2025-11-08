import java.util.Date;

public class Event {
    public String eventName;
    public String description;
    public Date startDate;
    public Date endDate;
    public String startTime;
    public String endTime;
    public Room location;
    public Club club;

    public Event(String eventName, String description, Date startDate, Date endDate, String startTime, String endTime, Room location, Club club) {
        this.eventName = eventName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.club = club;
    }
}
