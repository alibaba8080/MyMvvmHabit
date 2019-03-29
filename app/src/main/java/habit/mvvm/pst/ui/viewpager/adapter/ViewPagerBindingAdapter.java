package habit.mvvm.pst.ui.viewpager.adapter;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import habit.mvvm.pst.ui.viewpager.viewmodel.ViewPagerItemViewModel;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;


/**
 * Created by goldze on 2018/6/21.
 */

public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<ViewPagerItemViewModel> {

    @Override
    public void onBindBinding(final ViewDataBinding binding, int variableId, int layoutRes, final int position, ViewPagerItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        //这里可以强转成ViewPagerItemViewModel对应的ViewDataBinding，
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
