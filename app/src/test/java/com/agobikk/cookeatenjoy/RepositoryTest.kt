package com.agobikk.cookeatenjoy

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.agobikk.cookeatenjoy.data.Repository
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
import com.agobikk.cookeatenjoy.data.repository.LocalRepository
import com.agobikk.cookeatenjoy.models.FoodInformation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
class RepositoryTest {

    private lateinit var repository: Repository

    @Mock
    private lateinit var remoteRepository: RemoteRepository

    @Mock
    private lateinit var localRepository: LocalRepository


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = Repository(remoteRepository, localRepository)
    }

    private val extendedIngredient = listOf(
        ExtendedIngredientEntity(
            1, 1.0, "consistency", "image", "name", "original", "unit"
        )
    )
    private val foodInformationEntity = listOf(
        FoodInformationEntity(
            1, "image", "instructions", "title", "sourceName", extendedIngredient
        )
    )

    @Test
    fun testGetFoodInformation() {
        runBlocking {
            val id: Long = 1
            val response = Mockito.mock(Response::class.java) as Response<FoodInformation>
            Mockito.`when`(remoteRepository.getFoodInformation(id)).thenReturn(response)

        }
    }


    @Test //Проверим пустой ответ сервера
    fun remoteRepository_ResponseIsEmpty() = runBlocking {
        val id: Long = 1
        val response = Mockito.mock(Response::class.java) as Response<FoodInformation?>
        Mockito.`when`(response.body()).thenReturn(null)

        assertNull(response.body())
    }

    @Test
    fun testLocalRepo()= runBlocking {

        Mockito.`when`(localRepository.getFoodInfo()).thenReturn(foodInformationEntity)
        assertEquals(localRepository.getFoodInfo(),foodInformationEntity)
    }

    @Test
    fun test() {
        assertEquals(1, 1)
    }

}






