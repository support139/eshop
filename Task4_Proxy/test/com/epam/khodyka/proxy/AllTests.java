package com.epam.khodyka.proxy;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({MapProxyTest.class, UnmodifiableProxyTest.class})
public class AllTests {

}
