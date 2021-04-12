package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.Composer;

@Repository
public interface ComposerRepository extends JpaRepository<Composer, Long>{

}