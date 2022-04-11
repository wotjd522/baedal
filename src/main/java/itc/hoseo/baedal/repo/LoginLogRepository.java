package itc.hoseo.baedal.repo;

import itc.hoseo.baedal.domain.LoginLog;

import java.util.List;

public interface LoginLogRepository {
    List<LoginLog> lastFiveLogs(String id);
    void save (LoginLog log);
}
