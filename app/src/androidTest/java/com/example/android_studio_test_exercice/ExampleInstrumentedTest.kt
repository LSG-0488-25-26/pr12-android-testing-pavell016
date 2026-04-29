package com.example.android_studio_test_exercice

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android_studio_test_exercice.view.MainView
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchView(): MainViewModel {
        val viewModel = MainViewModel()
        composeTestRule.setContent {
            MainView(myViewModel = viewModel)
        }
        return viewModel
    }

    // Switch Wi-Fi

    @Test
    fun switch_wifi_existeix_i_esta_activat() {
        launchView()
        composeTestRule.onNodeWithTag("switch_wifi").assertIsDisplayed()
        composeTestRule.onNodeWithTag("switch_wifi").assertIsOn()
    }

    @Test
    fun switch_wifi_click_el_desactiva() {
        launchView()
        composeTestRule.onNodeWithTag("switch_wifi").performClick()
        composeTestRule.onNodeWithTag("switch_wifi").assertIsOff()
    }

    //  Checkboxes

    @Test
    fun checkbox_carnivor_esta_desactivat_i_marcat() {
        launchView()
        composeTestRule.onNodeWithTag("checkbox_carnivor")
            .assertIsDisplayed()
            .assertIsNotEnabled()
    }

    @Test
    fun checkbox_vegetaria_click_el_marca() {
        launchView()
        composeTestRule.onNodeWithTag("checkbox_vegetaria")
            .assertIsDisplayed()
            .assertIsEnabled()
            .performClick()
        composeTestRule.onNodeWithTag("checkbox_vegetaria").assertIsOn()
    }

    @Test
    fun checkbox_vega_click_el_marca() {
        launchView()
        composeTestRule.onNodeWithTag("checkbox_vega")
            .assertIsDisplayed()
            .performClick()
        composeTestRule.onNodeWithTag("checkbox_vega").assertIsOn()
    }

    //  TriState

    @Test
    fun tristate_existeix_i_es_pot_clicar() {
        launchView()
        composeTestRule.onNodeWithTag("tristate_checkbox").assertIsDisplayed()
        composeTestRule.onNodeWithTag("tristate_checkbox").performClick()
        // Després del primer click passa a Indeterminate
        composeTestRule.onNodeWithTag("tristate_checkbox").assertIsDisplayed()
    }

    //  RadioButtons

    @Test
    fun radio_vinicius_esta_deshabilitat() {
        launchView()
        composeTestRule.onNodeWithTag("radio_Vinicius").assertIsNotEnabled()
    }

    @Test
    fun radio_lamine_yamal_click_el_selecciona() {
        launchView()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal")
            .assertIsEnabled()
            .performClick()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").assertIsSelected()
    }

    @Test
    fun radio_raphina_click_el_selecciona() {
        launchView()
        composeTestRule.onNodeWithTag("radio_Raphina").performClick()
        composeTestRule.onNodeWithTag("radio_Raphina").assertIsSelected()
    }

    //  Slider

    @Test
    fun slider_existeix_i_es_mostra() {
        launchView()
        composeTestRule.onNodeWithTag("slider_volum").assertIsDisplayed()
    }

    @Test
    fun slider_canvi_de_valor_actualitza_text() {
        launchView()
        composeTestRule.onNodeWithTag("slider_volum")
            .performSemanticsAction(androidx.compose.ui.semantics.SemanticsActions.SetProgress) {
                it(50f)
            }
        composeTestRule.onNodeWithText("Volum: 50%").assertIsDisplayed()
    }

    //  Dropdown

    @Test
    fun dropdown_click_obre_el_menu() {
        launchView()
        composeTestRule.onNodeWithTag("dropdown_text").performClick()
        composeTestRule.onNodeWithTag("dropdown_item_Opció B").assertIsDisplayed()
    }

    @Test
    fun dropdown_seleccio_opcio_b_actualitza_text() {
        launchView()
        composeTestRule.onNodeWithTag("dropdown_text").performClick()
        composeTestRule.onNodeWithTag("dropdown_item_Opció B").performClick()
        composeTestRule.onNodeWithTag("dropdown_text").assertTextEquals("Opció B")
    }

    // TextField

    @Test
    fun search_field_existeix_i_accepta_text() {
        launchView()
        composeTestRule.onNodeWithTag("search_field")
            .assertIsDisplayed()
            .performTextInput("Android")
        composeTestRule.onNodeWithTag("search_field").assertTextContains("Android")
    }

    @Test
    fun boto_buscar_click_mostra_snackbar() {
        launchView()
        composeTestRule.onNodeWithTag("btn_buscar").performClick()
        composeTestRule.onNodeWithTag("snackbar_text").assertIsDisplayed()
        composeTestRule.onNodeWithText("Acció completada!").assertIsDisplayed()
    }

    // Botó toggle

    @Test
    fun boto_toggle_inicial_mostra_desactivat_en_vermell() {
        launchView()
        composeTestRule.onNodeWithTag("btn_toggle")
            .assertIsDisplayed()
            .assertTextEquals("Desactivat")
    }

    @Test
    fun boto_toggle_click_canvia_a_activat() {
        launchView()
        composeTestRule.onNodeWithTag("btn_toggle").performClick()
        composeTestRule.onNodeWithTag("btn_toggle").assertTextEquals("Activat")
    }

    @Test
    fun boto_toggle_doble_click_torna_a_desactivat() {
        launchView()
        composeTestRule.onNodeWithTag("btn_toggle").performClick()
        composeTestRule.onNodeWithTag("btn_toggle").performClick()
        composeTestRule.onNodeWithTag("btn_toggle").assertTextEquals("Desactivat")
    }
}