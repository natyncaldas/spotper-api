package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.Composition;

@Repository
public interface CompositionRepository extends JpaRepository<Composition, Long>{

}
