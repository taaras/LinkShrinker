package com.my.smlr.service

interface KeyConverterService {
    fun idToKey(id: Long): String
    fun  keyToId(key: String): Long
}