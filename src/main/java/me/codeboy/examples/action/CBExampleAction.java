package me.codeboy.examples.action;

import com.opensymphony.xwork2.ActionSupport;
import me.codeboy.examples.bean.CBUser;
import me.codeboy.framework.hibernate.core.CBHibernateTask;
import me.codeboy.framework.workflow.bean.CBCommonResult;
import me.codeboy.framework.workflow.core.CBCommonResultCode;
import me.codeboy.framework.workflow.core.CBResponseController;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * action example
 * Created by YD on 3/10/16.
 */
public class CBExampleAction extends ActionSupport {
    /**
     * standard operation or success operation
     *
     * @return null
     */
    public String operateSuccess() {
        CBResponseController.process(getTestUsers());
        return null;
    }

    /**
     * failed operation
     *
     * @return null
     */
    public String operateFailed() {
        CBResponseController.process(new CBCommonResult<>(CBCommonResultCode.FAILED, "operate failed"));
        return null;
    }

    /**
     * raw data operation, and not use the wrapper structure
     *
     * @return null
     */
    public String operateRawData() {
        CBResponseController.processRaw(getTestUsers());
        return null;
    }

    /**
     * standard operation with database
     *
     * @return null
     */
    public String operateDatabase() {
        CBResponseController.process(new CBHibernateTask<CBUser>() {
            @Override
            public CBUser doTask(Session session) {
                long userId = 1L;
                return (CBUser) session.get(CBUser.class, userId);
            }
        }.execute());
        return null;
    }


    /**
     * mock test users
     *
     * @return users
     */
    private List<CBUser> getTestUsers() {
        List<CBUser> users = new ArrayList<>();
        users.add(new CBUser(1L, "nick"));
        users.add(new CBUser(2L, "tom"));
        return users;
    }

}
