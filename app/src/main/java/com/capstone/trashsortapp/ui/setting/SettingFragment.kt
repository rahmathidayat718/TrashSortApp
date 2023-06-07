package com.capstone.trashsortapp.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.trashsortapp.R

class SettingFragment : Fragment() {

    private lateinit var viewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        viewModel = ViewModelProvider(this).get(SettingViewModel::class.java)

        // Inisialisasi dark mode switch
        val switchDarkMode = view.findViewById<Switch>(R.id.switch_theme)
        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setDarkModeEnabled(isChecked)
        }

        // Observasi perubahan dark mode
        viewModel.darkModeEnabled.observe(viewLifecycleOwner) { enabled ->
            // Terapkan perubahan dark mode ke tampilan fragment
            if (enabled) {
                // Terapkan dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Matikan dark mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}