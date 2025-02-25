package Cogip.project_cogip.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Companies> companies;

    private Date created_at;

    private Date updated_at;

}
