package yue.starview.excample.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 封装的ViewHolder工具类。用于Adapter的getView方法中
 */
public class ViewHolder {

//	private final HashMap<Integer,View> mViews;
	private final SparseArray<View> holder;
	private View convertView;
	
	private ViewHolder(Context context,View convertView, ViewGroup parent, int layoutId,int position) {
		convertView = LayoutInflater.from(context).inflate(layoutId, parent,false);
		holder = new SparseArray<View>();
		convertView.setTag(this);
		this.convertView = convertView;
	}
	public static ViewHolder getHolder(Context context, View convertView,ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, convertView, parent, layoutId, position);
		}
		return (ViewHolder) convertView.getTag();
	}
	public View getConvertView(){
		return convertView;
	}

	@SuppressWarnings("unchecked")
	public <T> T getView(int id) {
		View childView = (View) holder.get(id);
		if (childView == null) {
			childView = convertView.findViewById(id);
			holder.put(id, childView);
		}
		return (T) childView;
	}
//	public static <T>T getView(View converrView,int id){
//		if (holder == null) {
//			holder = new SparseArray<View>();
//		}
//		View childView = (View) holder.get(id);
//		if (childView == null) {
//			childView = convertView.findViewById(id);
//			holder.put(id, childView);
//		}
//		return (T) childView;
//	}
}