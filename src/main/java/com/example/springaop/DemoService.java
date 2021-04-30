package com.example.springaop;

import org.springframework.stereotype.Service;

/**
 * @author wgm
 * @since 2021/4/30
 */
@Service
public class DemoService {

    public void test(boolean throwException) {
        System.out.println("--------");
        if (throwException) {
            throw new RuntimeException();
        }
    }
}
