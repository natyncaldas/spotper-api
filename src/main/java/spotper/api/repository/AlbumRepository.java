package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
