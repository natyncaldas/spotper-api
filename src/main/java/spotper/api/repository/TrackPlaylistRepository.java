package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spotper.api.model.TrackPlaylist;

import java.util.List;

@Repository
public interface TrackPlaylistRepository extends JpaRepository<TrackPlaylist, Long>{
    @Query("select t from TrackPlaylist t where t.track.id=:tId and t.playlist.id=:pId")
    List<TrackPlaylist> findByTrackAndPlaylistId(@Param("tId") long tId, @Param("pId") long pId);
}
