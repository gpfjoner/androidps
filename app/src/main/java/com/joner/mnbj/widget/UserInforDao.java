package com.joner.mnbj.widget;

import org.greenrobot.greendao.annotation.Id;

/**
 * Created by gpfei on 2018/9/28.
 * 用户信息表
 */

public class UserInforDao {
    @Id(autoincrement = true)
    private Long id;
    private String name;//账号
    private String pwd;//密码
    private int totalMoney;//总金额
    private int money_type;//存还是取 0 是存  1 是取
    private long money;//钱
    private String input_time;//创建时间 格式xxxx-xx-xx日 xx-xx-xx秒
    private int type;//类型 1.2.3.4.5.6
    private int InOutType; //类型0  是存  1 是取
}
