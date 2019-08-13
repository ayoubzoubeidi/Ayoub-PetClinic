package maz.spring.maz.petclinic.services;

import maz.spring.maz.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
