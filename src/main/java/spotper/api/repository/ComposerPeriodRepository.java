package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spotper.api.model.ComposerPeriod;

import java.util.List;


@Repository
public interface ComposerPeriodRepository extends JpaRepository<ComposerPeriod, Long>{

    @Query("select c from ComposerPeriod c where c.composer.id=:cId and c.musicalPeriod.id=:pId")
    List<ComposerPeriod> findByPeriodOrComposerId(@Param("cId") long cId, @Param("pId") long pId);
}