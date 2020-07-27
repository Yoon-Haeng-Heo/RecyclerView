package com.example.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ProfileAdapter(val profileList : ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //List item을 붙여주는 작업 진행
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false) // context란 액티비티에서 담고있는 모든 정보를 말함
        //여기서는 어댑터랑 연결될 액티비티의 context를 가져오는 것.
        //inflate을 통해 view를 만들고
        return CustomViewHolder(view).apply {
            //recyclerview 에 클릭했을 때의 리스너 구현
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition //현재 포지션
                val profile : Profiles  = profileList.get(curPos) //클릭을 하면 현재 누가 클릭됬는지
                Toast.makeText(parent.context,"name : ${profile.name}, age : ${profile.age} ,job : ${profile.job}",Toast.LENGTH_SHORT ).show()
            }
        }
        //이를 통해서 customviewholder에 전달해주고 customviewholder가 실행되면 생성자의 변수인 itemview에 전달이 됨
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //onclickviewholder에서 만들어진 view를 가져다가 bind
        //스크롤같은 이벤트가 발생했을 때 지속적으로 이 함수가 호출됨
        //이미 List는 메인에서 준비되어서 어댑터로 넘겨받음 그래서 그 리스트로 접근하는 것
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job
    }
    //이제 viewholder에 profiles를 적용시킬것
    class CustomViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile)  //성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)        //이름
        val age = itemView.findViewById<TextView>(R.id.tv_age)          //나이
        val job = itemView.findViewById<TextView>(R.id.tv_job)          //직업
    }
}