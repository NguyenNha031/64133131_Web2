package thigk.ntu64133131.nguyenthanhnha_baithigk.model;

public class Student {
    private int id;
    private String name;
    private String groupId;

    // Constructor
    public Student(int id, String name, String groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }
}
