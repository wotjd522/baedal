package itc.hoseo.baedal.domain;

import itc.hoseo.baedal.repo.LoginLogRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginLog{
    private int seq;
    private String id;
    private String ip;
    private String loginStatus;
    private Date LoginDttm;
}
