package ir.alirezanazari.data.net

import com.google.gson.Gson
import ir.alirezanazari.domain.entity.base.ErrorEntity
import ir.alirezanazari.domain.entity.base.ErrorResponse
import okio.BufferedSource
import retrofit2.HttpException
import java.io.ByteArrayOutputStream
import java.io.IOException

class ErrorHandlerImpl : ErrorHandler {

    override fun getError(throwable: Throwable): ErrorEntity {

        return when (throwable) {

            is IOException -> ErrorEntity.Network.apply {
                message = "No Network Access"
            }

            is HttpException -> convertHttpErrorBody(throwable)

            else -> ErrorEntity.Unknown(throwable.message ?: throwable.toString())

        }
    }

    private fun convertHttpErrorBody(throwable: HttpException): ErrorEntity {
        return try {
            val bufferedSource = throwable.response()?.errorBody()?.source()
            bufferedSource?.let {
                convertToErrorModel(it).let { errorResponse ->
                    errorResponse.error_message?.let { message ->
                        ErrorEntity.ApiError(
                            message,
                            throwable.response()?.code() ?: 500
                        )
                    } ?: showServerError()
                }
            } ?: showServerError()
        } catch (exception: Exception) {
            showServerError()
        }
    }

    @Throws(IOException::class)
    fun convertToErrorModel(input: BufferedSource): ErrorResponse {
        val result = ByteArrayOutputStream()
        val buffer = ByteArray(1024)
        var length: Int
        while (input.read(buffer).also { length = it } != -1) {
            result.write(buffer, 0, length)
        }
        return Gson().fromJson(result.toString("UTF-8"), ErrorResponse::class.java)
    }

    private fun showServerError(): ErrorEntity.ApiError {
        return ErrorEntity.ApiError(
            "Error in Server",
            500
        )
    }

}