package stajokulu.mlipmp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}