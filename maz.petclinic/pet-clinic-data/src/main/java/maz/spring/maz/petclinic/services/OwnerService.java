package maz.spring.maz.petclinic.services;

import maz.spring.maz.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
