package com.gmail.shima.zeinalii.dev.weatherforecast.utilities

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description


/**
 * Created by Shima Zeinali
 * shima.zeinalii@gmail.com
 */
class MainCoroutineRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher() {

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}

fun MainCoroutineRule.runBlockingTest(block: suspend () -> Unit) =
    this.testDispatcher.runBlockingTest {
        block()
    }
