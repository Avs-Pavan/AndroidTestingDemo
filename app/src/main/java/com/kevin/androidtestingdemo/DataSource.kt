package com.kevin.androidtestingdemo

class DataSource(private val process: Process) {
    fun getData(): Int {
        return process.processOne()
    }
}