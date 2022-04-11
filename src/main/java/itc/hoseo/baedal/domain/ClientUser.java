package itc.hoseo.baedal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser {

    private int seq;
    private String id;
    private String password;
    private String name;
    private String address;
    private String telno;
    private String email;
    private String userActivate;
}
