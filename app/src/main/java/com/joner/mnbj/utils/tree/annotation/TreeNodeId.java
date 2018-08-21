package com.joner.mnbj.utils.tree.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gpfei on 2018/8/21.
 *  注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//运行时可见
public @interface TreeNodeId {

}
