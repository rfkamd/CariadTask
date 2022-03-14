package com.cariad.app.ui.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cariad.app.databinding.BottomsheetPoiDetailBinding
import com.cariad.app.models.POI
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class POIDetailBottomsheet : BottomSheetDialogFragment() {

    companion object {
        val TAG = "POIDetailBottomsheet"

        fun instance(poi: POI): POIDetailBottomsheet {
            var fragment = POIDetailBottomsheet()
            fragment.poi = poi
            return fragment
        }

    }

    private lateinit var poi: POI
    private lateinit var binding: BottomsheetPoiDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomsheetPoiDetailBinding.inflate(inflater, container, false)
        return binding.bottomsheet
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtTitle.text = poi!!.OperatorInfo!!.Title
        binding.txtAddress.text =
            poi!!.AddressInfo!!.AddressLine1
        binding.txtChargingStations.text = poi!!.NumberOfPoints.toString()

    }

}