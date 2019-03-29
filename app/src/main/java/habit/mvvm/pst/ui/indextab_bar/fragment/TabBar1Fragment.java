package habit.mvvm.pst.ui.indextab_bar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import habit.mvvm.pst.BR;
import habit.mvvm.pst.R;
import habit.mvvm.pst.databinding.FragmentTabBar1Binding;
import habit.mvvm.pst.ui.indextab_bar.viewmodel.TabBar1ViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by goldze on 2018/7/18.
 */

public class TabBar1Fragment extends BaseFragment<FragmentTabBar1Binding, TabBar1ViewModel> {
    private int toolBarPositionY=0;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_1;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        // 使用 TabLayout 和 ViewPager 相关联
        binding.tabs.setupWithViewPager(binding.viewPager);
//        binding.tabs.setTabMode(TabLayout.MODE_FIXED);
    }

}
