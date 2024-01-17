package com.brjewels.admin.android.activity.tabbar.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.brjewels.admin.android.R
import com.brjewels.admin.android.databinding.FragmentHomeBinding
import com.brjewels.admin.android.models.DailyRatesUpdateModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlin.math.roundToInt

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var db = Firebase.firestore


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater , container , false)

        rateUpdates()
        topStatusBar()

        return binding.root
    }


    @SuppressLint("SetTextI18n")
    private fun rateUpdates() {
        db = Firebase.firestore


        db.collection("today_rate").orderBy("date" , Query.Direction.DESCENDING)
            .limit(1)
            .get()
            .addOnSuccessListener {
                if (it != null && !it.isEmpty) {
                    val latestDocument = it.documents[0]
                    val rate = latestDocument.toObject(DailyRatesUpdateModel::class.java)

                    if (rate != null) {

                        val date = rate.date?.toDate()
                        val formattedDate = date.toString()
                        val lastUpdatedDate =rate.createdAt?.toDate()
                        val formattedLastUpdatedDate = lastUpdatedDate.toString()

                        binding.todaysDate.text = "Today's Date : ${convertFirebaseToLocalDate(formattedDate)}"
                        binding.lastUpdatedTodaysRate.text = "Last Updated : ${convertLastUpdatedToLocalDate(formattedLastUpdatedDate)}"

                        //Gold Rates Updates
                        rate.gold?.forEachIndexed { index, goldModel ->
                            if (index == 0) {
                                binding.hallmarkGoldQuality.text = goldModel.quality
                                binding.pureGoldTola.text = goldModel.price?.roundToInt().toString()
                            } else if (index == 1) {
                                binding.tejabiGoldQuality.text = goldModel.quality
                                binding.tejabiGoldTola.text = goldModel.price?.roundToInt().toString()
                            } else if (index == 2) {
                                binding.pureGoldGram.text = goldModel.price?.roundToInt().toString()
                            } else if (index == 3) {
                                binding.tejabiGoldGram.text = goldModel.price?.roundToInt().toString()
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Sorry ! No Data Has Been Found",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        // Silver Rates Updates

                        rate.silver?.forEachIndexed { index, silverModel ->
                            if (index == 0 ){
                                binding.hallmarkSilverQuality.text = silverModel.quality
                                binding.silverTola.text = silverModel.price?.roundToInt().toString()
                            }else if (index == 1){
                                binding.silverGram.text = silverModel.price?.roundToInt().toString()
                            }
                        }


                    }
                }
            }
            .addOnFailureListener { }

    }

    private fun convertFirebaseToLocalDate(oldDate: String): String {
        val inputDateFormat = java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.US)
        val outputDateFormat = java.text.SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)

        inputDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputDateFormat.parse(oldDate)

        outputDateFormat.timeZone = TimeZone.getDefault()
        return outputDateFormat.format(date ?: Date())
    }

    private fun convertLastUpdatedToLocalDate(oldDate: String): String {
        val inputDateFormat = java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.US)
        val outputDateFormat = java.text.SimpleDateFormat("MMM dd, yyyy  hh :mm a", Locale.ENGLISH)

        inputDateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputDateFormat.parse(oldDate)

        outputDateFormat.timeZone = TimeZone.getDefault()
        return outputDateFormat.format(date ?: Date())
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun topStatusBar(){
        val currentDateTime = LocalDateTime.now()
        val currentTime = LocalTime.now()
        val formatterTopBarDate = DateTimeFormatter.ofPattern("EEEE MMM d yyyy" , Locale.ENGLISH)
        val formatterTopBarTime = DateTimeFormatter.ofPattern("h:mm a")
        val nineAm = LocalTime.of(9 , 0)
        val sixPm = LocalTime.of(18 , 0)


        binding.topBarDate.text = currentDateTime.format(formatterTopBarDate)
        binding.topBarTime.text = currentDateTime.format(formatterTopBarTime)

        if (currentTime.isAfter(nineAm) && currentTime.isBefore(sixPm)){
            binding.topBarShopStatus.text = "Open"
        }else{
            binding.topBarShopStatus.text = "Closed"
        }


    }
}