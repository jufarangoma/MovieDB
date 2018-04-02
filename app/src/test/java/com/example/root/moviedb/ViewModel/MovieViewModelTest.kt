package com.example.root.moviedb.ViewModel

import android.content.Context
import android.test.mock.MockApplication
import android.support.test.InstrumentationRegistry.getContext
import com.example.root.moviedb.Models.Movie
import com.example.root.moviedb.Utils.Constants
import com.example.root.moviedb.Views.Activity.MovieActivity
import io.reactivex.Observable
import io.realm.Realm
import org.junit.After
import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import java.util.*

/**
 * Created by Juan Arango on 4/1/18.
 */
class MovieViewModelTest {
    @Mock
    val movieViewMock: MovieActivity = mock(MovieActivity::class.java)
    var movieViewModel: MovieViewModel?=null
    val querie: HashMap<String, String> = HashMap()
    @Mock var context: Context?=MovieActivity()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Realm.init(getContext())
        querie.put(Constants.Key.API_KEY, Constants.Value.API_KEY)
        movieViewModel = MovieViewModel(getContext(), Constants.Url.DISCOVER,querie)
    }

    @Test
    fun testMovieApi() {
        doReturn(Observable.just(Movie::class.java))
                .`when`(movieViewModel)!!
                .fetchMoviesList(Constants.Url.DISCOVER,querie)

    }

    @After
    fun tearDown() {
        movieViewModel
    }
}