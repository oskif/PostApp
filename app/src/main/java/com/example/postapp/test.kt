package com.example.postapp2

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlin.random.Random

fun main() {
    emit()
        .concatMap {
            print(it)
        }
        .subscribeOn(Schedulers.computation())
        .subscribe(
            {
            },
            {
            },
            {
            }
        )

    readln()
}

private fun print(counter: Int) = Observable.create {
    for (i in 1..4) {
        Thread.sleep(Random.nextLong(100, 4000))
        println("Counter: $counter")
        it.onNext(Unit)
    }
    it.onComplete()
}.subscribeOn(Schedulers.newThread())

private fun emit() = Observable.create {
    var counter = 0
    while(true) {
        Thread.sleep(1000)
        println(counter)
        it.onNext(counter)
        counter++
    }
}