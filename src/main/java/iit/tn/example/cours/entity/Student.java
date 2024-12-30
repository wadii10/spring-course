package iit.tn.example.cours.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor /* obligatoire selon la spec JEE */
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity // --> mapping avec la BD
@Table(name = "t_student")
public class Student implements Serializable /* obligatoire selon la spec JEE */ {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer id;

    private String name;

    public Student(String name) {
        super();
        this.name = name;
    }


    /*
     * @Transient // n'ajoute rien à la base --> c'est un champ calculé
     * private int salma;
     *
     * private int walha;
     */
}
