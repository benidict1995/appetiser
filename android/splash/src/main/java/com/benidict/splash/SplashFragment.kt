package com.benidict.splash

import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.benidict.core.base.BaseFragment
import com.benidict.core.enums.UiState
import com.benidict.splash.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment<FragmentSplashBinding, Nothing>(
    FragmentSplashBinding::inflate
){

    private val viewModel: SplashViewModel by viewModel()

    override fun onLoadContent() {
        super.onLoadContent()
        /**
         * trigger for check artist details
         **/
        viewModel.doCheckArtistDetails.value = true
    }

    override fun onObserveLiveData() {
        super.onObserveLiveData()
        /**
         * observer for artist details
         **/
        viewModel.checkArtistDetails.observe(viewLifecycleOwner){
            viewBinding.pdSplash.isVisible = it == UiState.Loading
            if (it is UiState.Complete){
                if (it.data?.artistName.isNullOrEmpty()){
                    findNavController().navigate(R.id.action_splash_to_mainlist)
                }else{
                    findNavController().navigate(R.id.action_splash_to_artist_details)
                }
            }

            if (it is UiState.Error){
                findNavController().navigate(R.id.action_splash_to_mainlist)
            }
        }
    }

}