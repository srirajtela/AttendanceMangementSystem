package AttendanceManage.AttendanceManage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AttendanceManage.AttendanceManage.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
