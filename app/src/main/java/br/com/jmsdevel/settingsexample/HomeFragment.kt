package br.com.jmsdevel.settingsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.jmsdevel.settingsexample.databinding.FragmentHomeBinding
import br.com.jmsdevel.settingsexample.databinding.FragmentHomeBindingImpl

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
        return fragmentHomeBinding.root
    }
}