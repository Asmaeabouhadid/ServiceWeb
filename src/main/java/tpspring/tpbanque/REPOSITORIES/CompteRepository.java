package tpspring.tpbanque.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import tpspring.tpbanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
