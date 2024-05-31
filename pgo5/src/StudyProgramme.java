public class StudyProgramme {
    private String name;
    private String description;
    private int semester;
    private int maxITNs;

    public StudyProgramme(String name, String description, int semester, int maxITNs) {
        this.name = name;
        this.description = description;
        this.semester = semester;
        this.maxITNs = maxITNs;
    }

    public int getSemester() {
        return semester;
    }

    public int getMaxITNs() {
        return maxITNs;
    }
}
