package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
