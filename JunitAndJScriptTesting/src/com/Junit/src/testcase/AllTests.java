package com.Junit.src.testcase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeleteMockTestcase.class, EditMockTestcase.class, LoginMockTestcase.class, MessageMockTestcase.class,
		SignupMockTestcase.class, UpdateMockTestcase.class, UserdataMockTestCase.class })
public class AllTests {

}
