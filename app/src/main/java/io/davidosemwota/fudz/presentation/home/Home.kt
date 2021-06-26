package io.davidosemwota.fudz.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.davidosemwota.fudz.databinding.HomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for Home screen.
 */
class Home : Fragment() {

    private lateinit var viewBinding: HomeBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = HomeBinding.inflate(inflater)
        return viewBinding.root
    }
}