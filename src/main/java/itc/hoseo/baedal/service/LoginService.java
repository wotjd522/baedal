package itc.hoseo.baedal.service;

import itc.hoseo.baedal.domain.ClientUser;
import itc.hoseo.baedal.domain.LoginLog;
import itc.hoseo.baedal.repo.ClientUserRepository;
import itc.hoseo.baedal.repo.LoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    ClientUserRepository clientUserRepository;

    @Autowired
    LoginLogRepository loginLogRepository;

    public boolean login(String id, String pwd){
        //로그인 시도.
        boolean result = checkPassword(id, pwd);
        // 로그인 결과값 불러옴
        LoginLog loginLog = LoginLog.builder()
                .id(id)
                .loginStatus(result? "Y" : "N") //결과가 성공하면 Y 아니면 N
                .build();
        // 로그 저장함.
        loginLogRepository.save(loginLog);
        // 지난 5회의 결과값을 불러옴
        List<LoginLog> loginLogs = loginLogRepository.lastFiveLogs(id);
        if(loginLogs.size() < 5) return result;

        if(loginLogs.stream()
                .filter(l -> l.getLoginStatus().equals("N"))
                .count() == 5){
            ClientUser clientUser = clientUserRepository.findById(id);
            clientUser.setUserActivate("N");
            clientUserRepository.update(clientUser);
        } // 만약 로그인 시도가 5회이상 실패했을 경우 clientUser의 Activate를 비활성화 한다.
        return result;
    }

    public boolean checkPassword(String id, String pwd) { 
        // 패스워드 체크. id + pwd 후 DB 조회해서 있나 없나 조회한다.
        // 둘 다 동일할때 true 반환.
        // 그 외에는 false
        ClientUser client = clientUserRepository.findById(id);

        if (ObjectUtils.isEmpty(client) || StringUtils.hasText(client.getPassword()) == false)
            return false;
        return client.getPassword().equals(pwd);
    }


}
