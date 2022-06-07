package com.agobikk.cookeatenjoy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
import org.junit.Assert.*
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

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = Repository(remoteRepository, localRepository)
    }
//    InstantTaskExecutorRule() - >  Правило тестирования JUnit, которое меняет фоновый исполнитель,
//    используемый компонентами архитектуры, на другой исполнитель, выполняющий каждую задачу
//    синхронно. Это правило можно использовать для тестов на стороне хоста, в которых используются
//    компоненты архитектуры.

    //    TestCoroutineRule() наследуется от TestWatcher
    //    TestWatcher — это базовый класс для правил, которые учитывают действие тестирования,
    //    не изменяя его. Например, этот класс будет вести журнал каждого
    //    пройденного и не пройденного теста.


    private val extendedIngredient = listOf(
        ExtendedIngredientEntity(
            1, 1.0, "consistency", "image", "name", "original", "unit"
        )
    )
    private val foodInformation = listOf(
        FoodInformationEntity(
            1, "image", "instructions", "title", "sourceName", extendedIngredient
        )
    )

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = Repository(remoteRepository, localRepository)
    }

    private val remote = remoteRepository
    private val local = localRepository

    @Test
    fun testGetFoodInformation() = runBlocking {
        val id: Long = 1
        val response = Mockito.mock(Response::class.java) as Response<FoodInformation>
        Mockito.`when`(remoteRepository.getFoodInformation(id)).thenReturn(response)

    }

    @Test
    fun myRepositoryTest() = runBlocking {
        val fakeSource: Flow<List<FoodInformationEntity>> = flow { emit(foodInformation) }

        `when`(repository.getFoodInfo(1)).thenReturn(fakeSource)
        assertEquals(repository.getFoodInfo(1), fakeSource)

    }

    @Test //Проверим пустой ответ сервера
    fun remoteRepository_ResponseIsEmpty() = runBlocking {
        val id: Long = 1
        val response = Mockito.mock(Response::class.java) as Response<FoodInformation?>
        Mockito.`when`(response.body()).thenReturn(null)
            repository.remote.getFoodInformation(id).body()
        assertNull(response.body())
    }
}






