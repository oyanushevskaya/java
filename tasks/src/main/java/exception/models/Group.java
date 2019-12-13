package exception.models;

public class Group extends Faculty {
    public enum GroupName {
        M1, M2, M3, M4, P1, P2, P3, P4, B1, B2, B3, B4, G1, G2, G3, G4
    }
    private GroupName groupName;

    public Group() {
        super();
    }

    public Group(FacultyName facultyName, GroupName groupName) {
        super(facultyName);
        this.groupName = groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public GroupName getGroupName() {
        return groupName;
    }
}
