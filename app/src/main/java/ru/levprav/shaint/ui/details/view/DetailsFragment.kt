package ru.levprav.shaint.ui.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import org.koin.android.ext.android.inject
import ru.levprav.shaint.R
import ru.levprav.shaint.databinding.FragmentDetailsBinding
import ru.levprav.shaint.domain.model.Product
import ru.levprav.shaint.ui.details.presenter.DetailsPresenter


class DetailsFragment : Fragment(), DetailsView {


    private val presenter: DetailsPresenter by inject()

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getProductById(1) // change it!
    }

    override fun showProductDetails(movie: Product) {
        binding.apply {
            Glide.with(requireView())
                .load(movie.imageUri)
                .placeholder(R.drawable.non_image)
                .into(productImageIv)

            toolbar.title = movie.name
            toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            productNameTv.text = movie.name
            productIdTv.append(movie.id.toString())
            productTypeTv.append(movie.type)
            movieDescriptionTv.text = movie.details
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetachView()
        _binding = null
    }
}