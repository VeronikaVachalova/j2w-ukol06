package cz.czechitas.java2webapps.ukol6.repository;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    // Repository pro tabulku {@code vizitka}.

public interface VizitkaRepository extends CrudRepository
            <Vizitka, Integer> {

}
