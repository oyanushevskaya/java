package exception.models;

public class Group extends Faculty {
    public enum NameGroup {
        M1, M2, M3, M4, P1, P2, P3, P4, B1, B2, B3, B4, G1, G2, G3, G4
    }
    private NameGroup nameGroup;

    public Group() {
        super();
    }

    public Group(NameFaculty nameFaculty, NameGroup nameGroup) {
        super(nameFaculty);
        this.nameGroup = nameGroup;
    }

    public NameGroup getNameGroup() {
        return nameGroup;
    }
}
