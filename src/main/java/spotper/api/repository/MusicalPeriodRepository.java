package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.MusicalPeriod;

@Repository
public interface MusicalPeriodRepository extends JpaRepository<MusicalPeriod, Long>{

}