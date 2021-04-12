package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spotper.api.model.ComposerTrack;

import java.util.List;

@Repository
public interface ComposerTrackRepository extends JpaRepository<ComposerTrack, Long>{
    @Query("select c from ComposerTrack c where c.composer.id=:cId and c.track.id=:tId")
    List<ComposerTrack> findByComposerAndTrackId(@Param("cId") long cId, @Param("tId") long tId);
}
