package oncall.domain;

public class Schedule {
    private int month;
    private int date;
    private DayCategory dayCategory;
    private String worker;

    private Schedule(int month, int date, DayCategory dayCategory, String worker) {
        this.month = month;
        this.date = date;
        this.dayCategory = dayCategory;
        this.worker = worker;
    }

    public static Schedule of(int month, int date, DayCategory dayCategory, String worker){
        return new Schedule(month, date, dayCategory, worker);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public DayCategory getDayCategory() {
        return dayCategory;
    }

    public String getWorker() {
        return worker;
    }
}
