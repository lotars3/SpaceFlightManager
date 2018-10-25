package pl.szymonsmenda.AssignmenForCandidates.services;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.database.UserEntity;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionService{
    private boolean isLogin;
    private UserEntity userEntity;
}
