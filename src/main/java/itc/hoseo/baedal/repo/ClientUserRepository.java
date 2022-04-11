package itc.hoseo.baedal.repo;

import itc.hoseo.baedal.domain.ClientUser;

public interface ClientUserRepository {

    ClientUser findById(String id);
    void insert(ClientUser c);
    void update(ClientUser c);

}
