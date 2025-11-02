package PARCIALES.P2.P220242C.ej1;

import java.time.MonthDay;
import java.util.*;

public class IssueTracker {
    private Map<IssueType, SortedSet<Issue>> map = new EnumMap<>(IssueType.class);

    public Issue addIssue(String message, MonthDay date, IssueType type){
        Issue toReturn = new Issue(message, date, type);
        map.putIfAbsent(type, new TreeSet<>());
        map.get(type).add(toReturn);
        return toReturn;
    }

    public List<Issue> issues(){
        List<Issue> toReturn = new ArrayList<>();
        for(IssueType type : map.keySet()){
            toReturn.addAll(issues(type));
        }
        return toReturn;
    }

    public SortedSet<Issue> issues(IssueType type){
        return map.getOrDefault(type, new TreeSet<>());
    }

    public boolean removeIssue(Issue issue){
        return map.getOrDefault(issue.getType(), new TreeSet<>()).remove(issue);
    }

    private SortedSet<Issue> getNonEmpty(IssueType type) {
        SortedSet<Issue> toReturn = issues(type);
        if(toReturn.isEmpty()) {
            throw new IllegalArgumentException("No issues with type " + type);
        }
        return toReturn;
    }
    public Issue getOldestIssue(IssueType type) {
        return getNonEmpty(type).last();
    }
    public Issue getLatestIssue(IssueType type) {
        return getNonEmpty(type).first();
    }
}
