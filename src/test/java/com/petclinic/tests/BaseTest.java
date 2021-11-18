package com.petclinic.tests;

import com.petclinic.tests.tags.RegressionTest;
import org.junit.jupiter.api.parallel.Execution;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@RegressionTest
public class BaseTest {
}
