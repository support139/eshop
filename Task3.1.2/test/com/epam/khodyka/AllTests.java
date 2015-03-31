package com.epam.khodyka;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.epam.khodyka.part1.TestWrapperTest;
import com.epam.khodyka.part2.FilterTest;

@RunWith(Suite.class)
@SuiteClasses({TestWrapperTest.class, FilterTest.class})
public class AllTests {

}
