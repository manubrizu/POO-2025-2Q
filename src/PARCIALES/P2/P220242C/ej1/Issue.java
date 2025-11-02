package PARCIALES.P2.P220242C.ej1;

import java.time.MonthDay;

public class Issue implements Comparable<Issue>{
    private String message;
    private MonthDay date;
    private IssueType type;
    private boolean status;

    Issue(String message, MonthDay date, IssueType type){
        this.message = message;
        this.date = date;
        this.type = type;
        this.status = false;
    }

    public void resolve(){
        this.status = true;
    }

    public IssueType getType() {
        return type;
    }

    @Override
    public int compareTo(Issue i) {
        int cmp = i.date.compareTo(this.date);
        if(cmp == 0){
            cmp = this.message.compareTo(i.message);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "%s %s: %s (%s)".formatted(date, type, message, status ? "resolved" : "pending");
    }
}
