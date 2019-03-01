package entities;

import java.util.List;
public class Act {
    private List<ActMember> actMembers;

    public List<ActMember> getActMembers() {
        return actMembers;
    }

    public void setActMembers(List<ActMember> actMembers) {
        this.actMembers = actMembers;
    }

    public Act() {
    }

    public Act(List<ActMember> actMembers) {
        this.actMembers = actMembers;
    }
}
