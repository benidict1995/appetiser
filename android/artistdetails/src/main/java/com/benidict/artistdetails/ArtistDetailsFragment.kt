package com.benidict.artistdetails

import android.view.View.VISIBLE
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.benidict.artistdetails.databinding.FragmentArtistDetailsBinding
import com.benidict.core.base.BaseFragment
import com.benidict.core.databinding.IncludeToolbarBinding
import com.benidict.core.enums.UiState
import com.benidict.core.util.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistDetailsFragment : BaseFragment<FragmentArtistDetailsBinding, IncludeToolbarBinding>(
    FragmentArtistDetailsBinding::inflate,
    IncludeToolbarBinding::bind
){

    private val viewModel: ArtistDetailsViewModel by viewModel()

    override fun onLoadContent() {
        super.onLoadContent()
        /**
         * trigger call for artist details, this call required boolean value it's either false or true.
         **/
        viewModel.doLoadArtistDetails.value = true
    }

    override fun onObserveLiveData() {
        super.onObserveLiveData()

        /**
         * Observer for artist details
        **/
        viewModel.loadArtistDetails.observe(viewLifecycleOwner){
            if (it is UiState.Complete){
                viewBinding.ivArtWork.loadImage(it.data?.artworkUrl100)
                viewBinding.tvDescription.text = if(it.data?.longDescription.isNullOrEmpty()) it.data?.shortDescription else it.data?.longDescription
                viewBinding.tvGenre.text = it.data?.primaryGenreName
                viewBinding.tvPrice.text = "$${it.data?.trackPrice}"
                viewBinding.tvTrackName.text = it.data?.trackName
                includeBinding?.tvTitleToolbar?.text = it.data?.trackName
            }
        }

        /**
         * Observer for delete cache of artist details.
         **/
        viewModel.removeArtistDetails.observe(viewLifecycleOwner){
            if (it is UiState.Complete){
                findNavController().navigate(R.id.action_artist_detials_to_main_list)
            }
        }
    }

    override fun onSetUpView() {
        super.onSetUpView()
        includeBinding?.ivBackToolbar?.visibility = VISIBLE
        includeBinding?.ivBackToolbar?.setOnClickListener {
            /**
             * trigger call for remove artist details, this call required boolean value it's either false or true.
             **/
                viewModel.doRemoveArtistDetails.value = true
        }
    }

}