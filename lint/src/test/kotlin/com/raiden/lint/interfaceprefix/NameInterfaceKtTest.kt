package com.raiden.lint.interfaceprefix

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class NameInterfaceKtTest {

    @Test
    fun `Should return false if String contains I prefix`() {
        val nameInterface = "IRepository"

        val isCorrectInterfaceName = nameInterface.isCorrectInterfaceName()

        assertFalse(isCorrectInterfaceName)
    }

    @Test
    fun `Should return true if String doesn't contain I prefix`() {
        val nameInterface = "Repository"

        val isCorrectInterfaceName = nameInterface.isCorrectInterfaceName()

        assertTrue(isCorrectInterfaceName)
    }

    @Test
    fun `Should return true if String starts with I but without prefix`() {
        val nameInterface = "IconRepository"

        val isCorrectInterfaceName = nameInterface.isCorrectInterfaceName()

        assertTrue(isCorrectInterfaceName)
    }

    @Test
    fun `Should return false if String starts with double I`() {
        val nameInterface = "IIconRepository"

        val isCorrectInterfaceName = nameInterface.isCorrectInterfaceName()

        assertFalse(isCorrectInterfaceName)
    }
}