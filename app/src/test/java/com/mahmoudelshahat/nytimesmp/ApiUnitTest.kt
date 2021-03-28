package com.mahmoudelshahat.nytimesmp

import com.mahmoudelshahat.nytimesmp.data.NyTimesApiService
import com.mahmoudelshahat.nytimesmp.data.response.NyTimesResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ApiUnitTest {
    @Test
    fun addition_isCorrect() {
        Assert.assertTrue(false)
    }
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getAllPostsTest() {
        val apiService = NyTimesApiService()
        runBlocking {
            val response = apiService.getNyTimesMostPopular().await()
            Assert.assertEquals("OK",response.status)
        }
    }



}