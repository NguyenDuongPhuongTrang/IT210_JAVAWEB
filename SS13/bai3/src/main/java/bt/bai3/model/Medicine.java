package bt.bai3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    private Long id;
    private String name;
    private String unit;
    @OneToMany(mappedBy = "medicine")
    List<PrescriptionDetail> details;
}