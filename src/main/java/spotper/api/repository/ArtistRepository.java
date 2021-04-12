package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spotper.api.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
