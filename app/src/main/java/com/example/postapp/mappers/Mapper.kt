package com.example.postapp.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}