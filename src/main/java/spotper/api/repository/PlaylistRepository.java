package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spotper.api.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
