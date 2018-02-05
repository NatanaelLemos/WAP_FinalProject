package domain.data.repositories;

import domain.data.IRepository;
import domain.data.RepositoryBase;
import domain.entities.*;

public class AddressRepository extends RepositoryBase<Address> implements IRepository<Address> {
    public AddressRepository() {
        super(Address.class);
    }
}
