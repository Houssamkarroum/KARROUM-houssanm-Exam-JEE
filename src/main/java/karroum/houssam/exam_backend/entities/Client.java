package karroum.houssam.exam_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Credit> credits;
}