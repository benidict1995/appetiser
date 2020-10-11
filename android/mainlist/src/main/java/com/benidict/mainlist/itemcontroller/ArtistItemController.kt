package com.benidict.mainlist.itemcontroller

import com.airbnb.epoxy.TypedEpoxyController
import com.benidict.core.util.toJson
import com.benidict.domain.model.MediaData
import com.benidict.mainlist.itemmodel.artistItem

/**
 * @param actionItem this param is higher order function that return media data class
 **/
class ArtistItemController(
    private val actionItem: (MediaData) -> Unit
): TypedEpoxyController<List<MediaData>>(){


    override fun buildModels(data: List<MediaData>) {
        val size = data.size
        for (i in 0 until size){
            artistItem {
                id(i)
                artist(data[i])
                clickListener { data, _, _, _ ->
                    actionItem(data.artist())
                }
            }
        }
    }
}
