package com.example.logger.api

interface Logger {

    fun setUserId(id: String)

    /** Log a verbose exception and a message with optional format args.  */
    fun v(throwable: Throwable? = null, message: String? = null, vararg args: Any?)

    /** Log a debug exception and a message with optional format args.  */
    fun d(throwable: Throwable? = null, message: String? = null, vararg args: Any?)

    /** Log an info exception and a message with optional format args.  */
    fun i(throwable: Throwable? = null, message: String? = null, vararg args: Any?)

    /** Log a warning exception and a message with optional format args.  */
    fun w(throwable: Throwable? = null, message: String? = null, vararg args: Any?)

    /** Log an error exception and a message with optional format args.  */
    fun e(throwable: Throwable? = null, message: String? = null, vararg args: Any?)

    /** Log an assert exception and a message with optional format args.  */
    fun wtf(throwable: Throwable? = null, message: String? = null, vararg args: Any?)
}
