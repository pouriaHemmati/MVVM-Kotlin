package com.national.testhilt.utils

import java.util.regex.Pattern

object RegexUtils {

    private val EMAIL_ADDRESS: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValidEmail(email : String) : Boolean{
        return EMAIL_ADDRESS.matcher(email).matches()
    }

    private val MOBILE : Pattern = Pattern.compile(
        "(0|\\+98)?([ ]|,|-|[()]){0,2}9[1|2|3|4]([ ]|,|-|[()]){0,2}(?:[0-9]([ ]|,|-|[()]){0,2}){8}"
    )

    fun isValidMobile(mobile : String) : Boolean{
        return MOBILE.matcher(mobile).matches()
    }

    fun isValidNationalCode(nationalCode : String) : Boolean{
        when {
            nationalCode.trim() == "" -> {
                return false
            }
            nationalCode.length != 10 -> {
                return false
            }
            else -> {
                var sum = 0
                for (i in 0..9){
                    sum += nationalCode[i].toInt() * (10-i)
                }

                var lastDigit : Int
                var divideRemaining = sum % 11

                lastDigit = if (divideRemaining < 2){
                    divideRemaining
                } else {
                    11 - (divideRemaining)
                }

                return  nationalCode[9].toInt() == lastDigit
            }
        }
    }
}


