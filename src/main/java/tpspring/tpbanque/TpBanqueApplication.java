package tpspring.tpbanque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import tpspring.tpbanque.REPOSITORIES.CompteRepository;
import tpspring.tpbanque.entities.Compte;
import tpspring.tpbanque.TypeCompte;

import java.util.Date;

@SpringBootApplication
@EntityScan(basePackages = "tpspring.tpbanque.entities")
public class TpBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGHNE));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
