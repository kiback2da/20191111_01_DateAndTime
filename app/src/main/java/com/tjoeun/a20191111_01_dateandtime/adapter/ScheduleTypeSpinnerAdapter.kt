package com.tjoeun.a20191111_01_dateandtime.adapter

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextClock
import android.widget.TextView
import com.tjoeun.a20191111_01_dateandtime.R
import com.tjoeun.a20191111_01_dateandtime.datas.ScheduleType
import org.w3c.dom.Text

class ScheduleTypeSpinnerAdapter(context: Context, res:Int, list:ArrayList<ScheduleType>) : ArrayAdapter<ScheduleType>(context,res,list){

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<ScheduleType>) : this(context, R.layout.schedule_type_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.schedule_type_view_item, null)
        }

        var row = tempRow!!

        var list = mList.get(position)
        var listTitle = row.findViewById<TextView>(R.id.listTitle)
        var listContent = row.findViewById<TextView>(R.id.listContent)

        listTitle.text = list.title.split(" ")[0]
        listContent.text = list.title
        listTitle.setBackgroundColor(Color.parseColor(list.color))


        return row
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.schedule_type_list_item, null)
        }

        var row = tempRow!!

        var list = mList.get(position)
        var title = row.findViewById<TextView>(R.id.typeTitle)
        var content = row.findViewById<TextView>(R.id.typeContent)

        title.text = list.title.split(" ")[0]
        content.text = list.title

        title.setBackgroundColor(Color.parseColor(list.color))
        return row
    }
}