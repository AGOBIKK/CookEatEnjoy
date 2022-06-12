package com.agobikk.cookeatenjoy

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.agobikk.cookeatenjoy.data.repository.RepositoryImpl
import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
import com.agobikk.cookeatenjoy.models.FoodInformation
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

////import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.agobikk.cookeatenjoy.data.repository.Repository
//import com.agobikk.cookeatenjoy.data.local.entities.ExtendedIngredientEntity
//import com.agobikk.cookeatenjoy.data.local.entities.FoodInformationEntity
//import com.agobikk.cookeatenjoy.data.remote.RemoteRepository
//import com.agobikk.cookeatenjoy.data.repository.LocalRepository
//import com.agobikk.cookeatenjoy.models.FoodInformation
//
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.runBlocking
//import org.junit.Assert.assertEquals
//import org.junit.Assert.assertNull
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import retrofit2.Response
//
//@ExperimentalCoroutinesApi
class RepositoryImplTest {
    @BeforeEach
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }

        })
    }
    @AfterEach
    fun afterEach() {
        Mockito.reset(remoteRepository)
        Mockito.reset(localRepository)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }


    private val extendedIngredient = listOf(
        ExtendedIngredientEntity(
            1,
            1.0,
            "consistency",
            "image",
            "name",
            "original",
            "unit"
        )
    )
    private val foodInformationEntity =
        FoodInformationEntity(
            1,
            "image",
            "instructions",
            "title",
            "sourceName",
            extendedIngredientEntity = extendedIngredient
        )
    private val remoteRepository = mock<RemoteRepository>()
    private val localRepository = mock<LocalRepository>()

    @Test
    fun `should return FoodInformationEntity`() {


        val repository = RepositoryImpl(remote = remoteRepository, local = localRepository)
        runBlocking {
            Mockito.`when`(
                remoteRepository.getFoodInformation(id=Mockito.anyLong()).body()
            ).thenReturn(
            FoodInformation(
                id = 0,
                image = "image",
                instructions = "instructions",
                title = "title",
                sourceName = "sourceName",
                extendedIngredient = emptyList())
        )

            Mockito.`when`(repository.getFoodInfo(id = Mockito.anyLong()))
                .thenReturn(foodInformationEntity)
        }
        val actual = runBlocking { repository.getFoodInfo(id = Mockito.anyLong()) }
        val expected = foodInformationEntity
        Assertions.assertEquals(expected, actual)
    }
//
//    private lateinit var repository: Repository
//
//    @Mock
//    private lateinit var remoteRepository: RemoteRepository
//
//    @Mock
//    private lateinit var localRepository: LocalRepository
//
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.openMocks(this)
//        repository = Repository(remoteRepository, localRepository)
//    }
//
//
//    private val extendedIngredient = listOf(
//        ExtendedIngredientEntity(
//            1, 1.0, "consistency", "image", "name", "original", "unit"
//        )
//    )
//    private val foodInformationEntity = listOf(
//        FoodInformationEntity(
//            1, "image", "instructions", "title", "sourceName", extendedIngredient
//        )
//    )
//
//    @Test
//    fun testGetFoodInformation() {
//        runBlocking {
//            val id: Long = 1
//            val response = Mockito.mock(Response::class.java) as Response<FoodInformation>
//            Mockito.`when`(remoteRepository.getFoodInformation(id)).thenReturn(response)
//
//        }
//    }
//
//
//    @Test //Проверим пустой ответ сервера
//    fun remoteRepository_ResponseIsEmpty() = runBlocking {
//        val id: Long = 1
//        val response = Mockito.mock(Response::class.java) as Response<FoodInformation?>
//        Mockito.`when`(response.body()).thenReturn(null)
//
//        assertNull(response.body())
//    }
//
//    @Test
//    fun testLocalRepo()= runBlocking {
//
//        Mockito.`when`(localRepository.getFoodInfo()).thenReturn(foodInformationEntity)
//        assertEquals(localRepository.getFoodInfo(),foodInformationEntity)
//    }
}






