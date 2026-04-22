package bt.bai3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prescription")
public class PrescriptionDetail {
    @Id
    private Long id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;
}