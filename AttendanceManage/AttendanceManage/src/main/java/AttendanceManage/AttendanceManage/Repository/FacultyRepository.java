package AttendanceManage.AttendanceManage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AttendanceManage.AttendanceManage.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}