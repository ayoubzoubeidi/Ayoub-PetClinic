package maz.spring.maz.petclinic.bootstrap;

import maz.spring.maz.petclinic.model.Owner;
import maz.spring.maz.petclinic.model.PetType;
import maz.spring.maz.petclinic.model.Vet;
import maz.spring.maz.petclinic.services.OwnerService;
import maz.spring.maz.petclinic.services.PetTypeService;
import maz.spring.maz.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Ayoub");
        owner1.setLastName("Zoubeidi");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mohssen");
        owner2.setLastName("Azla");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Maza");
        vet1.setLastName("ZouZou");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("LouLou");
        vet2.setLastName("ZIAZ");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
