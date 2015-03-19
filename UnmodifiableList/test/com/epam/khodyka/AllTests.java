package com.epam.khodyka;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.epam.khodyka.part1.ProtectedIteratorListTest;
import com.epam.khodyka.part2.UnmodifiableListTest;

@RunWith(Suite.class)
@SuiteClasses({ UnmodifiableListTest.class, ProtectedIteratorListTest.class })
public class AllTests {

}
