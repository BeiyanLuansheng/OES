package org.oes.biz.component;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.oes.biz.entity.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SessionClient {

    @Resource
    private SessionDAO sessionDAO;

    /**
     * 强制下线
     *
     * @param sessionId sessionId
     */
    public void forceLogout(String sessionId) {
        Session session = sessionDAO.readSession(sessionId);
        session.setTimeout(0);
        session.stop();
        sessionDAO.delete(session);
    }

    /**
     * 通过用户ID获取Principal集合
     *
     * @param userId 用户ID
     * @return List<SimplePrincipalCollection>
     */
    public List<SimplePrincipalCollection> getPrincipals(@NonNull Long userId) {
        List<SimplePrincipalCollection> collections = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        for (Session session : sessions) {
            SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection) session
                    .getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (simplePrincipalCollection != null) {
                User user = (User) simplePrincipalCollection.getPrimaryPrincipal();
                if (userId.equals(user.getUserId())) {
                    collections.add(simplePrincipalCollection);
                }
            }
        }
        return collections;
    }
}
