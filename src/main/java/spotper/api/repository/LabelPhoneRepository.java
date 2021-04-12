package spotper.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spotper.api.model.LabelPhone;

@Repository
public interface LabelPhoneRepository extends JpaRepository<LabelPhone, Long>{

}
