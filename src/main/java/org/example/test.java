package org.example;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.Customer;

import java.io.Reader;
import java.util.HashMap;

public class test {
    private static SqlSessionFactory sqlSessionFactory = null;

    // 初始化SqlSessionFactory对象
    static {
        try {
            // 使用MyBatis提供的Resources类加载MyBatis的配置文件
            Reader reader =
                    Resources.getResourceAsReader("mybatis-config.xml");
            // 构建SqlSessionFactory工厂
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取SqlSession对象的静态方法
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }
    public static HashMap test(String customer_name) {
        SqlSession sqlSession = getSession();
        Customer customer = sqlSession.selectOne("CustomerMapper.getCustomerByName",customer_name);
        sqlSession.close();
        HashMap map = new HashMap<>();
        map.put("customer_id",customer.getCustomer_id());
        map.put("customer_name",customer.getCustomer_name());
        map.put("customer_address",customer.getCustomer_address());
        map.put("customer_balance",customer.getCustomer_balance());
        map.put("orderList",customer.getOrderList());
        return map;
    }
}