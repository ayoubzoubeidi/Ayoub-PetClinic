package maz.spring.maz.petclinic.bootstrap;

import maz.spring.maz.petclinic.model.Owner;
import maz.spring.maz.petclinic.model.Vet;
import maz.spring.maz.petclinic.services.OwnerService;
import maz.spring.maz.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Ayoub");
        owner1.setLastName("Zoubeidi");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mohssen");
        owner2.setLastName("Azla");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Maza");
        vet1.setLastName("ZouZou");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("LouLou");
        vet2.setLastName("ZIAZ");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");



    }
}
