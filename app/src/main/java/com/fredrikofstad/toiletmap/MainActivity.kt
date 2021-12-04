package com.fredrikofstad.toiletmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fredrikofstad.toiletmap.models.ToiletInfo
import com.fredrikofstad.toiletmap.models.UserMap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userMaps = testData()

        //Set layout on RV
        rvMaps.layoutManager = LinearLayoutManager(this)
        //set adapter on RV
        rvMaps.adapter = MapsAdapter(this, userMaps)
    }

    private fun testData(): List<UserMap> {
        return listOf(
            UserMap(
                "Blindern Restrooms",
                listOf(
                    ToiletInfo("Library bathroom", "B1 at Georg Sverdrup", 59.9391487967847, 10.721724327774968),
                    ToiletInfo("Frederikke", "1F beneath cafeteria", 59.940543393898515, 10.721566077431005),
                    ToiletInfo("Sophus Bugge", "B1 next to Uglebo", 59.94155850468881, 10.723020801995578)
                )
            ),
            UserMap("Oslo S",
                listOf(
                    ToiletInfo("Oslo S Public toilet", "uff", 59.91127374996412, 10.752456873953543)
                )
            )
        )
    }

}