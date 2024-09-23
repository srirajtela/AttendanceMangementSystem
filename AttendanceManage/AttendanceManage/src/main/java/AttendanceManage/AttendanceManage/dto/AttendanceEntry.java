package AttendanceManage.AttendanceManage.dto;

public class AttendanceEntry {

    private Long id; // or long, if primitive is preferred
    private boolean present=true;
    private String name;

    // Default no-argument constructor
    public AttendanceEntry() {
    }

    // Parameterized constructor (if needed)
    public AttendanceEntry(Long id, boolean present, String name) {
        this.id = id;
        this.present = present;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "AttendanceEntry [id=" + id + ", present=" + present + ", name=" + name + "]";
	}
    
    
    
}
