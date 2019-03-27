package habit.mvvm.pst.ui.base;


import android.databinding.BindingAdapter;
import android.widget.ImageView;

import habit.mvvm.pst.R;

public class ViewBindingAdapter {
    public ViewBindingAdapter(){

    }




    /**
     * 设置recyclerview 方向
     * @param view
     * @param str
     * @param src
     */
    @BindingAdapter(value = {"android:imagesrc"}, requireAll = false)
    public static void setRecyclerviewFX(ImageView view, int src) {
        view.setImageResource(src);
    }





}
