package AttendanceManage.AttendanceManage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AttendanceManage.AttendanceManage.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}

