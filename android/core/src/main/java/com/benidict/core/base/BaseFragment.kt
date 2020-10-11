package com.benidict.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

/**
 * @param VB for fragment view binding this is required.
 * @param TB for included view binding layout inside fragment, this is not required.
 **/
abstract class BaseFragment<VB: ViewBinding, TB: ViewBinding>(
    private val setupViewBinding: (LayoutInflater) -> VB,
    private val includeViewBinding: ((View) -> TB)? = null
): Fragment(){

    lateinit var viewBinding: VB
    var includeBinding: TB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = setupViewBinding(inflater)
        includeViewBinding?.let {
            includeBinding = it(viewBinding.root)
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadContent()
        onSetUpView()
        onObserveLiveData()
    }

    /**
     * Override for back press event
     **/
    open fun handleOnBackPressed() {
        findNavController().navigateUp()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                this@BaseFragment.handleOnBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this,callback)
    }


    /**
     * Override for trigger remote/local data source
     **/
    open fun onLoadContent(){}

    /**
     * Override for setup the observer
     **/
    open fun onObserveLiveData(){}

    /**
     * Override for setup the views
     **/
    open fun onSetUpView(){}
}