package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{

}