package com.dhx.framework.ioc.model.circle;

/**
 * @author adorabled4
 * @className B
 * @date : 2023/09/07/ 14:57
 **/
//@Data // 这里注意不能使用@Data , 否则会发生栈溢出 https://blog.csdn.net/liubenlong007/article/details/111993916
public class BeanB {

    BeanA beanA;

    String code;
    public void showA(){
        System.out.println(beanA + "code : " + code);
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
