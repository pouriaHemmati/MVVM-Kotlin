package com.national.testhilt.utils
/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class SingleEvent<out T>(private val content: T) {
 var haseBeenHandled = false
    private set

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled() : T? {
        return if(haseBeenHandled){
            null
        } else {
            haseBeenHandled = true
            content
        }
    }
    /**
    * Returns the content, even if it's already been handled.
    */
    fun peekContent(): T = content

}