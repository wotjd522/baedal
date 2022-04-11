package itc.hoseo.baedal.repo.imp;

import itc.hoseo.baedal.domain.ClientUser;
import itc.hoseo.baedal.repo.ClientUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientUserRepositoryImp implements ClientUserRepository {
    @Autowired
    JdbcTemplate template;


    @Override
    public ClientUser findById(String id) {
        return template.queryForObject("select * from client_user where id = ?",
                new BeanPropertyRowMapper<>(ClientUser.class), id);
    }

    @Override
    public void insert(ClientUser c) {
        template.update("insert into client_user(id, password, name, address, telno, userActivate)" +
                "values(?, ?, ?, ?, ?, 'Y')", c.getId(), c.getPassword(), c.getName(),c.getAddress(), c.getTelno());
    }

    @Override
    public void update(ClientUser c) {
        template.update("update member set password = ?, name = ?, address = , telno = ?, email = ? where id = ?",
                c.getPassword(), c.getName(), c.getTelno(), c.getEmail(), c.getId());
    }
}
