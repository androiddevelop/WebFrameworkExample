package me.codeboy.examples;

import me.codeboy.common.base.log.CBPrint;
import me.codeboy.examples.bean.CBUser;
import me.codeboy.common.framework.hibernate.core.CBHibernateTask;
import org.hibernate.Session;

/**
 * database operation example
 * Created by YD on 3/9/16.
 */
public class CBDbOperationExample {

    public static void main(String[] args) {
        CBUser user = new CBHibernateTask<CBUser>() {
            @Override
            public CBUser doTask(Session session) {
                long userId = 1L;
                return (CBUser) session.get(CBUser.class, userId);
            }
        }.execute();

        if (null != user) {
            CBPrint.print(user.getId());
            CBPrint.print(user.getName());
        }
    }
}
