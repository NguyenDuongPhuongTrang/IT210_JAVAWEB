package bt.bai4.service;

import bt.bai4.model.Medicine;
import bt.bai4.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> findMedicineBeforeExpiryDate() {
        return medicineRepository.findMedineBeforeExpiryDate();
    }
}
