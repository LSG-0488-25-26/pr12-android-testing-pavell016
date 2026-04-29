package com.example.android_studio_test_exercice.viewmodel

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _estatSwitch = MutableLiveData<Boolean>(true)
    val estatSwitch: LiveData<Boolean> = _estatSwitch

    private val _esVegetaria = MutableLiveData<Boolean>(false)
    val esVegetaria: LiveData<Boolean> = _esVegetaria

    private val _esVega = MutableLiveData<Boolean>(false)
    val esVega: LiveData<Boolean> = _esVega

    private val _esCarnivor = MutableLiveData<Boolean>(true)
    val esCarnivor: LiveData<Boolean> = _esCarnivor

    private val _triStateStatus = MutableLiveData<ToggleableState>(ToggleableState.Off)
    val triStateStatus: LiveData<ToggleableState> = _triStateStatus

    private val _selectedOption = MutableLiveData<String>("Messi")
    val selectedOption: LiveData<String> = _selectedOption

    private val _sliderValue = MutableLiveData<Float>(0f)
    val sliderValue: LiveData<Float> = _sliderValue

    private val _expanded = MutableLiveData<Boolean>(false)
    val expanded: LiveData<Boolean> = _expanded

    private val _selectedItem = MutableLiveData<String>("Opció A")
    val selectedItem: LiveData<String> = _selectedItem

    private val _searchText = MutableLiveData<String>("")
    val searchText: LiveData<String> = _searchText

    private val _showSnackbar = MutableLiveData<Boolean>(false)
    val showSnackbar: LiveData<Boolean> = _showSnackbar

    private val _toggleState = MutableLiveData<Boolean>(false)
    val toggleState: LiveData<Boolean> = _toggleState

    // --- Mètodes existents ---

    fun toggleEstatSwitch() {
        _estatSwitch.value = !(_estatSwitch.value!!)
    }

    fun toggleEsCarnivor() {
        _esCarnivor.value = !(_esCarnivor.value!!)
    }

    fun toggleTriStateStatus() {
        when (_triStateStatus.value) {
            ToggleableState.On          -> setTriStateStatus(ToggleableState.Off)
            ToggleableState.Off         -> setTriStateStatus(ToggleableState.Indeterminate)
            ToggleableState.Indeterminate -> setTriStateStatus(ToggleableState.On)
            null                        -> setTriStateStatus(ToggleableState.On)
        }
    }

    private fun setTriStateStatus(triState: ToggleableState) {
        _triStateStatus.value = triState
    }


    fun toggleEsVegetaria() {
        _esVegetaria.value = !(_esVegetaria.value!!)
    }

    fun toggleEsVega() {
        _esVega.value = !(_esVega.value!!)
    }

    fun setSelectedOption(option: String) {
        _selectedOption.value = option
    }

    fun setSliderValue(value: Float) {
        _sliderValue.value = value
    }

    fun setExpanded(value: Boolean) {
        _expanded.value = value
    }

    fun setSelectedItem(item: String) {
        _selectedItem.value = item
    }

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun performSearch() {
        _showSnackbar.value = true
    }

    fun toggle() {
        _toggleState.value = !(_toggleState.value!!)
    }
}