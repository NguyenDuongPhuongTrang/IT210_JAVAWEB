package bt.bai5.service;

import bt.bai5.model.Doctor;
import java.util.List;

public interface DoctorService {
    List<Doctor> getAll();
    void addDoctor(Doctor doctor);
    List<Doctor> searchByPhone(String phone);
}
