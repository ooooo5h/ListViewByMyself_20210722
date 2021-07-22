package com.eunhyung.listviewbymyself_20210722

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.eunhyung.listviewbymyself_20210722.adapters.MemoAdapter
import com.eunhyung.listviewbymyself_20210722.datas.Memo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val mMemoList = ArrayList<Memo>()

    lateinit var mAdapter : MemoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMemoList.add( Memo("Hold", "토요일", "On"))
        mMemoList.add( Memo("비전 클리어", "토요일", "추가 테스트 없음"))
        mMemoList.add( Memo("그럼 나 빈손으로 가기 미안한대 제가 밥을...", "토요일", "추가 텍스트 없음"))
        mMemoList.add( Memo("회의하고나면 공유를 해야하는데 공유를 안함", "2021.7.12", "추가 텍스트 없음"))
        mMemoList.add( Memo("8/4 보충수업 날짜로 기억!", "2021.7.9", "추가 텍스트 없음"))
        mMemoList.add( Memo("여행을 기록하는 어플", "2021.7.6", "국내지도 : 줌인 줌 아웃으로 지역..."))
        mMemoList.add( Memo("-20+19*2 38-20=18 ", "2021.7.3", "-20+8*2-24"))
        mMemoList.add( Memo("6/28 연락이 잘된다", "2021.6.29", "6/29 체격이 있다"))
        mMemoList.add( Memo("점빼기", "2021.6.17", "추가 텍스트 없음"))
        mMemoList.add( Memo("여행 #7 양평", "2021.6.3", "롯데렌트카 83,700"))

        mAdapter = MemoAdapter(this, R.layout.memo_list_item, mMemoList)

        memoListView.adapter = mAdapter

        memoListView.setOnItemClickListener { parent, view, position, id ->

            val alert = AlertDialog.Builder(this)
            alert.setTitle("메모 삭제")
            alert.setMessage("메모를 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                mMemoList.removeAt(position)

                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)
            alert.show()


        }

    }
}