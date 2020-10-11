package com.benidict.mainlist

import android.view.View
import android.view.View.VISIBLE
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.benidict.core.base.BaseFragment
import com.benidict.core.databinding.IncludeToolbarBinding
import com.benidict.core.enums.UiState
import com.benidict.core.util.currentDateTime
import com.benidict.mainlist.databinding.FragmentMainListBinding
import com.benidict.mainlist.itemcontroller.ArtistItemController
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainListFragment : BaseFragment<FragmentMainListBinding, IncludeToolbarBinding>(
    FragmentMainListBinding::inflate,
    IncludeToolbarBinding::bind
), SwipeRefreshLayout.OnRefreshListener{

    private val viewModel: MainListViewModel by viewModel()

    /**
     * Lazy load for item controller
     **/
    private val controller by lazy {
        ArtistItemController{
            viewModel.doSaveMediaData.value = it
        }
    }

    override fun onLoadContent() {
        super.onLoadContent()

        /**
         * trigger the api call for artist data
         **/
        viewModel.doLoadArtistList.value = false

        /**
         * check the last visit data that accept boolean function
         **/
        viewModel.doLoadLastVisit.value = true

        /**
         * trigger of saving last visit data that accept strings
         **/
        viewModel.doInsertLastVisit.value = currentDateTime()
    }

    override fun onObserveLiveData() {
        super.onObserveLiveData()
        /**
         * observer for artist list
         **/
        viewModel.loadArtistList.observe(viewLifecycleOwner){
            if (it is UiState.Complete){
                viewBinding.epoxyRecycler.visibility = VISIBLE
                viewBinding.gpEmpty.visibility = View.GONE
                controller.setData(it.data)
            }
            if (it is UiState.Error){
                viewBinding.gpEmpty.visibility = VISIBLE
            }
        }

        /**
         * observer for last visit date
         **/
        viewModel.loadLastVisit.observe(viewLifecycleOwner){
            if (it is UiState.Complete){
                viewBinding.tvDate.text = if(it.data.isEmpty()) "Last visit: " else "Last visit: ${it.data}"
            }
        }

        /**
         * observer for save media data class
         **/
        viewModel.saveMediaData.observe(viewLifecycleOwner){
            if (it is UiState.Complete){
                findNavController().navigate(R.id.action_main_list_to_artist_details)
            }
        }

        viewModel.insertLastVisit.observe(viewLifecycleOwner){}
    }

    override fun onSetUpView() {
        super.onSetUpView()
        viewBinding.swipeRefresh.setOnRefreshListener(this)
        viewBinding.epoxyRecycler.apply {
            setController(controller)
        }
        viewBinding.viewRefresh.setOnClickListener {
            viewBinding.gpEmpty.visibility = View.GONE
            onRefresh()
        }
        includeBinding?.tvTitleToolbar?.text = "ALBUM"
    }

    override fun onRefresh() {
        controller.setData(listOf())
        viewModel.doLoadArtistList.value = true
        viewBinding.swipeRefresh.isRefreshing = false
    }
}