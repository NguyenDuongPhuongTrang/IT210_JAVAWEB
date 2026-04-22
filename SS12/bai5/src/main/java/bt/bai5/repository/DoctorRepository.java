package bt.bai5.repository;

import bt.bai5.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {

    private final List<Doctor> doctors = new ArrayList<>();

    public List<Doctor> findAll() {
        return doctors;
    }

    public void save(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> findByPhone(String phone) {
        return doctors.stream()
                .filter(d -> d.getPhone().equals(phone))
                .toList();
    }
}
