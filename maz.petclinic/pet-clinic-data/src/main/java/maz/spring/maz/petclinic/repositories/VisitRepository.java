package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
