package bt.bai2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    private Long id;
    private String name;
    private String unit;
}
