package com.eunhyung.listviewbymyself_20210722.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.eunhyung.listviewbymyself_20210722.R
import com.eunhyung.listviewbymyself_20210722.datas.Memo
import java.util.*

//class MemoAdapter(val mContext : , val resId : R.id., val mList : ArrayList<Memo>) : ArrayAdapter<Memo> {
//}

class MemoAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Memo>) : ArrayAdapter<Memo>(mContext, resId, mList) {



    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inflater.inflate(R.layout.memo_list_item, null)
        }

        val row = tempRow!!

        val memo = mList[position]

        val contentTxt = row.findViewById<TextView>(R.id.contentTxt)
        val dateTxt = row.findViewById<TextView>(R.id.dateTxt)
        val simpleTxt = row.findViewById<TextView>(R.id.simpleTxt)

        contentTxt.text = memo.content
        dateTxt.text = memo.date
        simpleTxt.text =memo.simpleView

        return row


    }


}





