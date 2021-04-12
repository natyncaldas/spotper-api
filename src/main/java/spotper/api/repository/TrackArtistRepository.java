package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spotper.api.model.TrackArtist;

import java.util.List;

@Repository
public interface TrackArtistRepository extends JpaRepository<TrackArtist, Long>{
    @Query("select t from TrackArtist t where t.track.id=:tId and t.artist.id=:aId")
    List<TrackArtist> findByTrackAndArtistId(@Param("tId") long tId, @Param("aId") long aId);
}
