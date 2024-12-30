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
@Table(name = "t_compte")
public class Compte implements Serializable /* obligatoire selon la spec JEE */ {
    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Integer rib;

    @Column(name = "client")
    private String nomClient;

    private float solde;

    public Compte(String nomClient, float solde) {
        super();
        this.nomClient = nomClient;
        this.solde = solde;
    }


    /*
     * @Transient // n'ajoute rien à la base --> c'est un champ calculé
     * private int salma;
     *
     * private int walha;
     */
}
