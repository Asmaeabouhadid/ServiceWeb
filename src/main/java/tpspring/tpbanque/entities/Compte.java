package tpspring.tpbanque.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import tpspring.tpbanque.TypeCompte;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@XmlRootElement
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(EnumType.ORDINAL)
    private TypeCompte type;

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", type=" + type +
                '}';
    }

    // Constructeur complet avec tous les champs
    public Compte(Long id, double solde, Date dateCreation, TypeCompte type) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    // Constructeur alternatif sans date de création ni type (si nécessaire)
    public Compte(Long id, double solde) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = new Date();  // Initialise avec la date actuelle
        this.type = TypeCompte.COURANT;  // Définit un type par défaut
    }
}
