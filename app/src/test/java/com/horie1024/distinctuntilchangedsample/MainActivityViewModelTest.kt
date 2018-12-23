package com.horie1024.distinctuntilchangedsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainActivityViewModel

    @Before
    fun setUp() {
        viewModel = MainActivityViewModel()
    }

    @Test
    fun distinctUntilChangedの挙動確認() {

        val mock = mockk<Observer<Int>>(relaxed = true)

        viewModel.value.observeForever(mock)
        viewModel.setValue(1)
        viewModel.setValue(1)

        verify(exactly = 1) {
            mock.onChanged(1)
        }

        viewModel.setValue(2)
        viewModel.setValue(1)

        verify(exactly = 2) {
            mock.onChanged(1)
        }
    }
}