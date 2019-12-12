package exception.models;

public class Faculty{
    public enum NameFaculty {
        MATHEMATICS, PHYSICS, BIOLOGY, GEOLOGY
    }
    private NameFaculty nameFaculty;

    public Faculty() {
    }

    public Faculty(NameFaculty nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public NameFaculty getNameFaculty() {
        return nameFaculty;
    }
}
