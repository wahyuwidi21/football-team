package com.made.footballteam.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.decode.SvgDecoder
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.made.footballteam.R
import com.made.footballteam.core.domain.model.FootballTeamDetail
import com.made.footballteam.databinding.FragmentDetailTeamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val teamViewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailTeamBinding
    private val args: DetailFragmentArgs by navArgs()
    private val mainNavController by lazy { requireActivity().findNavController(R.id.nav_host_main) }

    private var selectedTeam: FootballTeamDetail? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailTeamBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamViewModel.getTeamDetail(args.id).observe(viewLifecycleOwner) {

            selectedTeam = it.data
            binding.txtName.text = it.data?.name
            binding.txtWebsiteVal.text = it.data?.website
            binding.txtFounded.text = it.data?.founded.toString()
            binding.txtAddress.text = it.data?.address
            binding.txtCountry.text = it.data?.area?.name
            setFavouriteStatus(if (it.data?.isFavorite == null) false else it.data!!.isFavorite!!)
            if (it.data?.crest?.takeLast(3) != "svg") Glide.with(requireContext())
                .load(it.data?.crest)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .centerInside()
                .into(binding.imgCrest)
            else binding.imgCrest.load(it.data!!.crest) {
                decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
            }
        }

        binding.btnFavorite.setOnClickListener {
            selectedTeam.let {
                teamViewModel.setFavoriteTeam(it!!, !it.isFavorite!!)
            }
        }

        binding.btnBack.setOnClickListener {
            mainNavController.navigateUp()
        }
    }


    private fun setFavouriteStatus(status: Boolean) {
        val drawable = if (status) {
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_star_yellow,
                null
            )
        } else {
            ResourcesCompat.getDrawable(
                resources,
                R.drawable.ic_star_grey,
                null
            )
        }
        binding.btnFavorite.setImageDrawable(drawable)
    }
}