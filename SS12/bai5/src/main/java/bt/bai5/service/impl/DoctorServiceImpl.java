package bt.bai5.service.impl;

import bt.bai5.model.Doctor;
import bt.bai5.repository.DoctorRepository;
import bt.bai5.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public List<Doctor> searchByPhone(String phone) {
        return repository.findByPhone(phone);
    }
}
