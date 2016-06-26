/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;


@Component
public class BeanFactory implements BeanFactoryAware {

    private static org.springframework.beans.factory.BeanFactory factory;

    @Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }

    public static Object getBean(String name) {
        return factory.getBean(name);
    }
}
