package spotper.api.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spotper.api.model.Track;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long>{
    @Query("select t from Track t where t.album.id=:aId")
    List<Track> findTrackByAlbumId(@Param("aId") long aId, Sort sort);

    @Query("select t from Track t inner join TrackPlaylist tp on t.id=tp.track.id where tp.playlist.id=:pId")
    List<Track> findTrackByPlaylistId(@Param("pId") long pId);
}
