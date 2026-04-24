package javaweb_session14.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;
    @Column(name = "class_name",length = 100,nullable = false,unique = true)
    private String className;
    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "classes", fetch = FetchType.EAGER)
    private List<Student> students;
}
