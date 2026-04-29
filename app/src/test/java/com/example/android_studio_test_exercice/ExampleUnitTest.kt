package com.example.android_studio_test_exercice.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.Observer
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    // toggleEstatSwitch

    @Test
    fun toggleEstatSwitch_canvia_de_true_a_false() {
        assertEquals(true, viewModel.estatSwitch.value)
        viewModel.toggleEstatSwitch()
        assertEquals(false, viewModel.estatSwitch.value)
    }

    @Test
    fun toggleEstatSwitch_canvia_de_false_a_true() {
        viewModel.toggleEstatSwitch()
        viewModel.toggleEstatSwitch()
        assertEquals(true, viewModel.estatSwitch.value)
    }

    // toggleEsCarnivor

    @Test
    fun toggleEsCarnivor_canvia_de_true_a_false() {
        assertEquals(true, viewModel.esCarnivor.value)
        viewModel.toggleEsCarnivor()
        assertEquals(false, viewModel.esCarnivor.value)
    }

    //  toggleEsVegetaria

    @Test
    fun toggleEsVegetaria_canvia_de_false_a_true() {
        assertEquals(false, viewModel.esVegetaria.value)
        viewModel.toggleEsVegetaria()
        assertEquals(true, viewModel.esVegetaria.value)
    }

    // toggleEsVega

    @Test
    fun toggleEsVega_canvia_de_false_a_true() {
        assertEquals(false, viewModel.esVega.value)
        viewModel.toggleEsVega()
        assertEquals(true, viewModel.esVega.value)
    }

    // toggleTriStateStatus

    @Test
    fun triState_Off_passa_a_Indeterminate() {
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)
    }

    @Test
    fun triState_Indeterminate_passa_a_On() {
        viewModel.toggleTriStateStatus()
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)
    }

    @Test
    fun triState_On_passa_a_Off() {
        viewModel.toggleTriStateStatus()
        viewModel.toggleTriStateStatus()
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    // setSelectedOption

    @Test
    fun setSelectedOption_actualitza_el_valor() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)
    }

    @Test
    fun setSelectedOption_valor_inicial_es_Messi() {
        assertEquals("Messi", viewModel.selectedOption.value)
    }

    // setSliderValue

    @Test
    fun setSliderValue_actualitza_el_valor() {
        viewModel.setSliderValue(75f)
        assertEquals(75f, viewModel.sliderValue.value)
    }

    @Test
    fun sliderValue_valor_inicial_es_0() {
        assertEquals(0f, viewModel.sliderValue.value)
    }

    // setExpanded

    @Test
    fun setExpanded_true_obre_el_dropdown() {
        viewModel.setExpanded(true)
        assertEquals(true, viewModel.expanded.value)
    }

    @Test
    fun setExpanded_false_tanca_el_dropdown() {
        viewModel.setExpanded(true)
        viewModel.setExpanded(false)
        assertEquals(false, viewModel.expanded.value)
    }

    // setSelectedItem

    @Test
    fun setSelectedItem_actualitza_la_selecció() {
        viewModel.setSelectedItem("Opció B")
        assertEquals("Opció B", viewModel.selectedItem.value)
    }

    @Test
    fun selectedItem_valor_inicial_es_Opcio_A() {
        assertEquals("Opció A", viewModel.selectedItem.value)
    }

    // setSearchText

    @Test
    fun setSearchText_actualitza_el_text() {
        viewModel.setSearchText("Hola")
        assertEquals("Hola", viewModel.searchText.value)
    }

    @Test
    fun searchText_valor_inicial_es_buit() {
        assertEquals("", viewModel.searchText.value)
    }

    // performSearch

    @Test
    fun performSearch_mostra_el_snackbar() {
        assertEquals(false, viewModel.showSnackbar.value)
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    // toggle

    @Test
    fun toggle_canvia_de_false_a_true() {
        assertEquals(false, viewModel.toggleState.value)
        viewModel.toggle()
        assertEquals(true, viewModel.toggleState.value)
    }

    @Test
    fun toggle_dues_vegades_torna_a_false() {
        viewModel.toggle()
        viewModel.toggle()
        assertEquals(false, viewModel.toggleState.value)
    }
}