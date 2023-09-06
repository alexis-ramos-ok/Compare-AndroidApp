package com.example.compareapp
import org.junit.Test
import org.junit.Assert.assertEquals

class MainViewModelTest {
    @Test
    fun onCompareClick_sameText_setsResultToEqual() {
        // Crea una instancia del ViewModel
        val viewModel = MainViewModel()

        // Establece las propiedades del ViewModel
        viewModel.text1.value = "texto"
        viewModel.text2.value = "texto"

        // Invoca el método a probar
        viewModel.onCompareClick()

        // Verifica el resultado
        assertEquals("Las cadenas son iguales", viewModel.result.value)
    }

    @Test
    fun onCompareClick_differentText_setsResultToDifferent() {
        // Crea una instancia del ViewModel
        val viewModel = MainViewModel()

        // Establece las propiedades del ViewModel
        viewModel.text1.value = "texto1"
        viewModel.text2.value = "texto2"

        // Invoca el método a probar
        viewModel.onCompareClick()

        // Verifica el resultado
        assertEquals("Las cadenas son diferentes", viewModel.result.value)
    }
}
