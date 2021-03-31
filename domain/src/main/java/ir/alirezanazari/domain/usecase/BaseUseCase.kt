package ir.alirezanazari.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

// Written by Alireza Nazari, <@ali_rezaNazari> <a.alirezaNazari@gmail.com>.

abstract class BaseUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /**
     *  Executes the use case asynchronously and returns a [Result].
     */
    suspend operator fun invoke(parameters: P): R {
        return withContext(coroutineDispatcher) {
            execute(parameters)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}
