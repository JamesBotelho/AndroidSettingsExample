package br.com.jmsdevel.settingsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import br.com.jmsdevel.settingsexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        loadSettings()
        return fragmentHomeBinding.root
    }

    private fun loadSettings() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireActivity())

        sharedPreferences?.let { sp ->
            fragmentHomeBinding.size = sp.getInt("size", 0)
            fragmentHomeBinding.signature = sp.getString("signature", "Not set")
            fragmentHomeBinding.reply = sp.getString("reply", "Not set")
            fragmentHomeBinding.sync = sp.getBoolean("sync", false)
            fragmentHomeBinding.attachments = sp.getBoolean("attachment", false)
        }
    }
}