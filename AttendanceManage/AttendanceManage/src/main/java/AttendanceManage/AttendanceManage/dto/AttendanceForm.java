
package AttendanceManage.AttendanceManage.dto;

import java.util.ArrayList;
import java.util.List;

public class AttendanceForm {
    private List<AttendanceEntry> attendanceEntries;

    public AttendanceForm() {
        this.attendanceEntries = new ArrayList<>(); // Proper list initialization
    }

    public List<AttendanceEntry> getAttendanceEntries() {
        return attendanceEntries;
    }

    public void setAttendanceEntries(List<AttendanceEntry> attendanceEntries) {
        this.attendanceEntries = attendanceEntries;
    }

	@Override
	public String toString() {
		return "AttendanceForm [attendanceEntries=" + attendanceEntries + "]";
	}
    
    
    
}
