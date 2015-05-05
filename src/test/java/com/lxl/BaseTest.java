package com.lxl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiaolu on 15/5/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:*.xml","classpath:*.xml"})
public class BaseTest {
}
