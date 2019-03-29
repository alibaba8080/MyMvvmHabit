package habit.mvvm.pst.ui.indextab_bar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import habit.mvvm.pst.BR;
import habit.mvvm.pst.R;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by goldze on 2018/7/18.
 */

public class TabBar3Fragment extends BaseFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_3;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
