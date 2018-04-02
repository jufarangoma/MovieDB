package com.example.root.moviedb.ViewModel

import io.realm.Realm
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.MockitoAnnotations

/**
 * Created by Juan Arango on 4/1/18.
 */
class MovieViewModelTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        //Realm.init(this)
    }

    @After
    fun tearDown() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Test
    fun fetchMoviesList() {
    }

    @Test
    fun updateMovieList() {
    }

    @Test
    fun onFailureRequest() {
    }

    @Test
    fun getMovieList() {
    }

    @Test
    fun reset() {
    }
}