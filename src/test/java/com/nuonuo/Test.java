package com.nuonuo;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2019/12/20 17:03:19.
 */
public class Test {

    //青浦区
    @org.junit.jupiter.api.Test
    public void qingpuqu() {
        List<String> list1 = Arrays.asList("青浦重固", "青浦盈浦", "青浦练塘", "青浦金泽", "青浦夏阳", "青浦赵巷", "青浦朱家角", "青浦赵屯", "青浦华新", "青浦沈巷", "青浦蒸淀", "青浦商榻");
        String sql1 = "insert into ucenter_dept_3 values('%s',%d,'%s','FF80808162A5830022003','C59C15FD94EA477E84397D7C2D8C4584','%s#C59C15FD94EA477E84397D7C2D8C4584#7DA193F101584165BBFAA36721D25C39#5751D60E0F3C4BCC9A26A790DC4361C6#-1','2019-12-20 16:57:04','3F0286A5D22B40D2A2FA8AEA7599BE19',null,null)";
    
        for (int i = 0; i < list1.size(); i++) {
            String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
            System.out.println(String.format(sql1,uuid,i,list1.get(i),uuid));
        }
    
    }
    
    //奉贤区
    @org.junit.jupiter.api.Test
    public void fengxianqu() {
    
        List<String> list2 = Arrays.asList("奉贤奉城", "奉贤南桥", "奉贤西渡", "奉贤奉浦", "奉贤青村", "奉贤平安", "奉贤柘林", "奉贤8", "奉贤9", "奉贤10", "奉贤11", "奉贤12", "奉贤13", "奉贤14", "奉贤15", "奉贤16", "奉贤17", "奉贤18", "奉贤19", "奉贤20", "奉贤21", "奉贤22", "奉贤23", "奉贤24", "奉贤25");
        String sql2 = "insert into ucenter_dept_3 values('%s',%d,'%s','FF80808162A5830022003','0825C71EF4E74D2F888863ADFCA76F75','%s#0825C71EF4E74D2F888863ADFCA76F75#7DA193F101584165BBFAA36721D25C39#5751D60E0F3C4BCC9A26A790DC4361C6#-1','2019-12-20 16:57:04','3F0286A5D22B40D2A2FA8AEA7599BE19',null,null)";
    
        for (int i = 0; i < list2.size(); i++) {
            String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
            System.out.println(String.format(sql2,uuid,i,list2.get(i),uuid));
        }
    
    }
}
