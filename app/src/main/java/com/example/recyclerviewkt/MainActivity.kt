package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf(
            Profiles(R.drawable.man, "윤행",25,"아주대학교 소프트웨어학과 학생"),
            Profiles(R.drawable.man, "성호",25,"오른 그 자체"),
            Profiles(R.drawable.woman, "이렐리아",25,"성호 카운터"),
            Profiles(R.drawable.man, "용현",25,"야스오 ban"),
            Profiles(R.drawable.woman, "조이",33,"졸음 너프좀"),
            Profiles(R.drawable.man, "재희",25,"숭실대학교 학생"),
            Profiles(R.drawable.man, "영수",25,"가천대학교 학생"),
            Profiles(R.drawable.man, "현일",25,"치기공사"),
            Profiles(R.drawable.man, "종서",25,"아주대학교 응용화학생명공학과 학생"),
            Profiles(R.drawable.man, "규빈",25,"단국대학교 응용컴퓨터공학과 학생"),
            Profiles(R.drawable.man, "용진",25,"단국대학교 모바일시스템공학과 학생")
        )
        rv_profile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //this(메인 액티비티에 적용), 세로 방향으로 listview 전개
        rv_profile.setHasFixedSize(true)
        rv_profile.adapter = ProfileAdapter(profileList)
    }
}