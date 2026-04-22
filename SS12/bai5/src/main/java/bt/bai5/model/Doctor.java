package bt.bai5.model;

import lombok.Data;

@Data
public class Doctor {
    private String id;
    private String name;
    private String specialization;
    private int experience;
    private String phone;
    private String address;
    private String startDate;
    private String avatar;
}
