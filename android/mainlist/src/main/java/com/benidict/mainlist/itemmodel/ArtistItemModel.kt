package com.benidict.mainlist.itemmodel

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.benidict.core.ui.KotlinEpoxyHolder
import com.benidict.core.util.loadImage
import com.benidict.domain.model.MediaData
import com.benidict.mainlist.R
import com.google.android.material.textview.MaterialTextView

@EpoxyModelClass
abstract class ArtistItemModel : EpoxyModelWithHolder<ArtistItemModel.Holder>(){

    @EpoxyAttribute
    lateinit var artist: MediaData

    @EpoxyAttribute
    lateinit var clickListener: View.OnClickListener

    override fun getDefaultLayout(): Int = R.layout.item_artist

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvName.text = if(artist.trackName.isNullOrEmpty()) "N/A" else artist.trackName
        holder.tvGenre.text = artist.primaryGenreName
        if (!artist.trackPrice.isNullOrEmpty()){
            holder.tvPrice.text = "$ ${artist.trackPrice}"
        }
        holder.ivArtWork.loadImage(artist.artworkUrl60)
        holder.rootLayout.setOnClickListener(clickListener)
    }

    class Holder: KotlinEpoxyHolder(){
        val tvName by bind<MaterialTextView>(R.id.tv_track_name)
        val tvGenre by bind<MaterialTextView>(R.id.tv_genre)
        val tvPrice by bind<MaterialTextView>(R.id.tv_price)
        val ivArtWork by bind<ImageView>(R.id.iv_art_work)
        val rootLayout by bind<ConstraintLayout>(R.id.root_layout)
    }
}