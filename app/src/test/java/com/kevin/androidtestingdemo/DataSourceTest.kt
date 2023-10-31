package com.kevin.androidtestingdemo

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test


class DataSourceTest {

    @Test
    fun `test get data`() {

        val process = mockk<Process>()
        val dataSource = DataSource(process)

        every { process.processOne() } returns 10

        assertEquals(dataSource.getData(),10)

        verify(exactly = 1) { process.processOne() }
    }
}